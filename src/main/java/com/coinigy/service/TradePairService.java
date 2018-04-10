package com.coinigy.service;

import java.math.BigInteger;
import java.util.List;

import com.coinigy.exception.AccountNotActiveException;
import com.coinigy.exception.AccountNotFoundException;
import com.coinigy.exception.ExchangeNotFoundException;
import com.coinigy.exception.MarketNotFoundException;
import com.coinigy.model.AccountDTO;
import com.coinigy.model.AddOrderResponseDTO;
import com.coinigy.model.BalancesDTO;
import com.coinigy.model.CancelOrderResponseDTO;
import com.coinigy.model.ExchangeDTO;
import com.coinigy.model.MarketDataDTO;
import com.coinigy.model.MarketPairDTO;
import com.coinigy.model.OrderTypesListDTO;
import com.coinigy.model.OrdersDTO;
import com.coinigy.model.PriceTickerDTO;
import com.coinigy.postparam.BalanceParam;
import com.coinigy.postparam.BuyParam;
import com.coinigy.postparam.OrderParam;

public interface TradePairService {


	// Get the exchange list

	public List<ExchangeDTO> getExchangeList();

	// Get the list of price Ticker from the available market in coinigy

	public List<PriceTickerDTO> getPriceTicker(String exchangeCode, String coinPair);

	// Get the all information of all markets
	public List<MarketPairDTO> getMarketList();

	// Get the all information about a specific Exchange
	public List<MarketPairDTO> getMarketListByExchangeCode(String exchangeCode);

	// Get the complete data of a specific currency exchange on a exchange market
	// (All , Asks , Bids , History)

	public MarketDataDTO getMarketDataOfCuurencyPair(String exchangeCode, String coinPairm, String type);

	// Returns a list of your attached exchange accounts and wallets, each with a
	// unique auth_id.

	public List<AccountDTO> accounts();

	// Returns a combined list of balances for all accounts, or specificied auth_ids

	public List<BalancesDTO> balances(BalanceParam param);

	// Returns a list of all open orders and recent order history

	public OrdersDTO orders();
	
	//Returns a list of supported order and price types
	
	public OrderTypesListDTO ordersType();

	//Create a new exchange order. Returns internal_order_id upon success.

	public AddOrderResponseDTO addOrder(OrderParam param);
	
	public CancelOrderResponseDTO cancelOrder(BigInteger orderId);
	
	public List<PriceTickerDTO> getMarketDataOfRealtime(String pair);
	
	public AddOrderResponseDTO buy(BuyParam param) throws AccountNotFoundException , MarketNotFoundException ,  ExchangeNotFoundException , AccountNotActiveException;

	//get the data in a day from coinigy
	
	public List<PriceTickerDTO> getDailyPriceTicker();
}
