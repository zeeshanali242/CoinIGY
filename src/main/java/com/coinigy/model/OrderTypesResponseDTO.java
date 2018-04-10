package com.coinigy.model;

import java.util.List;

public class OrderTypesResponseDTO {
	private OrderTypesListDTO data;
	private List<Notifications> notifications;

	public OrderTypesListDTO getData() {
		return data;
	}

	public void setData(OrderTypesListDTO data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

}
