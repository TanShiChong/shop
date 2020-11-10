package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.beans.RoleInfo;
import com.jdbc.DBUtil;

public class RoleDao {

	//��ѯ���н�ɫ��Ϣ
	public List<RoleInfo> getRoleList() {
		return DBUtil.getList("select * from roleInfo", RoleInfo.class);
	}
	
	//����id��ѯ��ɫ��Ϣ
	public RoleInfo getRoleInfoById(int roleId) {
		return DBUtil.getSingleObj("select * from roleInfo where id=?" , RoleInfo.class, roleId);
	}

	//���½�ɫ��Ӧ�Ĳ˵�
	public void updateRoleMenu(int roleId, String[] idList) {
		//1 ɾ����ɫԭ�е����в˵�
		DBUtil.update("delete from roleMenu where roleId=?", roleId);
		
		//2 ����µĲ˵�
		for(String menuId: idList) {
			DBUtil.update("insert into roleMenu (roleId,menuId) values (?,?) ",roleId,menuId );
			
		}	
	}

	//����roleId ��ѯ����������ЩmenuId,���ַ�������ʽ���ر���: 1,4,5,6,9
	public String getMenuIdStr(int roleId) {
		String str="";
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();
			stm=conn.prepareStatement("select menuId from roleMenu where roleId=?");
			stm.setInt(1, roleId);
			rs=stm.executeQuery();
			while(rs.next()) {
				str+=rs.getInt("menuId")  +","; 
			}
			
			str=str.substring(0,str.length()-1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,stm,conn);
		}
		
		return str;	
	}
}
