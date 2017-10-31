package com.musicBonanza.Helper;

import java.util.*;

import com.mysql.jdbc.Util;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import com.musicBonanza.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import java.io.*;

public class Helper {
	/**
	 * This method is used to load the SQL Properties file n
	 * 
	 * @param propertyFileName
	 * @return
	 */
	public static Properties LoadProperty(String propertyFileName) {

		Properties property = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream;
		try {
			inputStream = loader.getResourceAsStream(propertyFileName);
			property.load(inputStream);
			System.out.println("Prop File loaded");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}

	/**
	 * Fetches the property value when property key is passed.
	 *
	 * @param propertyObj
	 * @param propertyKey
	 * @return
	 */
	public static String FetchPropertyAndProcessQuery(Properties propertyObj, String propertyKey,
			List<?> parameterList) {

		String rawQuery = StringUtils.EMPTY;
		String processedQuery = StringUtils.EMPTY;

		if (!propertyObj.equals(null)) {
			rawQuery = propertyObj.getProperty(propertyKey);
		}

		if (parameterList != null) {
			processedQuery = ProcessQuery(parameterList, rawQuery);
			System.out.println("Reached FetchAndProcessQuery");
			System.out.println(processedQuery);
		} else {
			processedQuery = rawQuery;
		}

		return processedQuery;
	}

	/**
	 * Processes the query string by replacing @param parameters with actual
	 * parameters.
	 *
	 * @param parameterList
	 * @param rawQuery
	 * @return
	 */
	public static String ProcessQuery(List<?> parameterList, String rawQuery) {
		String processedString = rawQuery;
		int i = 1;

		Iterator<?> iterator = parameterList.iterator();
		while (iterator.hasNext()) {
			String result = (String) iterator.next();
			System.out.println(result);
			processedString = processedString.replace("?" + i, result);
			i++;
		}

		return processedString;
	}
/**
 * Main Method that loads the sql properties file
 * @param args
 */
	public static void main(String[] args) {

		Helper.LoadProperty(Constants.sqlQueryPropertiesFilePath);

	}
}