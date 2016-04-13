package com.lingtong.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.Element;

public class Configurator {
	private static Document configuration = null;
	
	public static void configure(String file) {
		configuration = XmlMgr.getXmlDocByFile(new File(file));
	}
	
	public static Document getConfiguration() {
		return configuration;
	}
	
	public static String getValue(String path) {
		return XmlMgr.getValueByPath(configuration, path);
	}
	
	public static Element getElementByPath(String path) {
		return XmlMgr.getElementByPath(configuration, path);
	}
	
	public static Element getElementByPath(Element ele, String path) {
		return XmlMgr.getElementByPath(ele, path);
	}
}
