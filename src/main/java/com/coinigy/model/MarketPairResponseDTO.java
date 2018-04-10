package com.coinigy.model;

import java.util.List;

public class MarketPairResponseDTO {
	private List<MarketPairDTO> data;
	private List<Notifications> notifications;

	public List<MarketPairDTO> getData() {
		return data;
	}

	public void setData(List<MarketPairDTO> data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

}
