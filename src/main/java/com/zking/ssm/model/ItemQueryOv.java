package com.zking.ssm.model;

import java.io.Serializable;

public class ItemQueryOv implements Serializable {

	private static final long serialVersionUID = -6072217798106934665L;

	private ItemCustom itemCustom;

	public ItemQueryOv() {
		super();
	}

	public ItemCustom getItemCustom() {
		return itemCustom;
	}

	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}

}
