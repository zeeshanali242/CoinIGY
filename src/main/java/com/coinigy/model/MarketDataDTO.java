package com.coinigy.model;

import java.util.List;

public class MarketDataDTO {
	private List<HistoryDataDTO> history;
	private String exch_code;
	private String primary_curr_code;
	private List<AsksDTO> asks;
	private String secondary_curr_code;
	private List<BidsDTO> bids;
	private String type;

	public List<HistoryDataDTO> getHistory() {
		return history;
	}

	public void setHistory(List<HistoryDataDTO> history) {
		this.history = history;
	}

	public String getExch_code() {
		return exch_code;
	}

	public void setExch_code(String exch_code) {
		this.exch_code = exch_code;
	}

	public String getPrimary_curr_code() {
		return primary_curr_code;
	}

	public void setPrimary_curr_code(String primary_curr_code) {
		this.primary_curr_code = primary_curr_code;
	}

	public List<AsksDTO> getAsks() {
		return asks;
	}

	public void setAsks(List<AsksDTO> asks) {
		this.asks = asks;
	}

	public String getSecondary_curr_code() {
		return secondary_curr_code;
	}

	public void setSecondary_curr_code(String secondary_curr_code) {
		this.secondary_curr_code = secondary_curr_code;
	}

	public List<BidsDTO> getBids() {
		return bids;
	}

	public void setBids(List<BidsDTO> bids) {
		this.bids = bids;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
