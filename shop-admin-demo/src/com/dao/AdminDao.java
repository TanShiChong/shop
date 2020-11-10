package com.dao;
import com.beans.AdminInfo;
import com.jdbc.DBUtil;

public class AdminDao {

	public AdminInfo login(String adminName, String password) {
		return DBUtil.getSingleObj("select * from adminInfo where adminName=? and password=?" , AdminInfo.class, adminName,password); 
	}

}
