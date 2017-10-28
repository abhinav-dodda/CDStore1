package com.musicBonanza.dao;
import com.musicBonanza.Helper.*;
import com.musicBonanza.entity.Result;

import java.io.IOException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Properties;
import com.musicBonanza.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;*/

import com.musicBonanza.utils.Constants;

/**
 * Servlet implementation class DBManager
 */
@WebServlet("/DBManager")
public  class DBManager extends HttpServlet {
	static Connection connection;
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/myDataSource");
			connection = ds.getConnection();
			System.out.println(connection);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static final long serialVersionUID = 1L;

	/**
	 * @throws SQLException 
	 * @see HttpServlet#HttpServlet()
	 */
	public DBManager() throws SQLException {
		super();
	//TODO Auto-generated constructor stub
	}
	public static void startTransaction() throws SQLException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//connection.setAutoCommit(true);
			e.printStackTrace();
		}
	}
	public static void endTransaction(boolean exceptionFlag) throws SQLException {
		
		try {
			if(exceptionFlag) {
				connection.rollback();
			}else {
				connection.commit();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Executes query and returns the number of rows affected in the result
	 * object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 * @throws SQLException 
	 */
	public static Result executeSQL(String queryID, List<?> parameterList) throws SQLException {
		boolean expectionFlag=false;
		Result resObj = null;
		Statement stmt = null;
		ResultSet rs=null;
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		stmt = connection.createStatement();
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				//hQuery = hSession.createQuery(sqlQuery);
				//log.info(Constants.executeSQLQueryExecuted);
				startTransaction();
				stmt.executeUpdate(sqlQuery);
			
			}

			// Setting the result object with no of rows affected & success
			// code/message.
			//resObj = setResultObject(null, null, hQuery.list().size(), Constants.successCode, Constants.successMessage);

		} catch (SQLException e) {
			// Setting the result object with failure code/message.
			//resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
			//log.error(e.getLocalizedMessage(), e);
			e.printStackTrace();
			expectionFlag=true;
			
		}
		finally {
			endTransaction(expectionFlag);
		}
		return resObj;
	}
	/* Executes query and returns the number of rows affected in the result
	 * object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 */
	public static ResultSet getQueryResult(String queryID, List<String> parameters) throws SQLException {
		boolean expectionFlag=false;
		Statement stmt = null;
		ResultSet rs=null;
		try {		
			Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
			System.out.println(propertyObj);
			
			String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID,parameters);
			System.out.println("Reached till here");
			//Log log = null;
			if (!sqlQuery.isEmpty()) {
				startTransaction();
				stmt = connection.createStatement();
				 rs = stmt.executeQuery(sqlQuery);
				//log.info(Constants.executeSQLQueryExecuted);
			}
			System.out.println(queryID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			endTransaction(expectionFlag);
		}
		return rs;

		
		/*try {
			

			// Setting the result object with no of rows affected & success
			// code/message.
			//resObj = setResultObject(null, null, hQuery.list().size(), Constants.successCode, Constants.successMessage);

		} catch (Exception e) {
			// Setting the result object with failure code/message.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
			log.error(e.getLocalizedMessage(), e);
		}*/
	}
	/**
	 * Executes query and returns the number of rows affected in the result
	 * object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 * @throws SQLException 
	 */
	public static int executePreparedSQL(String queryID, List<?> parameterList) throws SQLException {
		boolean expectionFlag=false;
		int insertRowId = 0;
		PreparedStatement preparedStatement = null;
		
		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
				String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				startTransaction();
				preparedStatement = connection.prepareStatement(sqlQuery,
		                Statement.RETURN_GENERATED_KEYS);;
		                insertRowId = preparedStatement.executeUpdate();
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
			expectionFlag=true;
			
		}
		finally {
			endTransaction(expectionFlag);
		}
		return insertRowId;
	}
	 /* Executes query and returns result set.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 
	public Result getQueryResult(String queryID, List<?> parameterList) {
		Result resObj = null;
		Query hQuery = null;

		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				hQuery = hSession.createQuery(sqlQuery);
				log.info(Constants.getQueryResultExecuted);
			}

			// Setting the result object with result set, no of rows affected &
			// success code/message.
			resObj = setResultObject(hQuery.list(), null, hQuery.list().size(), Constants.successCode,
					Constants.successMessage);
		} catch (Exception e) {
			// Setting the result object with failure code/message.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.connectionFailed + e.getMessage());
			log.error(e.getLocalizedMessage(), e);
		}
		return resObj;
	}
	
	 * Saves new data.
	 *
	 * @param dataList
	 * @return
	 

	public Result saveNewData(List<?> dataList) {
		Result resObj = null;
		int i = 0;
		List<Integer> primaryIdList = new ArrayList<Integer>();
		try {
			if (!dataList.equals(null)) {
				{
					// Iterating the items in the list.
					Iterator<?> item = dataList.iterator();
					while (item.hasNext()) {
						i = (int) hSession.save(item.next());
						primaryIdList.add(i);
						log.info(Constants.saveMethodExecuted);
					}
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, primaryIdList, primaryIdList.size(), Constants.successCode,
					Constants.dataSaved);
		} catch (Exception e) {
			// Setting the result object with failure information.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataNotSaved);
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

	public Result upDateEntity(List<?> dataList) {
		Result resObj = null;
		// List<Integer> primaryIdList = new ArrayList<Integer>();
		try {
			if (!dataList.equals(null)) {
				{
					// Iterating the items in the list.
					Iterator<?> item = dataList.iterator();
					while (item.hasNext()) {
						hSession.saveOrUpdate(item.next());
						log.info(Constants.saveMethodExecuted);
					}
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, null, 0, Constants.successCode, Constants.dataSaved);
		} catch (Exception e) {
			// Setting the result object with failure information.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataNotSaved);
			log.error(e.getLocalizedMessage(), e);
		}

		return resObj;
	}

	 * Deletes data from DB Table.
	 *
	 * @param entityClass
	 * @param primaryKeyList
	 

	public <T> Result DeleteData(Class<T> entityClass, List<Integer> primaryKeyList) {
		// Reference :
		// http://examples.javacodegeeks.com/enterprise-java/hibernate/delete-persistent-object-with-hibernate/
		Result resObj = null;
		if (!primaryKeyList.equals(null) && !primaryKeyList.isEmpty()) {
			Iterator<Integer> item = primaryKeyList.iterator();

			while (item.hasNext()) {
				try {
					hSession.delete(hSession.get(entityClass, item.next()));
				} catch (HibernateException e) {
					// Setting the result object with failure information.
					resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataDeleteFailed);
					log.error(e.getLocalizedMessage(), e);
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, null, 0, Constants.successCode, Constants.dataDeleted);
		}

		return resObj;
	}

	 * Updating the table based on the data passed.
	 *
	 * @param dataList
	 * @return
	 
	// TODO This method is not functional. To be implemented.
	public Result UpdateData(List<?> dataList) {
		Result resObj = null;
		try {
			if (!dataList.equals(null)) {
				{
					for (Object item : dataList) {
						hSession.update(item);
					}
				}
			}

			// Setting the result object with success information.
			resObj = setResultObject(null, null, 0, Constants.successCode, Constants.dataSaved);
		} catch (Exception e) {
			// Setting the result object with failure information.
			resObj = setResultObject(null, null, 0, Constants.errorCode, Constants.dataNotSaved);
			log.error(e.getLocalizedMessage(), e);
			System.out.println(e.getLocalizedMessage());
		}

		return resObj;
	}
	
	 * Method used to set the Result Object.
	 *
	 * @param resultList
	 * @param resultCount
	 * @param statusCode
	 * @param statusMessage
	 * @return resultObj
	 
	public Result setResultObject(Object resultList, List<Integer> primaryIdList, int resultCount, int statusCode,
			String statusMessage) {
		Result resultObj = new Result();
		try {
			// Setting the result object based on the parameters passed.
			resultObj.setResultList((List<?>) resultList);
			resultObj.setPrimaryIdList(primaryIdList);
			resultObj.setResultCount(resultCount);
			resultObj.setStatusCode(statusCode);
			resultObj.setStatusMessage(statusMessage);
		} catch (Exception e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return resultObj;
	}*/
/*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
		/*try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/myDataSource");
			Connection connection = ds.getConnection();
			System.out.println(connection);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
