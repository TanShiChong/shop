package com.beans;
import java.util.Date;

/**
 * ��̨����Ա
 */
public class AdminInfo {
	private int id;
	private String adminName;
	private String password;
	private String state;  //�û�״̬   1 ���� ,-1 ɾ��״̬ 0 ����
	private Date editDate; //�û�������ʱ��(��������,���԰�������ʱ���)
	
	private int roleId;  //��ɫid  ,��һ�����,ָ���ɫ��

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
