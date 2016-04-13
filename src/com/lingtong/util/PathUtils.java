package com.lingtong.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public class PathUtils {
	/**
	 * ��ȡ��ǰ���г���jar������·��
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getProjectPath() throws UnsupportedEncodingException {
		URL url = PathUtils.class.getProtectionDomain().getCodeSource()
				.getLocation();
		String filePath = URLDecoder.decode(url.getPath(), "UTF-8");
		if (filePath.endsWith(".jar"))
			filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		return filePath;
	}

	/**
	 * ���ص�ǰclasspath·��
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String currentPath() throws IOException {
		File directory = new File(". ");
		// ȡ�õ�ǰ·��
		return directory.getCanonicalPath();

	}

	/**
	 * ��ȡһ��Class�ľ���·��
	 * 
	 * @param clazz
	 * @return Class�ľ���·��
	 * 
	 */
	public static String getPathByClass(Class<?> clazz) {
		String path = null;
		try {
			URI uri = clazz.getResource("").toURI();
			File file = new File(uri);
			path = file.getCanonicalPath();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}

	/**
	 * ��ȡһ���ļ������һ��Class��Եľ���·��
	 * 
	 * @param clazz
	 *            Class����
	 * @param relativePath
	 *            Class��������·��
	 * @return �ļ�����·��
	 */
	public static String getFilePathByClass(Class<?> clazz, String relativePath) {
		String filePath = null;
		String clazzPath = getPathByClass(clazz);
		StringBuffer sbPath = new StringBuffer(clazzPath);
		sbPath.append(File.separator);
		sbPath.append(relativePath);
		File file = new File(sbPath.toString());
		try {
			filePath = file.getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
	


}
