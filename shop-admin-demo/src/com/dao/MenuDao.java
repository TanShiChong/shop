package com.dao;
import java.util.List;
import com.beans.MenuInfo;
import com.jdbc.DBUtil;

public class MenuDao {
	/**
	 * ���ݸ���id,��ѯ���е��Ӳ˵�
	 * @param parentId ����id
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
	 * ���ݸ���id,��ѯ���е��Ӳ˵�,ֻ��ĳ����ɫ�µ�
	 * @param parentId ��id
	 * @param roleId ��ɫid
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
