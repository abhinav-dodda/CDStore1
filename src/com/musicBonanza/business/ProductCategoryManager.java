package com.musicBonanza.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.musicBonanza.dao.LoginDao;

public class ProductCategoryManager {
	public String categories(int categoryID, String categoryName) throws IOException{
/*		LoginDao loginDao = new LoginDao();
		List<String> parameters = new ArrayList<String> ();
		parameters.add(username);
		parameters.add(password);
		return loginDao.login(parameters);*/
		return categoryName;
	}
}
