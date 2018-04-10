package com.coinigy.model;

import java.util.List;

public class PriceTickerResponseDTO {
	private List<String> notifications;
    private List<PriceTickerDTO> data;
	
    public List<String> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}
	public List<PriceTickerDTO> getData() {
		return data;
	}
	public void setData(List<PriceTickerDTO> data) {
		this.data = data;
	}
}
