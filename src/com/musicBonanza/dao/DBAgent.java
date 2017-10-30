package com.musicBonanza.dao;

import com.musicBonanza.Helper.*;
import com.musicBonanza.entity.Result;

import java.io.IOException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.musicBonanza.utils.Constants;

/**
 * Servlet implementation class DBManager
 */
@WebServlet("/DBManager")
/**
 * Database Agent to handle startTransaction, endTransaction, execureSQL,
 * getQueryResult
 * 
 * @author ABHI
 *
 */
public class DBAgent extends HttpServlet {
	static Connection connection;
	static ResultSet rs;
	static Statement stmt;
	static {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(Constants.envNameContext);
			connection = ds.getConnection();
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
	public DBAgent() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Method to initiate a database transaction
	 * 
	 * @throws SQLException
	 */
	public static void startTransaction() throws SQLException {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method to end a database transaction
	 * 
	 * @param exceptionFlag
	 * @throws SQLException
	 */
	public static void endTransaction(boolean exceptionFlag) throws SQLException {

		try {
			if (exceptionFlag) {
				connection.rollback();
			} else {
				connection.commit();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
	}

	/**
	 * Executes query and returns the number of rows affected in the result object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 * @throws Exception
	 */
	public static int executeSQL(String queryID, List<?> parameterList) throws Exception {
		boolean expectionFlag = false;
		int rowNum = 0;

		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		stmt = connection.createStatement();
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				startTransaction();
				rowNum = stmt.executeUpdate(sqlQuery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			expectionFlag = true;
			throw new Exception(e.getMessage());
		} finally {
			endTransaction(expectionFlag);
		}
		return rowNum;
	}

	/*
	 * Executes query and returns the number of rows affected in the result object.
	 *
	 * @param queryID
	 * 
	 * @param parameterList
	 * 
	 * @return resObj
	 */
	public static ResultSet getQueryResult(String queryID, List<String> parameters) throws Exception {
		boolean expectionFlag = false;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
			System.out.println(propertyObj);

			String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameters);
			System.out.println("Reached till here");
			// Log log = null;
			if (!sqlQuery.isEmpty()) {
				startTransaction();
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sqlQuery);
			}
			System.out.println(queryID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			expectionFlag = true;
			throw new Exception(e.getMessage());
		} finally {
			endTransaction(expectionFlag);
		}
		return rs;
	}

	/**
	 * Executes query and returns the number of rows affected in the result object.
	 *
	 * @param queryID
	 * @param parameterList
	 * @return resObj
	 * @throws Exception
	 */
	public static int executePreparedSQL(String queryID, List<?> parameterList) throws Exception {
		boolean expectionFlag = false;
		int insertRowId = 0;
		PreparedStatement preparedStatement = null;

		Properties propertyObj = Helper.LoadProperty(Constants.sqlQueryProperty);
		String sqlQuery = Helper.FetchPropertyAndProcessQuery(propertyObj, queryID, parameterList);

		try {
			if (!sqlQuery.isEmpty()) {
				startTransaction();
				preparedStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					insertRowId = rs.getInt(1);
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			expectionFlag = true;
			throw new Exception(e.getMessage());
		} finally {
			endTransaction(expectionFlag);
		}
		return insertRowId;
	}

}
