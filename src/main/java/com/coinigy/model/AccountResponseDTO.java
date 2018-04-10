package com.coinigy.model;

import java.util.List;

public class AccountResponseDTO {
	private List<AccountDTO> data;
	private List<Notifications> notifications;

	public List<AccountDTO> getData() {
		return data;
	}

	public void setData(List<AccountDTO> data) {
		this.data = data;
	}

	public List<Notifications> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notifications> notifications) {
		this.notifications = notifications;
	}

}
