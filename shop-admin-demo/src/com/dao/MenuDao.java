package com.dao;
import java.util.List;
import com.beans.MenuInfo;
import com.jdbc.DBUtil;

public class MenuDao {
	/**
	 * 根据父级id,查询所有的子菜单
	 * @param parentId 父级id
	 */
	public  List<MenuInfo>getMenuList(int parentId){
		String sql="select * from menuInfo where parentId=?"; 	
		List<MenuInfo> menuList= DBUtil.getList(sql, MenuInfo.class, parentId);	
		
		for(MenuInfo m:menuList) {
			if(m.getParentId()==0) {
				m.setSubMenuList( getMenuList(m.getId()) );
			}
		}
		
		return menuList;
	}

	/**
	 * 根据父级id,查询所有的子菜单,只查某个角色下的
	 * @param parentId 父id
	 * @param roleId 角色id
	 * @return
	 */
	public  List<MenuInfo>getMenuList(int parentId,int roleId){
		System.out.println(parentId);
		System.out.println(roleId);
		String sql="select * from menuInfo where parentId=? and id in( select menuId from roleMenu where roleId=?) "; 	

		List<MenuInfo> menuList= DBUtil.getList(sql, MenuInfo.class, parentId, roleId);	
	
		for(MenuInfo m:menuList) {
			System.out.println(m.getMenuName());
		}
		
		for(MenuInfo m:menuList) {
			if(m.getParentId()==0) {
				m.setSubMenuList( getMenuList(m.getId(),roleId) );
			}
		}
		
		return menuList;
	}
}
