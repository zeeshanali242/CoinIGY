package com.coinigy.model;

import java.math.BigDecimal;
import java.util.Date;

import com.coinigy.util.CustomDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class OrdersOpenDTO {
	private String exch_name;
	private String mkt_name;
	private BigDecimal limit_price;
	private String operator;
	private BigDecimal order_id;
	private String order_type;
	private String order_price_type;
	private String order_status;
	private BigDecimal quantity;
	@JsonDeserialize(using=CustomDateAndTimeDeserialize .class)
	private Date order_time;
	private String foreign_order_id;
	private String auth_nickname;
	private long auth_id;
	private BigDecimal quantity_remaining;
	private BigDecimal stop_price;
	private long price_type_id;
	private String exch_code;
	private String display_name;
	public String getExch_name() {
		return exch_name;
	}
	public void setExch_name(String exch_name) {
		this.exch_name = exch_name;
	}
	public String getMkt_name() {
		return mkt_name;
	}
	public void setMkt_name(String mkt_name) {
		this.mkt_name = mkt_name;
	}
	public BigDecimal getLimit_price() {
		return limit_price;
	}
	public void setLimit_price(BigDecimal limit_price) {
		this.limit_price = limit_price;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public BigDecimal getOrder_id() {
		return order_id;
	}
	public void setOrder_id(BigDecimal order_id) {
		this.order_id = order_id;
	}
	public String getOrder_type() {
		return order_type;
	}
	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}
	public String getOrder_price_type() {
		return order_price_type;
	}
	public void setOrder_price_type(String order_price_type) {
		this.order_price_type = order_price_type;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}
	public String getForeign_order_id() {
		return foreign_order_id;
	}
	public void setForeign_order_id(String foreign_order_id) {
		this.foreign_order_id = foreign_order_id;
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
	public BigDecimal getQuantity_remaining() {
		return quantity_remaining;
	}
	public void setQuantity_remaining(BigDecimal quantity_remaining) {
		this.quantity_remaining = quantity_remaining;
	}
	public BigDecimal getStop_price() {
		return stop_price;
	}
	public void setStop_price(BigDecimal stop_price) {
		this.stop_price = stop_price;
	}
	public long getPrice_type_id() {
		return price_type_id;
	}
	public void setPrice_type_id(long price_type_id) {
		this.price_type_id = price_type_id;
	}
	public String getExch_code() {
		return exch_code;
	}
	public void setExch_code(String exch_code) {
		this.exch_code = exch_code;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

}
