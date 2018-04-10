package com.coinigy.postparam;

import java.math.BigDecimal;

public class BuyParam {
	private String exchangeCode;
	private String tradePair;
	private BigDecimal quantity;
	private String orderType;
	private BigDecimal limitPrice;
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public BigDecimal getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}
	
}
