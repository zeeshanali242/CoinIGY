package com.coinigy.model;

import java.util.List;

public class OrderTypesListDTO {
	private List<OrderTypesDTO> order_types;
	private List<PriceTypesDTO> price_types;

	public List<OrderTypesDTO> getOrder_types() {
		return order_types;
	}

	public void setOrder_types(List<OrderTypesDTO> order_types) {
		this.order_types = order_types;
	}

	public List<PriceTypesDTO> getPrice_types() {
		return price_types;
	}

	public void setPrice_types(List<PriceTypesDTO> price_types) {
		this.price_types = price_types;
	}

}
