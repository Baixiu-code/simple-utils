package com.craftsman.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import net.sf.json.JSONObject;

public class PoiExcelUtil {

	/**
	 * 读取 office excel
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static <T> List<T> excelToList(String fileName, InputStream in, Class<T> entityClass, LinkedHashMap<String, String> fieldMap) throws Exception {
		String extension = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());// 取得文件扩展名
		Workbook wb;

		if ("xls".equals(extension)) {
			wb = new HSSFWorkbook(in);
		} else if ("xlsx".equals(extension)) {
			wb = new XSSFWorkbook(in);
		} else {
			throw new Exception("不支持的文件类型");
		}

		Sheet sheet = wb.getSheetAt(0);
		Row row;
		Cell cell;

		List<T> resultList = new ArrayList<T>();
		String[] excelFieldNames = null;
		LinkedHashMap<String, Integer> colMap = null;
		String content = null;

		for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {

			row = sheet.getRow(i);

			if (row == null) {
				continue;
			}

			if (i == sheet.getFirstRowNum()) {
				excelFieldNames = new String[row.getLastCellNum()];
				for (int j = 0; j < row.getLastCellNum(); j++) {
					excelFieldNames[j] = row.getCell(j).getStringCellValue();
				}

				// 判断需要的字段在Excel中是否都存在
				boolean isExist = true;
				List<String> excelFieldList = Arrays.asList(excelFieldNames);
				for (String cnName : fieldMap.keySet()) {
					if (!excelFieldList.contains(cnName)) {
						isExist = false;
						break;
					}
				}

				// 如果有列名不存在，则抛出异常，提示错误
				if (!isExist) {
					throw new Exception("Excel中缺少必要的字段，或字段名称有误");
				}

				// 将列名和列号放入Map中,这样通过列名就可以拿到列号
				colMap = new LinkedHashMap<String, Integer>();
				for (int k = 0; k < excelFieldNames.length; k++) {
					colMap.put(excelFieldNames[k], row.getCell(k).getColumnIndex());
				}

			} else {
				// 新建要转换的对象
				T entity = entityClass.newInstance();

				// 给对象中的字段赋值
				for (Entry<String, String> entry : fieldMap.entrySet()) {
					// 获取中文字段名
					String cnNormalName = entry.getKey();
					// 获取英文字段名
					String enNormalName = entry.getValue();
					// 根据中文字段名获取列号
					int col = colMap.get(cnNormalName);

					cell = row.getCell(col);
					if (cell == null) {
						continue;
					}

					content = cell.toString();

					DecimalFormat df = new DecimalFormat("0");// 格式化 number
																// String
					// 字符
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
					DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
					// DecimalFormat nf = new DecimalFormat("0");// 格式化数字
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						content = cell.getStringCellValue();
						break;
					case Cell.CELL_TYPE_NUMERIC:
						if ("@".equals(cell.getCellStyle().getDataFormatString())) {
							content = df.format(cell.getNumericCellValue()).toString();
						} else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
							content = nf.format(cell.getNumericCellValue()).toString();
						} else {
							content = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
						}
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						content = String.valueOf(cell.getBooleanCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						content = "";
						break;
					default:
						content = cell.toString();
					}
					// 给对象赋值
					if (entity instanceof JSONObject) {
						((JSONObject) entity).put(enNormalName, content);
					} else {
						setFieldValueByName(enNormalName, content, entity);
					}
				}

				resultList.add(entity);
			}

		}

		return resultList;
	}

	/**
	 * @MethodName : setFieldValueByName
	 * @Description : 根据字段名给对象的字段赋值
	 * @param fieldName
	 *            字段名
	 * @param fieldValue
	 *            字段值
	 * @param o
	 *            对象
	 */
	private static void setFieldValueByName(String fieldName, Object fieldValue, Object o) throws Exception {

		Field field = getFieldByName(fieldName, o.getClass());
		if (field != null) {
			field.setAccessible(true);
			// 获取字段类型
			Class<?> fieldType = field.getType();

			// 根据字段类型给字段赋值
			if (String.class == fieldType) {
				field.set(o, String.valueOf(fieldValue));
			} else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
				field.set(o, (int) Double.parseDouble(fieldValue.toString()));
			} else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
				field.set(o, (long) Double.parseDouble(fieldValue.toString()));
			} else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
				field.set(o, (float) Double.parseDouble(fieldValue.toString()));
			} else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
				field.set(o, (short) Double.parseDouble(fieldValue.toString()));
			} else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
				if (StringUtils.isEmpty(fieldValue)) {
					field.set(o, null);
				} else {
					field.set(o, Double.valueOf(fieldValue.toString()));
				}
			} else if (Character.TYPE == fieldType) {
				if ((fieldValue != null) && (fieldValue.toString().length() > 0)) {
					field.set(o, Character.valueOf(fieldValue.toString().charAt(0)));
				}
			} else if (Date.class == fieldType) {
				field.set(o, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fieldValue.toString()));
			} else {
				field.set(o, fieldValue);
			}
		} else {
			throw new Exception(o.getClass().getSimpleName() + "类不存在字段名 " + fieldName);
		}
	}

	/**
	 * @MethodName : getFieldByName
	 * @Description : 根据字段名获取字段
	 * @param fieldName
	 *            字段名
	 * @param clazz
	 *            包含该字段的类
	 * @return 字段
	 */
	private static Field getFieldByName(String fieldName, Class<?> clazz) {
		// 拿到本类的所有字段
		Field[] selfFields = clazz.getDeclaredFields();

		// 如果本类中存在该字段，则返回
		for (Field field : selfFields) {
			if (field.getName().equals(fieldName)) {
				return field;
			}
		}

		// 否则，查看父类中是否存在此字段，如果有则返回
		Class<?> superClazz = clazz.getSuperclass();
		if (superClazz != null && superClazz != Object.class) {
			return getFieldByName(fieldName, superClazz);
		}

		// 如果本类和父类都没有，则返回空
		return null;
	}
}
