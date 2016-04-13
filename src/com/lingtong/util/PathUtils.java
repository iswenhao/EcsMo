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
	 * 获取当前运行程序jar包所在路径
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
	 * 返回当前classpath路径
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String currentPath() throws IOException {
		File directory = new File(". ");
		// 取得当前路径
		return directory.getCanonicalPath();

	}

	/**
	 * 获取一个Class的绝对路径
	 * 
	 * @param clazz
	 * @return Class的绝对路径
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
	 * 获取一个文件相对于一个Class相对的绝对路径
	 * 
	 * @param clazz
	 *            Class对象
	 * @param relativePath
	 *            Class对象的相对路径
	 * @return 文件绝对路径
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
