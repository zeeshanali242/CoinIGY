package com.coinigy.model;

import java.math.BigDecimal;

public class OrdersRequest {

	private String exchangeCode;
	private String tradePair;
	private String orderType;
	private BigDecimal quantity;
	public String getExchangeCode() {
		return exchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	public String getTradePair() {
		return tradePair;
	}
	public void setTradePair(String tradePair) {
		this.tradePair = tradePair;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
}
