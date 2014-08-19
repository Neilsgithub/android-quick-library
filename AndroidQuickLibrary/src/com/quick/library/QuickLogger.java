package com.quick.library;


/**
 * Log工具
 * 
 * @author steven-pan
 */
public class QuickLogger {

	private static final String PREFIX = "*//_\\*";

	private static String currentTag = QuickLogger.class.getSimpleName();

	private static boolean output = false;
	
	private QuickLogger() {
		
	}
	
	public static void setTag(String currentTag) {
		QuickLogger.currentTag = currentTag;
	}
	
	public static void setOutput(boolean output) {
		QuickLogger.output = output;
		QuickLogger.d("output:" + QuickLogger.output);
	}
	
	public static void d(String message) {
		QuickLogger.d(currentTag, message);
	}

	public static void e(String message) {
		QuickLogger.e(currentTag, message);
	}
	
	public static void d(String prefx, String message) {
		if (output) {
			android.util.Log.d(currentTag, format(message));
		}
	}

	public static void e(String prefx, String message) {
		if (output) {
			android.util.Log.e(currentTag, format(message));
		}
	}
	
	private static String format(String info) {
		return PREFIX + info + PREFIX;
	}

}
