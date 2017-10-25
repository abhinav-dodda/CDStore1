package com.musicBonanza.dao;
import com.musicBonanza.Helper.*;
import java.io.IOException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.mysql.jdbc.Statement;
/**
 * Servlet implementation class DBManager
 */
@WebServlet("/DBManager")
public  class DBManager extends HttpServlet {
	/*private Configuration hConfig;
	private static Session hSession;
	private Transaction hTransaction;
	SessionFactory hSessionFactory;*/
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DBManager() {
		super();
		/*loadConfiguration();
		loadSession();
		beginTransaction();*/
		
		// TODO Auto-generated constructor stub
	}
	/*
	 * Loads SQL configuration information from the hibernate configuration
	 * file.
	 *
	 * @return Hibernate configuration object.
	 */
	/*public Configuration loadConfiguration() {
		hConfig = new Configuration();
		hConfig.configure(Constants.hibernatePropertyFile);
		Log log = null;
		log.info(Constants.hibernateConfigLoaded);
		return hConfig;
	}*/
	/*
	 * Opens a Hibernate Session.
	 *
	 * @param config
	 * @return Hibernate Session Object.
	 */
/*	@SuppressWarnings("deprecation")
	public Session loadSession() {
		Log log = null;
		// Reference :
		// http://www.17od.com/2006/11/06/using-managed-sessions-in-hibernate-to-ease-unit-testing/
		try {
			if (!hConfig.equals(null)) {
				hSessionFactory = hConfig.buildSessionFactory();
				hSession = hSessionFactory.openSession();
				hSession.setFlushMode(FlushMode.MANUAL);
				ManagedSessionContext.bind(hSession);
				log.info(Constants.hibernateSessionCreated);
			}
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage(), e);
		}
		return hSession;
	}*/
	/*
	 * Begins a Hibernate Transaction.
	 *
	 * @param hSession
	 * @return Hibernate Transaction Object.
	 */
/*	public Transaction beginTransaction() {
		Log log = null;
		try {
			if (!hSession.equals(null)) {
				hTransaction = hSession.beginTransaction();
				log.info(Constants.hibernateTransactionStarted);
			}
		} catch (HibernateException e) {
			log.error(e.getLocalizedMessage(), e);

		}
		return hTransaction;
	}
	
	 * Terminates the Transaction & Closes the Session.
	 *
	 * @param hTransaction
	 * @param hSession
	 
	public void cleanUpSession() {
		if (!hTransaction.equals(null) && !hSession.equals(null)) {
			Log log = null;
			try {
				ManagedSessionContext.unbind(hSessionFactory);
				hSession.flush();
				hTransaction.commit();
				hSession.close();
				log.info(Constants.hibernateSessionCleanedUp);
			} catch (TransactionException e) {
				log.error(e.getLocalizedMessage(), e);
			}

			catch (SessionException e) {
				log.error(e.getLocalizedMessage(), e);
			}
		}
	}
	
	 * Executes query and returns the number of rows affected in the result
	 * object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 */
	public static ResultSet runSQLQueries(String queryID, List<?> parameterList) {
		Statement stmt = null;
		ResultSet rs=null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(Constants.envNameContext);
			Connection connection = ds.getConnection();
			//System.out.println(connection);
			
			Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
			System.out.println(propertyObj);
			
			String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID,parameterList);
			System.out.println("Reached till here");
			//Log log = null;
			if (!sqlQuery.isEmpty()) {
				//hQuery = hSession.createQuery(sqlQuery);
				//stmt = (Statement) connection.createStatement();
				// rs = stmt.executeQuery(sqlQuery);
				//log.info(Constants.executeSQLQueryExecuted);
			}
			System.out.println(queryID);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
