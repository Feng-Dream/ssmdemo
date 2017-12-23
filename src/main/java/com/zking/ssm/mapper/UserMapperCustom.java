package com.zking.ssm.mapper;

import com.zking.ssm.model.User;
import com.zking.ssm.model.UserCustom;
import com.zking.ssm.model.UserQueryOv;

import java.util.List;

public interface UserMapperCustom {

	// 综合查询
	public List<UserCustom> findUserList(UserQueryOv userQueryOv);

	// 综合查询总数
	public Integer findUserCount(UserQueryOv userQueryOv);

	// 根据ID查询 使用resultMap进行输出映射
	public User findUserByIdResultMap(Integer userId);

	// 根据ID查询
	public User findUserById(Integer userId);

	// 根据名字查询
	public List<User> findUserByName(String userName);

	// 根据名字模糊查询
	public List<User> findUserByName2(String userName);

	// 根据名字和密码查询
	public User findUserByNamePwd(User user);

	// 查询全部
	public List<User> findUser();

	// 新增
	public void insertUser(User user);

	// 根据ID修改
	public void updateUser(User user);

	// 根据ID删除
	public void deleteUser(Integer userId);
}
