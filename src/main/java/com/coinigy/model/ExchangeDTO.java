package com.coinigy.model;

import java.math.BigDecimal;

/**
 * @author osscube1
 *
 */
public class ExchangeDTO {
	private long exch_id;
	private String exch_name;
	private String exch_code;
	private BigDecimal exch_fee;
	private int exch_trade_enabled;
	private int exch_balance_enabled;
	private String exch_url;
	public long getExch_id() {
		return exch_id;
	}
	public void setExch_id(long exch_id) {
		this.exch_id = exch_id;
	}
	public String getExch_name() {
		return exch_name;
	}
	public void setExch_name(String exch_name) {
		this.exch_name = exch_name;
	}
	public String getExch_code() {
		return exch_code;
	}
	public void setExch_code(String exch_code) {
		this.exch_code = exch_code;
	}
	public BigDecimal getExch_fee() {
		return exch_fee;
	}
	public void setExch_fee(BigDecimal exch_fee) {
		this.exch_fee = exch_fee;
	}
	public int getExch_trade_enabled() {
		return exch_trade_enabled;
	}
	public void setExch_trade_enabled(int exch_trade_enabled) {
		this.exch_trade_enabled = exch_trade_enabled;
	}
	public int getExch_balance_enabled() {
		return exch_balance_enabled;
	}
	public void setExch_balance_enabled(int exch_balance_enabled) {
		this.exch_balance_enabled = exch_balance_enabled;
	}
	public String getExch_url() {
		return exch_url;
	}
	public void setExch_url(String exch_url) {
		this.exch_url = exch_url;
	}
	
	
	
}
