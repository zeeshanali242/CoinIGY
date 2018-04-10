package com.coinigy.model;

import java.util.List;

public class BalancesResponseDTO {
	private List<Notifications> notifications;
	private List<BalancesDTO> data;

	public List<BalancesDTO> getData() {
		return data;
	}

	public void setData(List<BalancesDTO> data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

}
