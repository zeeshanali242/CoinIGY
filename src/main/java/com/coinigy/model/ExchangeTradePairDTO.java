package com.coinigy.model;

import java.math.BigDecimal;

public class ExchangeTradePairDTO {
	
	private String exchangeCode;
    private String tradePair;
    private BigDecimal lastTrade;
    private BigDecimal highTrade;
    private BigDecimal lowTrade;
    private BigDecimal currentVolume;
    private String timestamp;
    private BigDecimal ask;
    private BigDecimal bid;
    
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
	public BigDecimal getLastTrade() {
		return lastTrade;
	}
	public void setLastTrade(BigDecimal lastTrade) {
		this.lastTrade = lastTrade;
	}
	public BigDecimal getHighTrade() {
		return highTrade;
	}
	public void setHighTrade(BigDecimal highTrade) {
		this.highTrade = highTrade;
	}
	public BigDecimal getLowTrade() {
		return lowTrade;
	}
	public void setLowTrade(BigDecimal lowTrade) {
		this.lowTrade = lowTrade;
	}
	public BigDecimal getCurrentVolume() {
		return currentVolume;
	}
	public void setCurrentVolume(BigDecimal currentVolume) {
		this.currentVolume = currentVolume;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
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
    
	
}
