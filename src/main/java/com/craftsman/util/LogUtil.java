package com.craftsman.util;

import org.apache.log4j.Logger;

public class LogUtil {

	public static final String WS = "[DoWebService]";
	public static final String DEBUG_IN = "[DEBUGINFO][IN]";
	public static final String DEBUG_PARAMIN = "[DEBUGINFO][PARAMIN]";
	public static final String DEBUG_PARAMOUT = "[DEBUGINFO][PARAMOUT]";
	public static final String DEBUG_MSGTO = "[DEBUGINFO][MSG_TO]";
	public static final String INFO_LOGIN = "[DEBUGINFO][Login]";
	public static final String INFO_MQTT = "[DEBUGINFO][MQTT]";
	public static final String INFO_LOGOUT = "[DEBUGINFO][Logout]";
	public static final String ERR = "[ERRINFO]";
	public static final String EXCEPTION = "[ERR_EXCEPTION]";

	public static final String WS_DEBUG_IN = WS + "[DEBUGINFO][IN]";
	public static final String WS_DEBUG_PARAMIN = WS + "[DEBUGINFO][PARAMIN]";
	public static final String WS_DEBUG_PARAMOUT = WS + "[DEBUGINFO][PARAMOUT]";
	public static final String WS_DEBUG_MSGTO = WS + "[DEBUGINFO][MSG_TO]";
	public static final String WS_INFO_LOGIN = WS + "[DEBUGINFO][Login]";
	public static final String WS_INFO_LOGOUT = WS + "[DEBUGINFO][Logout]";
	public static final String WS_ERR = WS + "[ERRINFO]";
	public static final String WS_EXCEPTION = WS + "[ERR_EXCEPTION]";

	static Logger log = Logger.getLogger(LogUtil.class);
	
	public static void warn(Object message){
		log.warn(message);
	}
	public static void info(Object message) {
		log.info(message);
	}

	public static void debug(Object message) {
		log.debug(message);
	}

	public static void error(Object message) {
		log.error(message);
	}

	public static void error(Exception e) {
		log.error(EXCEPTION + e.getMessage());
	}

	public static void error(Exception e, Object message) {
		log.error(EXCEPTION + message);
		log.error(EXCEPTION + e.getMessage());
	}

}
