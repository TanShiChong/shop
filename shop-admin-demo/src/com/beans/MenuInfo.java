package com.beans;

import java.util.List;

//菜单表
public class MenuInfo {
	private int id;
	private String menuName;
	private String url;
	private String icon;
	private int parentId;
	
	//该菜单下面所有的子菜单
	private List<MenuInfo>subMenuList;
	
	
	
	public List<MenuInfo> getSubMenuList() {
		return subMenuList;
	}
	public void setSubMenuList(List<MenuInfo> subMenuList) {
		this.subMenuList = subMenuList;
	}
	public int getId() {
		return id;
	}
	public String getMenuName() {
		return menuName;
	}
	public String getUrl() {
		return url;
	}
	public String getIcon() {
		return icon;
	}
	public int getParentId() {
		return parentId;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	} 

}
