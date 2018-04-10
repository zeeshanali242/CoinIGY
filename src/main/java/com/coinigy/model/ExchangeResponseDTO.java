package com.coinigy.model;

import java.util.List;

public class ExchangeResponseDTO {
	private List<ExchangeDTO> data;
	private List<Notifications> notifications;
	public List<ExchangeDTO> getData() {
		return data;
	}

	public void setData(List<ExchangeDTO> data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}
	 
	
}
