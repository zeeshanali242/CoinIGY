package com.coinigy.model;

import java.util.List;

public class OrdersResponseDTO {
	private OrdersDTO data;
	private List<Notifications> notifications;

	public OrdersDTO getData() {
		return data;
	}

	public void setData(OrdersDTO data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

}
