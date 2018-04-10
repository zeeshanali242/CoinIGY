package com.coinigy.model;

import java.math.BigDecimal;
import java.util.Date;

import com.coinigy.util.CustomDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PriceTickerDTO {
	
	@JsonDeserialize(using=CustomDateAndTimeDeserialize .class)
	private Date timestamp;
	private BigDecimal high_trade;
	private BigDecimal last_trade;
	private BigDecimal low_trade;
	private String market;
	private BigDecimal ask;
	private BigDecimal bid;
	private BigDecimal current_volume;
	private String exchange;
	public BigDecimal getHigh_trade() {
		return high_trade;
	}
	public void setHigh_trade(BigDecimal high_trade) {
		this.high_trade = high_trade;
	}
	public BigDecimal getLast_trade() {
		return last_trade;
	}
	public void setLast_trade(BigDecimal last_trade) {
		this.last_trade = last_trade;
	}
	public BigDecimal getLow_trade() {
		return low_trade;
	}
	public void setLow_trade(BigDecimal low_trade) {
		this.low_trade = low_trade;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public BigDecimal getAsk() {
		return ask;
	}
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public BigDecimal getCurrent_volume() {
		return current_volume;
	}
	public void setCurrent_volume(BigDecimal current_volume) {
		this.current_volume = current_volume;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
