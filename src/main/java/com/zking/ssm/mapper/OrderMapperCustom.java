package com.zking.ssm.mapper;

import com.zking.ssm.model.Order;
import com.zking.ssm.model.OrderCustom;
import com.zking.ssm.model.User;

import java.util.List;

public interface OrderMapperCustom {

	public List<OrderCustom> findOrderUser();

	public List<Order> findOrderUserResultMap();

	public List<Order> findOrderUserAndOrderDetailResultMap();

	public List<User> findUserAndItemResultMap();

	public List<Order> findOrderUserLazyLoading();
}
