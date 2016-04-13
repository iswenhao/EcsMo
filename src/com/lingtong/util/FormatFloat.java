package com.lingtong.util;

public class FormatFloat {
	
	public static float FormatToFloat(String p_String)
	{
		float intRe=0;
		if(p_String!=null)
		{	if(!p_String.trim().equals(""))
			{
				try{
				intRe=Float.parseFloat(p_String);
				}catch(Exception ex)
				{
					
				}
			}
		}
		return intRe;
	}
	
	public static float FormatToFloat(Object p_object)
	{
		String p_String=FormatString.CheckNullString(p_object);
		return FormatToFloat(p_String);
		
	}	

}
