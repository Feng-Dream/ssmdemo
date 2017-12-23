package com.zking.ssm.mapper;

import com.zking.ssm.model.ItemCustom;
import com.zking.ssm.model.ItemQueryOv;

import java.util.List;

public interface ItemMapperCustom {

    public List<ItemCustom> findItemList(ItemQueryOv itemQueryOv) throws Exception;
}
