package com.zking.ssm.biz.impl;

import com.zking.ssm.biz.IItemBiz;
import com.zking.ssm.exception.CustomException;
import com.zking.ssm.mapper.ItemMapper;
import com.zking.ssm.mapper.ItemMapperCustom;
import com.zking.ssm.model.Item;
import com.zking.ssm.model.ItemCustom;
import com.zking.ssm.model.ItemQueryOv;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ItemBizImpl implements IItemBiz {

    @Autowired
    private ItemMapperCustom itemMapperCustom;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<ItemCustom> findItemList(ItemQueryOv itemQueryOv) throws Exception {
        return itemMapperCustom.findItemList(itemQueryOv);
    }

    @Override
    public ItemCustom getItem(Integer id) throws Exception {
        Item item = itemMapper.selectByPrimaryKey(id);

        //中间对商品进行业务处理
        //...
        //返回itemCustom
        ItemCustom itemCustom = null;
        //如果查询出来的商品(item)不为空
        //判断商品是否为空，根据商品id没有查询到商品，抛出异常，提示用户商品信息不存在
        if (null != item) {
            itemCustom = new ItemCustom();
            //将item的值拷贝到itemCustom中
            BeanUtils.copyProperties(item, itemCustom);
        } else if (null == itemCustom) {
            throw new CustomException("修改的商品信息不存在！");
        }

        return itemCustom;
    }

    @Override
    public void updateItem(Integer id, Item item) throws Exception {
        item.setId(id);
        itemMapper.updateByPrimaryKeyWithBLOBs(item);
    }
}