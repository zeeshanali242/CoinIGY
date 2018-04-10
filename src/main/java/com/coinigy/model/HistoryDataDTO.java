package com.coinigy.model;

import java.util.Date;

import com.coinigy.util.CustomDateAndTimeDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class HistoryDataDTO {
	private String price;
    private String quantity;
    private String type;
	@JsonDeserialize(using=CustomDateAndTimeDeserialize .class)
    private Date time_local;
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTime_local() {
		return time_local;
	}
	public void setTime_local(Date time_local) {
		this.time_local = time_local;
	}
}
