package com.coinigy.model;

import java.math.BigInteger;

public class OrderTypesDTO {
	private long order_type_id;
	private String name;
	private BigInteger order;

	public long getOrder_type_id() {
		return order_type_id;
	}

	public void setOrder_type_id(long order_type_id) {
		this.order_type_id = order_type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getOrder() {
		return order;
	}

	public void setOrder(BigInteger order) {
		this.order = order;
	}

}
