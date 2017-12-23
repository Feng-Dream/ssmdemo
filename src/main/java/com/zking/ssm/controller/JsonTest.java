package com.zking.ssm.controller;

import com.zking.ssm.model.ItemCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Json数据交互测试
 */
@Controller
public class JsonTest {
    //请求json串(商品信息)，输出json(商品信息)
    //@RequestBody将请求的商品信息的json串转成ItemCustom对象
    //@ResponseBody将ItemCustom对象转成json输出
    @RequestMapping(value = "requestJson", method = {RequestMethod.POST}, consumes = {"application/json"})
    @ResponseBody
    public ItemCustom requestJson(@RequestBody ItemCustom itemCustom) {
        System.out.println(itemCustom);
        return itemCustom;
    }

    @RequestMapping(value = "responseJson", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ItemCustom responseJson(ItemCustom itemCustom) {
        return itemCustom;
    }
}
