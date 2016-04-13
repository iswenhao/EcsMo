package com.lingtong.util;

import java.io.File;
import java.io.StringReader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlMgr {
	public static Document getXmlDocByFile(File file) {
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(file);
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Document getXmlDocByString(String strXml) {
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new StringReader(strXml));
			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Element getElementByPath(Document doc, String path) {
		Element parent = doc.getRootElement();
		if (path == null) return null;
		while (path.startsWith("/"))
			path = path.substring(1);
		while (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);
		if (path == "") return null;
//		if (path.indexOf("/") < 0)  // <root> element
//			return parent;
//		if (path.startsWith(parent.getName() + "/"))
//			path = path.substring(parent.getName().length() + 1);
		int p = path.indexOf("/");
		while (p > -1) {
			String sEle = path.substring(0, p);
			parent = parent.element(sEle);
			path = path.substring(p + 1);
			p = path.indexOf("/");
		}
		parent= parent.element(path);
		return parent;
	}

	public static Element getElementByPath(Element e, String path) {
		Element parent = e;
		if (path == null) return null;
		while (path.startsWith("/"))
			path = path.substring(1);
		while (path.endsWith("/"))
			path = path.substring(0, path.length() - 1);
		if (path == "") return null;
//		if (path.indexOf("/") < 0)  // <root> element
//			return parent;
//		if (path.startsWith(parent.getName() + "/"))
//			path = path.substring(parent.getName().length() + 1);
		int p = path.indexOf("/");
		while (p > -1) {
			String sEle = path.substring(0, p);
			parent = parent.element(sEle);
			path = path.substring(p + 1);
			p = path.indexOf("/");
		}
		parent = parent.element(path);
		return parent;
	}

	public static String getValueByPath(Document doc, String path) {
		String sPath = path;
		String sPathAttribute = "";
		int p = path.indexOf(".");
		if (p > -1) {
			sPath = path.substring(0, p);
			sPathAttribute = path.substring(p + 1);
		}
		Element e = getElementByPath(doc, sPath);
		if (e != null) {
			if (sPathAttribute != "") {
				String rtn = e.attributeValue(sPathAttribute);
				if (rtn != null) return rtn;
			} else {
				String rtn = e.getText();
				if (rtn != null) return rtn;
			}
		}
		return "";
	}
}
