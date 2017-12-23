package com.zking.ssm.biz;

import com.zking.ssm.model.Item;
import com.zking.ssm.model.ItemCustom;
import com.zking.ssm.model.ItemQueryOv;

import java.util.List;

public interface IItemBiz {

    public List<ItemCustom> findItemList(ItemQueryOv itemQueryOv) throws Exception;

    public ItemCustom getItem(Integer id) throws Exception;

    public void updateItem(Integer id, Item item) throws Exception;
}
