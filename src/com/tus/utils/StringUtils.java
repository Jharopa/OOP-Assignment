package com.tus.utils;

public class StringUtils {
	public static String makeHeader(String content) {
		String seperator = "-".repeat(content.length());
		
		return seperator + "\n" + content + "\n" + seperator;
	}
	
	public static String makeHeader(String content, char character) {
		String seperatorCharacter = new StringBuilder().append("").append(character).toString();
		String seperator = seperatorCharacter.repeat(content.length());
		
		return seperator + "\n" + content + "\n" + seperator;
	}
}
