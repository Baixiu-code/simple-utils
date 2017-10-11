package com.craftsman.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件工具类
 * @author bqh
 *
 */
public class SystemConfig {
	private static Properties prop = new Properties();
	static {
		InputStream in = SystemConfig.class.getResourceAsStream("/config.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String key) {
		return prop.getProperty(key);
	}
}
