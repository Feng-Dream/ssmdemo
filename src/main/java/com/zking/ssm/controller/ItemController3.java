package com.zking.ssm.controller;

import com.zking.ssm.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

//使用@Controller标注这是一个控制器
@Controller
public class ItemController3 {

	// @RequestMapping实现对queryItem方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法名写成一样
	@RequestMapping("/queryItemList3")
	public ModelAndView queryItemList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Item> items = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setId(15);
		item1.setName("小米机械键盘5");
		item1.setPrice(666.65f);

		Item item2 = new Item();
		item2.setId(25);
		item2.setName("小米移动电源5");
		item2.setPrice(188.85f);

		Item item3 = new Item();
		item3.setId(35);
		item3.setName("小米6代手机5");
		item3.setPrice(5999.95f);

		Item item4 = new Item();
		item4.setId(45);
		item4.setName("小米7代手机5");
		item4.setPrice(7999.95f);

		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", items);
		modelAndView.setViewName("item/itemList");

		return modelAndView;
	}
}
