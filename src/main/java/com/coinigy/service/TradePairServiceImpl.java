package com.coinigy.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.coinigy.exception.AccountNotActiveException;
import com.coinigy.exception.AccountNotFoundException;
import com.coinigy.exception.ExchangeNotFoundException;
import com.coinigy.exception.MarketNotFoundException;
import com.coinigy.model.AccountDTO;
import com.coinigy.model.AccountResponseDTO;
import com.coinigy.model.AddOrderResponseDTO;
import com.coinigy.model.BalancesDTO;
import com.coinigy.model.BalancesResponseDTO;
import com.coinigy.model.CancelOrderResponseDTO;
import com.coinigy.model.ExchangeDTO;
import com.coinigy.model.ExchangeResponseDTO;
import com.coinigy.model.ExchangeTradePairResponse;
import com.coinigy.model.MarketDataDTO;
import com.coinigy.model.MarketDataResponseDTO;
import com.coinigy.model.MarketPairDTO;
import com.coinigy.model.MarketPairResponseDTO;
import com.coinigy.model.OrderTypesListDTO;
import com.coinigy.model.OrderTypesResponseDTO;
import com.coinigy.model.OrdersDTO;
import com.coinigy.model.OrdersResponseDTO;
import com.coinigy.model.PriceTickerDTO;
import com.coinigy.model.PriceTickerResponseDTO;
import com.coinigy.postparam.BalanceParam;
import com.coinigy.postparam.BuyParam;
import com.coinigy.postparam.OrderParam;
import com.coinigy.util.APIInvoke;
import com.coinigy.util.JSONToObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service("tradePairService")
public class TradePairServiceImpl implements TradePairService {

	Logger logger = Logger.getLogger(ExchangeTradePairResponse.class);

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.websystique.springboot.service.TradePairService#getExchangeList()
	 * 
	 * Get the available exchange list from coinigy api.
	 * 
	 */

	@Override
	public List<ExchangeDTO> getExchangeList() {
		// call api and get the resoponse
		String response = APIInvoke.callApiURL("exchanges", "");
		if (response != null) {
			try {
				ExchangeResponseDTO list = JSONToObjectMapper.convertJsonToObject(response, ExchangeResponseDTO.class);
				return list.getData();
			} catch (Exception e) {
				logger.error("Exception inside getExchangeList ", e);
			}
		}
		return new ArrayList<>();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.websystique.springboot.service.TradePairService#getPriceTicker(java.
	 * lang. String, java.lang.String)
	 * 
	 * @param exchangeCode code of exchange to get the price ticker from
	 * specific exchange
	 * 
	 * @param coinPair for specific pair
	 * 
	 * Get the list of price Ticker from the available market in coinigy
	 * 
	 */

	@Override
	public List<PriceTickerDTO> getPriceTicker(String exchangeCode, String coinPair) {
		String priceTicker = APIInvoke.callApiURL("ticker",
				"{\"exchange_code\" :\"" + exchangeCode + "\",\"exchange_market\":\"" + coinPair + "\"}");
		logger.info("data is " + priceTicker);
		if (priceTicker != null) {
			try {
				PriceTickerResponseDTO tickerList = JSONToObjectMapper.convertJsonToObject(priceTicker,
						PriceTickerResponseDTO.class);
				return tickerList.getData();
			} catch (Exception e) {
				logger.error("Exception to get market list based on exchange code : ", e);
			}
		}
		logger.info("service data is " + priceTicker);
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.websystique.springboot.service.TradePairService#getMarketList(java.
	 * lang. String)\
	 * 
	 * @param exchangeCode based on this code it returns the information of that
	 * exchange.
	 * 
	 * Get the all information about a specific Exchange
	 * 
	 */

	@Override
	public List<MarketPairDTO> getMarketListByExchangeCode(String exchangeCode) {
		String marketResponse = APIInvoke.callApiURL("markets", "{\"exchange_code\" : \"" + exchangeCode + "\"}");
		try {
			MarketPairResponseDTO marketList = JSONToObjectMapper.convertJsonToObject(marketResponse,
					MarketPairResponseDTO.class);
			return marketList.getData();
		} catch (Exception e) {
			logger.error("Exception to get market list based on exchange code : ", e);
		}
		logger.info("service data is " + marketResponse);
		return new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.websystique.springboot.service.TradePairService#getMarketList()
	 * 
	 * Get the all market information
	 * 
	 */

	@Override
	public List<MarketPairDTO> getMarketList() {
		String marketResponse = APIInvoke.callApiURL("markets", "");
		try {
			MarketPairResponseDTO marketList = JSONToObjectMapper.convertJsonToObject(marketResponse,
					MarketPairResponseDTO.class);
			return marketList.getData();
		} catch (Exception e) {
			logger.error("Exception to get market list : ", e);
		}
		logger.info("service data is " + marketResponse);
		return new ArrayList<>();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.websystique.springboot.service.TradePairService#
	 * getMarketDataOfCuurencyPair(java.lang.String, java.lang.String,
	 * java.lang.String)
	 * 
	 * @param exchangeCode code of exchange which data it returns
	 * 
	 * @param coinPair currency pair of exchange (BTC/USD) it return this pair
	 * data of that (@exchangeCode) exchange
	 * 
	 * @param type (all, bids , asks , orders , history)
	 * 
	 * Get the all trading information of a currency pair at a perticuler
	 * exchange
	 * 
	 * 
	 */

	@Override
	public MarketDataDTO getMarketDataOfCuurencyPair(String exchangeCode, String coinPair, String type) {
		String postParams = "{\"exchange_code\":\"" + exchangeCode + "\",\"exchange_market\":\"" + coinPair
				+ "\",\"type\":\"" + type + "\"}";
		logger.info("Market data params is : " + postParams);
		String marketResponse = APIInvoke.callApiURL("data", postParams);
		try {
			MarketDataResponseDTO marketDataList = JSONToObjectMapper.convertJsonToObject(marketResponse,
					MarketDataResponseDTO.class);

			return marketDataList.getData();

		} catch (Exception e) {
			logger.error("Exception to getMarketDataOfCuurencyPair  : ", e);
		}

		return null;
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.websystique.springboot.service.TradePairService#accounts()
	 * 
	 * Returns a list of your attached exchange accounts and wallets, each with
	 * a unique auth_id.
	 */

	@Override
	public List<AccountDTO> accounts() {
		String accountResponse = APIInvoke.callApiURL("accounts", "");
		try {
			AccountResponseDTO accountList = JSONToObjectMapper.convertJsonToObject(accountResponse,
					AccountResponseDTO.class);
			return accountList.getData();

		} catch (Exception e) {
			logger.error("Exception to accounts : ", e);
		}
		return new ArrayList<>();
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.websystique.springboot.service.TradePairService#balances()
	 * 
	 * 
	 */

	@Override
	public List<BalancesDTO> balances(BalanceParam param) {
		String balanceResponse = APIInvoke.callApiURL("balances",
				"{\"show_nils\":\"" + param.getShow_nils() + "\",\"auth_ids\":\"" + param.getAuth_ids() + "\"}");
		try {
			BalancesResponseDTO balanceList = JSONToObjectMapper.convertJsonToObject(balanceResponse,
					BalancesResponseDTO.class);
			return balanceList.getData();
		} catch (Exception e) {
			logger.error("Exception to Balances : ", e);
		}
		return new ArrayList<>();
	}

	@Override
	public OrdersDTO orders() {
		String orderResponse = APIInvoke.callApiURL("orders", "");
		try {

			OrdersResponseDTO ordersList = JSONToObjectMapper.convertJsonToObject(orderResponse,
					OrdersResponseDTO.class);
			return ordersList.getData();
		} catch (Exception e) {
			logger.error("Exception to Orders : ", e);
		}

		return null;
	}

	@Override
	public OrderTypesListDTO ordersType() {
		String orderTypeResponse = APIInvoke.callApiURL("orderTypes", "");
		try {
			OrderTypesResponseDTO ordersList = JSONToObjectMapper.convertJsonToObject(orderTypeResponse,
					OrderTypesResponseDTO.class);
			return ordersList.getData();
		} catch (Exception e) {
			logger.error("Exception to Orders Types : ", e);
		}

		return null;
	}

	@Override
	public AddOrderResponseDTO addOrder(OrderParam param) {
		String addOrderResponse = APIInvoke.callApiURL("addOrder",
				"{\"auth_id\" : \"" + param.getAuth_id() + "\"," + "\"exch_id\" : \"" + param.getExch_id() + "\","
						+ "\"mkt_id\" : \"" + param.getMkt_id() + "\"," + "\"order_type_id\" : \""
						+ param.getOrder_type_id() + "\"," + "\"price_type_id\":\"" + param.getPrice_type_id() + "\","
						+ "\"limit_price\":\"" + param.getLimit_price() + "\"," + " \"order_quantity\":\""
						+ param.getOrder_quantity() + "\"}");
		try {
			return JSONToObjectMapper.convertJsonToObject(addOrderResponse, AddOrderResponseDTO.class);

		} catch (Exception e) {
			logger.error("Exception to add order : ", e);
		}

		return null;
	}

	@Override
	public CancelOrderResponseDTO cancelOrder(BigInteger orderId) {
		String cancelOrderResponse = APIInvoke.callApiURL("orderTypes", "\"internal_order_id\" : \"" + orderId + "\"}");
		try {
			return JSONToObjectMapper.convertJsonToObject(cancelOrderResponse, CancelOrderResponseDTO.class);
		} catch (Exception e) {
			logger.error("Exception to Orders Types : ", e);
		}
		return null;
	}

	/*
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.websystique.springboot.service.TradePairService#
	 * getMarketDataOfRealtime( java.lang.String)
	 * 
	 * @param pair based on this pair it will get all markets data of that pair
	 * and return minimum 5 ask order list
	 * 
	 */

	@Override
	public List<PriceTickerDTO> getMarketDataOfRealtime(String pair) {
		String marketResponse = APIInvoke.callApiURL("markets", "");
		List<MarketPairDTO> marketList = new LinkedList<>();
		List<PriceTickerDTO> tickerList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		JSONObject json = null;
		try {
			json = new JSONObject(marketResponse);
			JSONArray array = json.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				JSONObject jsonObject = array.getJSONObject(i);
				if (jsonObject.getString("mkt_name").equalsIgnoreCase(pair)) {
					MarketPairDTO market = mapper.readValue(jsonObject.toString(), MarketPairDTO.class);
					marketList.add(market);
				}
			}

		} catch (Exception e) {
			logger.error("Error in getMarketDataOfRealtime for market data : ", e);
		}

		for (MarketPairDTO market : marketList) {
			String marketTicker = APIInvoke.callApiURL("ticker",
					"{\"exchange_code\" :\"" + market.getExch_code() + "\",\"exchange_market\":\"" + pair + "\"}");
			try {
				JSONObject tickerJson = new JSONObject(marketTicker);
				JSONArray tickerArray = tickerJson.getJSONArray("data");
				if (tickerArray != null && tickerArray.length() > 0) {
					PriceTickerDTO ticker = mapper.readValue(tickerArray.getJSONObject(0).toString(),
							PriceTickerDTO.class);
					tickerList.add(ticker);
				}
			} catch (Exception e) {
				logger.error("Error in getMarketDataOfRealtime for ticker data  : ", e);
			}
		}
		Collections.sort(tickerList, (s1, s2) -> s1.getAsk().compareTo(s2.getAsk()));
		return tickerList;
	}

	/*
	 * @param exchangeCode
	 * 
	 * @param tradePair it will return MarketId ExchnageId and other information
	 * of a pair on a particular exchange based on given @param
	 */
	private MarketPairDTO getMarketPair(String exchangeCode, String pair) {
		List<MarketPairDTO> marketList = getMarketListByExchangeCode(exchangeCode);
		if (!marketList.isEmpty()) {
			List<MarketPairDTO> foundObjs = marketList.stream()
					.filter(market -> market.getExch_code().equalsIgnoreCase(exchangeCode))
					.collect(Collectors.toList());
			if (!foundObjs.isEmpty())
				return foundObjs.get(0);
		}
		return null;
	}

	/*
	 * @param exchangeCode
	 * 
	 * @param tradePair it will return MarketId ExchnageId and other information
	 * of a pair on a particular exchange based on given @param
	 */
	@Override
	public AddOrderResponseDTO buy(BuyParam postParam) throws AccountNotFoundException, MarketNotFoundException,
			ExchangeNotFoundException, AccountNotActiveException {
		List<AccountDTO> accountList = accounts();
		List<ExchangeDTO> exchangeList = getExchangeList();
		List<ExchangeDTO> exchList = exchangeList.stream()
				.filter(exch -> postParam.getExchangeCode().equals(exch.getExch_code())).collect(Collectors.toList());
		if (!exchList.isEmpty()) {
			List<AccountDTO> accList = accountList.stream()
					.filter(acc -> exchList.get(0).getExch_id() == (acc.getExch_id())).collect(Collectors.toList());
			if (!accList.isEmpty()) {
				AccountDTO acc = accList.get(0);
				if (acc.getAuth_active() == 1 && acc.getAuth_trade() == 1 && acc.getExch_trade_enabled() == 1) {
					MarketPairDTO market = getMarketPair(postParam.getExchangeCode(), postParam.getTradePair());
					if (market == null)
						throw new MarketNotFoundException();
					OrderParam param = new OrderParam();
					param.setAuth_id(accList.get(0).getAuth_id());
					param.setExch_id(market.getExch_id());
					param.setLimit_price(postParam.getLimitPrice());
					param.setMkt_id(market.getMkt_id());
					param.setOrder_quantity(postParam.getQuantity());
					param.setOrder_type_id(1);
					param.setPrice_type_id(3);
					return addOrder(param);
				} else
					throw new AccountNotActiveException();
			} else
				throw new AccountNotFoundException();

		} else
			throw new ExchangeNotFoundException();
	}
	
	/*
	 *  it will return a list of minimum price ticker of market having base currency
	 *  either BTC or ETH of those exchanges which linked with CoinIGY
	 */
	
	@Override
	public List<PriceTickerDTO> getDailyPriceTicker() {
		System.out.println(".........calling coinigy getDailyPriceTicker...........");
		List<ExchangeDTO> exchangeList = getExchangeList();
		System.out.println("Exchange list is " + exchangeList);
		List<AccountDTO> accountList = accounts();
		System.out.println("account list  list is " + accountList);
		Predicate<ExchangeDTO> hasSameExchId = e -> accountList.stream()
				.anyMatch(a -> a.getExch_id() == e.getExch_id());
		List<ExchangeDTO> filteredExchangelist = exchangeList.stream().filter(hasSameExchId)
				.collect(Collectors.toList());
		List<MarketPairDTO> marketPairList;
		List<MarketPairDTO> filteredMarketPairList = new ArrayList<MarketPairDTO>();
		List<String> baseCurrency = new ArrayList<String>();
		List<String> basePair = new ArrayList<String>();
		baseCurrency.add("BTC");
		baseCurrency.add("ETH");
		String base[];
		String mkt_name;
		for (ExchangeDTO e : filteredExchangelist) {
			marketPairList = getMarketListByExchangeCode(e.getExch_code());

			for (MarketPairDTO marketPair : marketPairList) {
				mkt_name = marketPair.getMkt_name();
				base = mkt_name.split("/");
				for (String bc : baseCurrency) {
					if (bc.equals(base[1])) {
						filteredMarketPairList.add(marketPair);
						basePair.add(mkt_name);
					}
				}
			}
		}
		// Removing duplicate base pair
		basePair = basePair.stream().distinct().collect(Collectors.toList());

		PriceTickerDTO priceTicker;
		PriceTickerDTO minPriceTicker = null;
		
		List<PriceTickerDTO> minPriceTickerList = new ArrayList<PriceTickerDTO>();
		List<PriceTickerDTO> priceTickerList = new ArrayList<PriceTickerDTO>();
		
		for (String bp : basePair) {
			
			for (ExchangeDTO filteredExchange : filteredExchangelist) {
				List<PriceTickerDTO> priceList = getPriceTicker(filteredExchange.getExch_code(), bp);
				if (!priceList.isEmpty()) {
					if (bp.equals(priceList.get(0).getMarket())) {
						priceTickerList.add(priceList.get(0));
					}
				}
			}
			/*Comparator<PriceTickerDTO> comparator = (p1, p2) -> p1.getAsk().compareTo(p2.getAsk());
			priceTickerList.sort(comparator);
			if (!priceTickerList.isEmpty()) {
				minPriceTicker = priceTickerList.get(0);
				minPriceTickerList.add(minPriceTicker);
			}*/
		}
		return priceTickerList;
	}
}
