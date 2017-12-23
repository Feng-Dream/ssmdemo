package com.zking.ssm.mapper;

import com.zking.ssm.model.Item;
import com.zking.ssm.model.ItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
	long countByExample(ItemExample example);

	int deleteByExample(ItemExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Item record);

	int insertSelective(Item record);

	List<Item> selectByExampleWithBLOBs(ItemExample example);

	List<Item> selectByExample(ItemExample example);

	Item selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByExampleWithBLOBs(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

	int updateByPrimaryKeySelective(Item record);

	int updateByPrimaryKeyWithBLOBs(Item record);

	int updateByPrimaryKey(Item record);
}