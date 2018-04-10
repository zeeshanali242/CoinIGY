package com.coinigy.model;

import java.util.List;

public class OrdersDTO {
	private List<OrdersOpenDTO> open_orders;
	private List<OrdersHistoryDTO> order_history;

	public List<OrdersOpenDTO> getOpen_orders() {
		return open_orders;
	}

	public void setOpen_orders(List<OrdersOpenDTO> open_orders) {
		this.open_orders = open_orders;
	}

	public List<OrdersHistoryDTO> getOrder_history() {
		return order_history;
	}

	public void setOrder_history(List<OrdersHistoryDTO> order_history) {
		this.order_history = order_history;
	}

}
