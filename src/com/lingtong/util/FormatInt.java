package com.lingtong.util;

public class FormatInt {

	public static int FormatStringToInt(String p_String)
	{
		int intRe=0;
		if(p_String!=null)
		{	if(!p_String.trim().equals(""))
			{
				try{
				intRe=Integer.parseInt(p_String);
				}catch(Exception ex)
				{
					 
				}
			}
		}
		return intRe;
	}
	public static int FormatObjectToInt(Object p_object)
	{
		int intRe = 0;
		String strobj = FormatString.CheckNullString(p_object).trim();
		if (!strobj.trim().equals("")) {
			try {
				intRe = Integer.parseInt(strobj);
			} catch (Exception ex) {

			}
		}
		return intRe;
	}	
}
