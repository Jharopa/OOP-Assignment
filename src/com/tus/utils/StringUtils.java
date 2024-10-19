package com.tus.utils;

public class StringUtils {
	public static String makeHeader(String content) {
		String seperator = "-".repeat(content.length());
		return seperator + "\n" + content + "\n" + seperator;
	}
}
