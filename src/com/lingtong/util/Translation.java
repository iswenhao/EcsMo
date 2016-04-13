package com.lingtong.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.Date;

public class Translation {
	public static long getUnixTime(String date) throws ParseException {
		if ("".equals(date) || date == null) {
			return 0;
		}
		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.parse(date).getTime() / 1000;
	}

	public static String getUnixDate(long time) {
		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.util.Date(time * 1000));
	}

	public static String getUnixDate(long time, String format) {
		return new java.text.SimpleDateFormat("yyyy-MM-dd")
				.format(new java.util.Date(time * 1000));
	}

	public static String getUnixDate(String time) {
		if ("".equals(time) || time == null) {
			return "";
		}
		return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.util.Date(Long.parseLong(time) * 1000));
	}

	public static Date getUnixDates(String time) {
		return (new java.util.Date(Long.parseLong(time) * 1000));
	}

	public static long ipToLong(String strIp) {
		if (strIp.equals("0") || strIp.equals("") || strIp == null) {
			return 0;
		}
		long[] ip = new long[4];
		// ���ҵ�IP��ַ�ַ�����.��λ��
		int position1 = strIp.indexOf(".");
		int position2 = strIp.indexOf(".", position1 + 1);
		int position3 = strIp.indexOf(".", position2 + 1);
		// ��ÿ��.֮����ַ���ת��������
		ip[0] = Long.parseLong(strIp.substring(0, position1));
		ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
		ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
		ip[3] = Long.parseLong(strIp.substring(position3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	public static String longToIP(long longIp) {
		StringBuffer sb = new StringBuffer("");
		// ֱ������24λ
		sb.append(String.valueOf((longIp >>> 24)));
		sb.append(".");
		// ����8λ��0��Ȼ������16λ
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
		sb.append(".");
		// ����16λ��0��Ȼ������8λ
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
		sb.append(".");
		// ����24λ��0
		sb.append(String.valueOf((longIp & 0x000000FF)));
		return sb.toString();
	}

	public static String getIP(String name) throws UnknownHostException {
		InetAddress address = null;
			address = InetAddress.getByName(name);
		return address.getHostAddress().toString();
	}
}
