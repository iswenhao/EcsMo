package com.lingtong.util;

public class FormatLong {
	
	
	public static long FormatStringToLong(String p_String)
	{
		long intRe=0;
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

	public static long FormatStringToLong(Object p_object)
	{
		String p_String=FormatString.CheckNullString(p_object);
		long intRe=0;
	
		if(!p_String.trim().equals(""))
			{
				try{
				intRe=Integer.parseInt(p_String);
				}catch(Exception ex)
				{
					
				}
			}
		
		return intRe;
	}
	
}
