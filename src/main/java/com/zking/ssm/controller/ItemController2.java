package com.zking.ssm.controller;

import com.zking.ssm.model.Item;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Item> items = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setId(12);
		item1.setName("小米机械键盘2");
		item1.setPrice(666.62f);

		Item item2 = new Item();
		item2.setId(22);
		item2.setName("小米移动电源2");
		item2.setPrice(188.82f);

		Item item3 = new Item();
		item3.setId(32);
		item3.setName("小米6代手机2");
		item3.setPrice(5999.92f);

		Item item4 = new Item();
		item4.setId(42);
		item4.setName("小米6代手机2");
		item4.setPrice(5999.92f);

		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		request.setAttribute("items", items);
		request.getRequestDispatcher("item/itemList").forward(request, response);

	}
}
