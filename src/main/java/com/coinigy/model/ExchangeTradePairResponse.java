package com.coinigy.model;

import java.util.List;

public class ExchangeTradePairResponse {

	private List<ExchangeTradePairDTO> data;

	public List<ExchangeTradePairDTO> getData() {
		return data;
	}

	public void setData(List<ExchangeTradePairDTO> data) {
		this.data = data;
	}
}
