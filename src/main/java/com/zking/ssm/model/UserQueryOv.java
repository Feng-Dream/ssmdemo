package com.zking.ssm.model;

import java.util.List;

/**
 * 用户（User）的包装器类
 * 
 * 在这里包装所需要的查询条件
 * 
 * @author Administrator
 *
 */
public class UserQueryOv {

	// 接收多个id
	private List<Integer> user_ids;

	// 用户查询条件
	private UserCustom userCustom;

	public List<Integer> getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(List<Integer> user_ids) {
		this.user_ids = user_ids;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	// 可以包装其他的查询条件 比如：商品、订单

}
