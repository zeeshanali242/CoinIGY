package com.coinigy.model;

public class AccountDTO {
	private String auth_secret;
	private Integer exch_trade_enabled;
	private String auth_optional1;
	private String auth_nickname;
	private long auth_id;
	private long exch_id;
	private String auth_updated;
	private Integer auth_trade;
	private Integer auth_active;
	private String exch_name;
	private String auth_key;

	public String getAuth_secret() {
		return auth_secret;
	}

	public void setAuth_secret(String auth_secret) {
		this.auth_secret = auth_secret;
	}

	public String getAuth_optional1() {
		return auth_optional1;
	}

	public void setAuth_optional1(String auth_optional1) {
		this.auth_optional1 = auth_optional1;
	}

	public String getAuth_nickname() {
		return auth_nickname;
	}

	public void setAuth_nickname(String auth_nickname) {
		this.auth_nickname = auth_nickname;
	}

	public long getAuth_id() {
		return auth_id;
	}

	public void setAuth_id(long auth_id) {
		this.auth_id = auth_id;
	}

	public long getExch_id() {
		return exch_id;
	}

	public void setExch_id(long exch_id) {
		this.exch_id = exch_id;
	}

	public String getAuth_updated() {
		return auth_updated;
	}

	public void setAuth_updated(String auth_updated) {
		this.auth_updated = auth_updated;
	}
	

	public Integer getAuth_trade() {
		return auth_trade;
	}

	public void setAuth_trade(Integer auth_trade) {
		this.auth_trade = auth_trade;
	}

	public String getExch_name() {
		return exch_name;
	}

	public void setExch_name(String exch_name) {
		this.exch_name = exch_name;
	}

	public String getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}

	public Integer getExch_trade_enabled() {
		return exch_trade_enabled;
	}

	public void setExch_trade_enabled(Integer exch_trade_enabled) {
		this.exch_trade_enabled = exch_trade_enabled;
	}

	public Integer getAuth_active() {
		return auth_active;
	}

	public void setAuth_active(Integer auth_active) {
		this.auth_active = auth_active;
	}

}
