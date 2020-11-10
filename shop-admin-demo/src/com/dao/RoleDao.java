package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.beans.RoleInfo;
import com.jdbc.DBUtil;

public class RoleDao {

	//查询所有角色信息
	public List<RoleInfo> getRoleList() {
		return DBUtil.getList("select * from roleInfo", RoleInfo.class);
	}
	
	//根据id查询角色信息
	public RoleInfo getRoleInfoById(int roleId) {
		return DBUtil.getSingleObj("select * from roleInfo where id=?" , RoleInfo.class, roleId);
	}

	//更新角色对应的菜单
	public void updateRoleMenu(int roleId, String[] idList) {
		//1 删除角色原有的所有菜单
		DBUtil.update("delete from roleMenu where roleId=?", roleId);
		
		//2 添加新的菜单
		for(String menuId: idList) {
			DBUtil.update("insert into roleMenu (roleId,menuId) values (?,?) ",roleId,menuId );
			
		}	
	}

	//根据roleId 查询它下面有哪些menuId,以字符串的形式返回比如: 1,4,5,6,9
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
