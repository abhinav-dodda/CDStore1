package com.musicBonanza.utils;

public final class Constants {
	// Database Configurations and sql pool names
	public static final String sqlConfigName = "mySqlConfig.properties";
	public static final String dbName = "dbName";
	public static final String dbURL = "dbURL";
	public static final String jdbcDriverInfo = "jdbcDriverInfo";
	public static final String username = "username";
	public static final String password = "password";
	public static final String envNameContext = "java:comp/env";
	public static final String mysqlPoolName = "jdbc/mysqlPool";

	// Error Messages
	public static final String connectionFailed = "Failed to Get/Make Connection";
	public static final String userNameExist = "User Already Exist";
	public static final String dataDeleteFailed = "Data Delete Failed";
	public static final String userNameDoesntExist = "User Dosent Exist";
	public static final String passwordsMismatch = "Passwords do not match, please enter a valid password";
	public static final String userNamePasswordMismatch = "Username and Password doesn't match";
	public static final String errorMessage = "Payment Authorization Rejected";
	// Error Codes
	public static final int errorCode = -1;
	public static final int errorUserNameExists = 101;
	// Success Messages
	public static final String successMessage = "Success";
	public static final String dataSaved = "Data Saved";
	public static final String dataNotSaved = "Failed to Save Data";
	public static final String accountCreatedMessage = "Account Created";
	public static final String dataDeleted = "Data is Deleted";
	public static final String userIsValidated = "User is Validated.";
	// Success Codes
	public static final int successCode = 1;

	// FileNames
	public static final String sqlQueryProperty = "com/musephoria/util/SqlQuery.properties";
	public static final String hibernatePropertyFile = "hibernate.cfg.xml";

	// Property Keys
	public static final String getCategoryList = "getCategoryList";
	public static final String checkIfUserExists = "checkIfUserExists";
	public static final String getAccountInfo = "getAccountInfo";
	public static final String getCustomerDetails = "getCustomerDetails";
	public static final String getProductList = "getProductList";
	public static final String getProductListWithCategory = "getProductListWithCategory";
	public static final String getProductInfo = "getProductInfo";
	public static final String getCartItems = "getCartItems";
	public static final String getCustomerIdbyUsername = "getCustomerIdbyUsername";
	public static final String getLastId = "getLastId";

	// Log Messages

	public static final String executeSQLQueryExecuted = "ExcuteSQL method Executed.";
	public static final String getQueryResultExecuted = "Get Query method Executed.";
	public static final String saveMethodExecuted = "Save Method Executed.";
	public static final String hibernateConfigLoaded = "Hibernate Configured and Loaded.";
	public static final String hibernateSessionCreated = "Hibenate Session Created.";
	public static final String hibernateTransactionStarted = "Hibenate Transaction Started.";
	public static final String hibernateSessionCleanedUp = "Hibenate Session flushed, Transaction Committed, Session closed.";

	// Servlet variables
	public static final String shoppingCart = "ShoppingCart";
	public static final String userOrVisitorFlag = "flag";
	public static final String cartItem = "cartItem";
	public static final String totalCartPrice = "totalCartPrice";
	public static final String cdId = "cdId";
	public static final String cddetail = "cddetail";
	public static final String message = "message";
	public static final String customerId = "custId";
	public static final String customerObject = "custObject";
	public static final String genre = "Genre";
	public static final String productWithSelectedCategory = "Product";
	public static final String categoryList = "CategoryList";
	public static final String purchaseOrderId = "resultPoId";
	public static final String paymentStatus = "status";
	public static final String paymentCounter = "counter";
	public static final String firstname = "fname";
	public static final String lastname = "lname";
	public static final String sex = "sex";
	public static final String user = "usr";
	public static final String pass = "pwd";
	public static final String repassword = "repwd";
	public static final String dateOfBirth = "dob";
	public static final String address = "addr";
	public static final String city = "city";
	public static final String province = "prov";
	public static final String country = "country";
	public static final String zipcode = "zip";
	public static final String email = "email";
	public static final String phone = "phone";

}
