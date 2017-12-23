package com.zking.ssm.controller;

import com.zking.ssm.biz.IItemBiz;
import com.zking.ssm.controller.validation.ValidGroup1;
import com.zking.ssm.model.ItemCustom;
import com.zking.ssm.model.ItemQueryOv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
//为了对url进行分类管理，可以在这里定义跟路径，最终访问url是跟路径+子路径
//比如：商品列表：/item/findItemList.action
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemBiz itemBiz;

    //商品分类
    //itemtypes表示最终将方法返回值放在request中的key
    @ModelAttribute("itemtypes")
    public Map<String, String> getItemTypes() {
        Map<String, String> itemTypes = new HashMap<String, String>();
        itemTypes.put("101", "数码");
        itemTypes.put("102", "家具");
        return itemTypes;
    }

    // @RequestMapping实现对queryItem方法和url进行映射，一个方法对应一个url
    // 一般建议将url和方法名写成一样
    @RequestMapping("findItemList")
    public ModelAndView findItemList(ItemQueryOv itemQueryOv) throws Exception {

        List<ItemCustom> items = itemBiz.findItemList(itemQueryOv);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", items);
        modelAndView.setViewName("item/itemList");

        return modelAndView;
    }

    //	@RequestMapping("editItem")
    //限制http请求方法
//    @RequestMapping(value = "editItem", method = {RequestMethod.POST,RequestMethod.GET})
//    public ModelAndView editItem() throws Exception {
//        ItemCustom itemCustom = itemBiz.getItem(2);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("item", itemCustom);
//        modelAndView.setViewName("item/editItem");
//        return modelAndView;
//    }

    @RequestMapping(value = "editItem", method = {RequestMethod.POST, RequestMethod.GET})
    //RequestParam里边指定request传入参数名称和形参进行绑定
    //通过required属性指定参数是否必须传入
    //通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定
    public String editItem(Model model, @RequestParam(value = "id", required = true) Integer itemId) throws Exception {
        //调用service根据商品id查询商品信息
        ItemCustom itemCustom = itemBiz.getItem(itemId);
        //判断商品是否为空，根据商品id没有查询到商品，抛出异常，提示用户商品信息不存在
//        if (null == itemCustom) {
//            throw new CustomException("修改的商品信息不存在！");
//        }

        //通过形参中的model将model数据传输到页面
        //相当于modelAndView.addObject方法
        model.addAttribute("item", itemCustom);

        return "item/editItem";
    }

//    @RequestMapping("editItemSubmit")
//    public ModelAndView editItemSubmit() throws Exception {
//
////		itemBiz.updateItem(2, null);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("message", "修改成功");
//        modelAndView.setViewName("common/success");
//        return modelAndView;
//    }

    //在需要校验的poji前边添加@Validated，在需要校验的pojo后边添加BindingResult接收校验出错信息
    //注意：@Validated和BindingResult是配对出现的，并且形参顺序是固定的（一前一后）
    //@Validated(value = {ValidGroup1.class})指定使用ValidGroup1分组的校验
    //@ModelAttribute可以指定pojo回显到页面在request的key
    @RequestMapping("editItemSubmit")
    public String editItemSubmit(Model model, Integer id, @ModelAttribute("item") @Validated(value = {ValidGroup1.class}) ItemCustom itemCustom, BindingResult bindingResult, MultipartFile itemPic) throws Exception {

        //获取校验错误信息
        if (bindingResult.hasErrors()) {//如果有错误信息
            //输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                //输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            //将错误信息传到页面
            model.addAttribute("allErrors", allErrors);

            //可以直接使用model将提交的pojo回显到页面
            //model.addAttribute("item",itemCustom);

            //出错重新到商品修改页面
            return "item/editItem";
        }

        //原始图片名称
        String originalFilename = itemPic.getOriginalFilename();
        //如果文件不为空
        if (null != itemPic && null != originalFilename && 0 < originalFilename.length()) {
            //上传图片

            //存储图片的物理路径
            String picPath = "D:\\temp\\upload\\";

            //新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            //新图片
            File newFile = new File(picPath + newFileName);

            //将内存中的数据写入磁盘
            itemPic.transferTo(newFile);

            //将新图片名称写到itemCustom中
            itemCustom.setPic(newFileName);
        }

        itemBiz.updateItem(id, itemCustom);

        //重定向到商品查询列表
//        return "redirect:findItemList.action";
        model.addAttribute("message", "修改成功");
        //转发到成功页面
//        return "forward:/WEB-INF/jsp/common/success.jsp";

        return "common/success";
    }
}