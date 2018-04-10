package com.coinigy.model;

import java.math.BigInteger;

public class PriceTypesDTO {
	private long price_type_id;
	private String name;
	private BigInteger order;

	public long getPrice_type_id() {
		return price_type_id;
	}

	public void setPrice_type_id(long price_type_id) {
		this.price_type_id = price_type_id;
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
