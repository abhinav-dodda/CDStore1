package com.musicBonanza.Helper;

import java.util.*;

import com.mysql.jdbc.Util;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import com.musicBonanza.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import java.io.*;

public class Helper {
	
	public static Properties LoadProperty(String propertyFileName) {

		Properties property = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream;
		try {
		inputStream = loader.getResourceAsStream(propertyFileName);
			
					property.load(inputStream);
				System.out.println("Prop File loaded");
				System.out.println(property.getProperty("selectFromUserLogin"));
		}
		 catch (IOException e) {
			// log.error(e.getLocalizedMessage(), e);
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
		} else {
			processedQuery = rawQuery;
		}

		return processedQuery;
	}

	
	/**
	 * Loads the property file using the below parameters.
	 *
	 * @param propertyKey
	 * @param className
	 * @return 
	 * @return
	 */
	public static void main(String[] args) {

	 Helper.LoadProperty("com/musicBonanza/Util/sqlQuery.properties");
	
}
/* Processes the query string by replacing @param parameters with actual
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
			processedString = processedString.replace("@param" + i, iterator.next().toString());
			i++;
		}

		return processedString;
	}
}