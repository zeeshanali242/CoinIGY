package com.coinigy.model;

import java.util.List;

public class MarketDataResponseDTO {
	private List<Notifications> notifications;
	private MarketDataDTO data;

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

	public MarketDataDTO getData() {
		return data;
	}

	public void setData(MarketDataDTO data) {
		this.data = data;
	}

}

