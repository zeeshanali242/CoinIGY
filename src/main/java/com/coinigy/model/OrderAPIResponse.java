package com.coinigy.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class OrderAPIResponse {
	private BigInteger orderId;
	private String exchangeCode;
	private String tradePair;
	private BigDecimal quantity;
	private String status;
	private Date timestamp;
	public BigInteger getOrderId() {
		return orderId;
	}
	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
