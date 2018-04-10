package com.coinigy.model;

import java.util.List;

public class CancelOrderResponseDTO {
	private List<String> data;
	private List<Notifications> notifications;
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	public List<Notifications> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}
	
}
