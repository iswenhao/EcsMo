package com.lingtong.RemedyTools;

import java.io.File;
import java.util.Calendar;
import org.apache.log4j.Logger;
//import java.math.BigDecimal;
import com.remedy.arsys.api.ARServerUser;
import com.remedy.arsys.api.AttachmentInfo;
import com.remedy.arsys.api.Constants;
import com.remedy.arsys.api.DataType;
import com.remedy.arsys.api.DateInfo;
import com.remedy.arsys.api.Timestamp;
//import com.remedy.arsys.api.Diary;
import com.remedy.arsys.api.Entry;
import com.remedy.arsys.api.EntryFactory;
import com.remedy.arsys.api.EntryID;
import com.remedy.arsys.api.EntryItem;
//import com.remedy.arsys.api.Keyword;
import com.remedy.arsys.api.NameID;
//import com.remedy.arsys.api.Time;
//import com.remedy.arsys.api.Timestamp;
import com.remedy.arsys.api.Util;
import com.remedy.arsys.api.Value;

public class EntryHandler {
//	public static final int AR_DATA_TYPE_NULL = Constants.AR_DATA_TYPE_NULL;
//	public static final int AR_DATA_TYPE_KEYWORD = Constants.AR_DATA_TYPE_KEYWORD;
	public static final int AR_DATA_TYPE_INTEGER = Constants.AR_DATA_TYPE_INTEGER;
//	public static final int AR_DATA_TYPE_REAL = Constants.AR_DATA_TYPE_REAL;
	public static final int AR_DATA_TYPE_CHAR = Constants.AR_DATA_TYPE_CHAR;
//	public static final int AR_DATA_TYPE_DIARY = Constants.AR_DATA_TYPE_DIARY;
	public static final int AR_DATA_TYPE_ENUM = Constants.AR_DATA_TYPE_ENUM;
	public static final int AR_DATA_TYPE_TIME = Constants.AR_DATA_TYPE_TIME;
	public static final int AR_DATA_TYPE_DATE = Constants.AR_DATA_TYPE_DATE;
//	public static final int AR_DATA_TYPE_TIME_OF_DAY = Constants.AR_DATA_TYPE_TIME_OF_DAY;
//	public static final int AR_DATA_TYPE_BITMASK = Constants.AR_DATA_TYPE_BITMASK;
//	public static final int AR_DATA_TYPE_BYTES = Constants.AR_DATA_TYPE_BYTES;
//	public static final int AR_DATA_TYPE_JOIN = Constants.AR_DATA_TYPE_JOIN;
//	public static final int AR_DATA_TYPE_TRIM = Constants.AR_DATA_TYPE_TRIM;
//	public static final int AR_DATA_TYPE_CONTROL = Constants.AR_DATA_TYPE_CONTROL;
//	public static final int AR_DATA_TYPE_PAGE = Constants.AR_DATA_TYPE_PAGE;
//	public static final int AR_DATA_TYPE_PAGE_HOLDER = Constants.AR_DATA_TYPE_PAGE_HOLDER;
//	public static final int AR_DATA_TYPE_ATTACH_POOL = Constants.AR_DATA_TYPE_ATTACH_POOL;
	public static final int AR_DATA_TYPE_ULONG = Constants.AR_DATA_TYPE_ULONG;
//	public static final int AR_DATA_TYPE_COORDS = Constants.AR_DATA_TYPE_COORDS;
	public static final int AR_DATA_TYPE_ATTACH = Constants.AR_DATA_TYPE_ATTACH;
//	public static final int AR_DATA_TYPE_DECIMAL = Constants.AR_DATA_TYPE_DECIMAL;
//	public static final int AR_DATA_TYPE_CURRENCY = Constants.AR_DATA_TYPE_CURRENCY;
//	public static final int AR_DATA_TYPE_VIEW = Constants.AR_DATA_TYPE_VIEW;
//	public static final int AR_DATA_TYPE_DISPLAY = Constants.AR_DATA_TYPE_DISPLAY;

	private static Logger logger = Logger.getLogger(EntryHandler.class);
	private	ARServerUser serverUser = null;
	private	 ARServerUser newServerUser = null;
	private String server = null;
	private int port = 0;
	private String username = null;
	private String password = null;
	private boolean bLogin = false;
	private static java.text.SimpleDateFormat dFmt = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	public EntryHandler(String server, int port, String username, String password) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.password = password;
	}
/**
 * 
 * @Description 用于登陆API
 * @author 闻浩
 * @Date 2014-12-19上午10:07:32
 * @package_name com.ultrapower.ifc.remedy
 * @return 登陆成功返回TRUE 失败返回FALSE
  public boolean login(String username) {
  }
 */
	public boolean login() {
		//首先登陆达到REMEDY服务
		try {
			logger.info("ar login : " + username + ":" + password + "@" + server + ":" + port);
			serverUser = new ARServerUser(username, password, null, server, port);
			Util.ARSetServerPort(serverUser, new NameID(server), port, 0);
			serverUser.login();
			bLogin = true;
			logger.info("ar login successfully !");
			return true;
		} catch (Exception e) {
			logger.error("ar login exception : " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public boolean logout() {
		try {
			serverUser.logout();
			serverUser.clear();
			serverUser = null;
			//登出新系统
			if(newServerUser !=null){
			newServerUser.logout();
			newServerUser.clear();
			newServerUser = null;
			logger.info("New ar logout successfully !");
			}
			bLogin = false;
			logger.info("ar logout successfully !");
			return true;
		} catch (Exception e) {
			logger.error("ar logout exception : " + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}


	/**
	 * @param form:    form schema name
	 * @param fields:  EntryItem[]
	 */

	public String insert(String form, EntryItem fields[]) throws Exception {
		String ret = null;
		if (fields == null) return ret;
		try {
			logger.info("@@@@@@@@@@@@@@@@@@@OldRemedySystem：insert entry into " + form + "...");
			EntryFactory entryFactory = EntryFactory.getFactory();
			Entry entry = (Entry)entryFactory.newInstance();
			entry.setContext(serverUser);
			entry.setSchemaID(new NameID(form));
			entry.setEntryItems(fields);
			entry.create();
			ret = entry.getEntryID().toString();
			entryFactory.releaseInstance(entry);
			logger.info("@@@@@@@@@@@@@@@@@@@OldRemedySystem：insert entry " + ret + " successfully !");
		} catch (Exception e) {
			logger.error("@@@@@@@@@@@@@@@@@@@OldRemedySystemInterFaceError：insert entry exception : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return ret;	
	}


	
	/**
	 * @param form		form schema name
	 * @param id		entry id
	 * @param fields	EntryItem[]
	 */
	public boolean modify(String form, String id, EntryItem fields[]) throws Exception {
			boolean ret = false;
		  if (fields == null || fields.length == 0) return ret;
		try {
			
			logger.info("modify entry(" + form + "/" + id + ")...");
			EntryFactory entryFactory = EntryFactory.getFactory();
			Entry entry = (Entry)entryFactory.newInstance();
			entry.setContext(serverUser);
			entry.setSchemaID(new NameID(form));
			entry.setEntryID(new EntryID(id));
			entry.setEntryItems(fields);
			entry.store();
			entryFactory.releaseInstance(entry);
			ret = true;
			logger.info("modify entry successfully !");
		} catch (Exception e) {
			logger.error("modify entry exception : " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return ret;
		}
	
	private static Value getArValue(int type, String value) throws Exception {
		Value v = null;
		switch (type) {
//			case AR_DATA_TYPE_NULL :
//				v = new Value();
//				break;
//			case AR_DATA_TYPE_KEYWORD :
//				int keycode = getIntValue(value);
//				v = new Value(Keyword.toKeyword(keycode));
//				break;
			case AR_DATA_TYPE_INTEGER :
				if (value == null) {
					v = new Value();
				} else {
					int intVal = getIntValue(value);
					v = new Value(intVal);
				}
				break;
//			case AR_DATA_TYPE_REAL :
//				double doubleVal = (double) getFloatValue(value);
//				v = new Value(doubleVal);
//				break;
			case AR_DATA_TYPE_CHAR :
				String strVal = getStringValue(value);
				v = new Value(strVal);
				break;
//			case AR_DATA_TYPE_DIARY :
//				String dairyVal = getStringValue(value);
//				v = new Value(new Diary(dairyVal));
//				break;
			case AR_DATA_TYPE_ENUM :
				if (value == null) {
					v = new Value();
				} else {
					long enumVal = getLongValue(value);
					v = new Value(DataType.ENUM, enumVal);
				}
				break;
			case AR_DATA_TYPE_TIME :
				// value like <yyyy-mm-dd hh24:mi:ss>
				if (value == null || "".equals(value) || "0".equals(value)) {
					v = new Value();
				} else {
					java.util.Date date = new java.util.Date();
					try {
						date = dFmt.parse(value);
						v = new Value(getTimestampValue(date));
					} catch (Exception e) {
						v = new Value();
						e.printStackTrace();
						logger.error("datetime value(" + value + ") parse exception : " + e.getMessage());
					}
				}
				break;
			case AR_DATA_TYPE_DATE :
				// value like <yyyy-mm-dd 00:00:00>
				if (value == null || "".equals(value) || "0".equals(value)) {
					v = new Value();
				} else {
					java.util.Date date = new java.util.Date();
					try {
						date = dFmt.parse(value);
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						DateInfo dateInfo = new DateInfo();
						dateInfo.setDate(calendar.get(Calendar.YEAR),
								calendar.get(Calendar.MONTH)+1,
								calendar.get(Calendar.DATE));
						v = new Value(dateInfo);
					} catch (Exception e) {
						v = new Value();
						e.printStackTrace();
						logger.error("date value(" + value + ") parse exception : " + e.getMessage());
					}
				}
				break;
//			case AR_DATA_TYPE_TIME_OF_DAY :
//				if (value == null || "".equals(value) || "0".equals(value)) {
//					v = new Value();
//				} else {
//					Time timeOfDay = getTimeOfDayValue(value);
//					v = new Value(timeOfDay);
//				}
//				break;
//			case AR_DATA_TYPE_BITMASK :
//				long maskVal = getLongValue(value);
//				v = new Value(DataType.BITMASK, maskVal);
//				break;
//			case AR_DATA_TYPE_BYTES :
//				no use
//				break;
//			case AR_DATA_TYPE_JOIN :
//				v = new Value(null, DataType.JOIN);
//				break;
//			case AR_DATA_TYPE_TRIM :
//				v = new Value(null, DataType.TRIM);
//				break;
//			case AR_DATA_TYPE_CONTROL :
//				v = new Value(null, DataType.CONTROL);
//				break;
//			case AR_DATA_TYPE_PAGE :
//				v = new Value(null, DataType.PAGE);
//				break;
//			case AR_DATA_TYPE_PAGE_HOLDER :
//				v = new Value(null, DataType.PAGE_HOLDER);
//				break;
//			case AR_DATA_TYPE_ATTACH_POOL :
//				v = new Value(null, DataType.ATTACHMENT_POOL);              
//				break;
			case AR_DATA_TYPE_ULONG :
				if (value == null) {
					v = new Value();
				} else {
					long ulongVal = getLongValue(value);
					logger.info("ulongVal==="+ulongVal);
					
					v = new Value(DataType.ULONG, ulongVal);
					logger.info("v==="+v);
				}
				break;
//			case AR_DATA_TYPE_COORDS :
//				no use
//				break;
			case AR_DATA_TYPE_ATTACH :
				// value like labelname^fullfilename
				if (value == null || "".equals(value)) {
					v = new Value();
				} else {
					int p = value.indexOf("^");
					if (p < 0) {
						v = new Value();
						logger.error("attachment value pattern error : " + value);
					} else {
						AttachmentInfo attach = GetAttachmentInfo(value.substring(p + 1), value.substring(0, p));
						v = new Value(attach);
					}
				}
				break;
//			case AR_DATA_TYPE_DECIMAL :
//				BigDecimal decimalValue = new BigDecimal(value);
//				v = new Value(decimalValue);
//				break;
//			case AR_DATA_TYPE_CURRENCY :
//				no use
//				break;
//			case AR_DATA_TYPE_VIEW :
//				String view = getStringValue(value);
//				v = new Value(view, DataType.VIEW);
//				break;
//			case AR_DATA_TYPE_DISPLAY :
//				String display = getStringValue(value);
//				v = new Value(display, DataType.DISPLAY);
//				break;
			default :
				break;
		}
		return v;
	}
	
	public static Value getArValue(String type, String value) throws Exception {
		if ("CHAR".equals(type)) {
			return getArValue(AR_DATA_TYPE_CHAR, value);
		} else if ("TIME".equals(type)) {
			// value like <yyyy-mm-dd hh24:mi:ss>
			return getArValue(AR_DATA_TYPE_TIME, value);
		} else if ("DATE".equals(type)) {
			// value like <yyyy-mm-dd 00:00:00>
			return getArValue(AR_DATA_TYPE_DATE, value);
		} else if ("ENUM".equals(type)) {
			return getArValue(AR_DATA_TYPE_ENUM, value);
		} else if ("ATTACH".equals(type)) {
			// value like <labelname^fullfilename>
			return getArValue(AR_DATA_TYPE_ATTACH, value);
		} else if ("INTEGER".equals(type)) {
			return getArValue(AR_DATA_TYPE_INTEGER, value);
		} else if ("ULONG".equals(type)) {
			return getArValue(AR_DATA_TYPE_ULONG, value);
		}
		return null;
	}
	
	private static int getIntValue(String strVal) {
		int value = 0;
		if (strVal!=null && !"".equals(strVal)) {
			Integer val = new Integer(strVal);
			value = val.intValue();
		}
		return value;
	}
	
//	private static float getFloatValue(String strVal) {
//		float value = (float)0.0;
//		if (strVal!=null && !"".equals(strVal)) {
//			Float val = new Float(strVal);
//			value = val.floatValue();
//		}
//		return value;
//	}
	
	private static String getStringValue(String strVal) {
		String value = strVal;
		if (value==null || "".equals(value)) {
			return strVal;
		}
		return value;
	}
	
	private static long getLongValue(String strVal) {
		long value = 0;
		if (strVal!=null && !"".equals(strVal)) {
			Long val = new Long(strVal);
			value = val.longValue();
		}
		return value;
	}
	
	private static Timestamp getTimestampValue(java.util.Date v) {
		Timestamp time = new Timestamp(0);
		time.setValue(v);
		return time;
	}
	
//	private static Time getTimeOfDayValue(String strVal) {
//		Time timeOfDay = new Time(0);
//		Long val = new Long(strVal);
//		timeOfDay.setValue(val.longValue());
//		return timeOfDay;
//	}
	
	private static AttachmentInfo GetAttachmentInfo(String strVal, String label) throws Exception {
		File f = new File(strVal);
		if (f.exists() && f.canRead()) {
			String strFileName = strVal.substring(strVal.lastIndexOf(File.separator) + 1);
//			Long m_Intege_currentTime = new Long(System.currentTimeMillis());
//			Guid m_obj_Guid = new Guid(m_Intege_currentTime.intValue());
//			Integer m_Intege_random = new Integer(m_obj_Guid.random(100000));
//			String m_str_Guid = "tmp" + m_Intege_currentTime.toString() + "" + m_Intege_random.toString();
//			String strFilePath_tmp = strVal.replaceAll(strFileName,m_str_Guid);
//			File m_file_tmp_1 = new File(strFilePath_tmp);
//			f.renameTo(m_file_tmp_1);
			logger.info("get attachmentinfo : " + strFileName);
			return new AttachmentInfo(label, f.length(), f.length(), strVal);
		} else {
			logger.error("attachment path : " + strVal);
			throw new Exception("attachment path error !");
		}
	}

	public boolean isLogin() {
		return bLogin;
	}
}
