package com.beans;
import java.util.Date;

/**
 * 后台管理员
 */
public class AdminInfo {
	private int id;
	private String adminName;
	private String password;
	private String state;  //用户状态   1 正常 ,-1 删除状态 0 锁定
	private Date editDate; //用户最后更新时间(在数据里,可以把它做成时间戳)
	
	private int roleId;  //角色id  ,是一个外键,指向角色表

	public int getId() {
		return id;
	}

	public String getAdminName() {
		return adminName;
	}

	public String getPassword() {
		return password;
	}

	public String getState() {
		return state;
	}

	public Date getEditDate() {
		return editDate;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	} 
	
}
