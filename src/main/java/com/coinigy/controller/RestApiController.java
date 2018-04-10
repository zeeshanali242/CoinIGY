package com.coinigy.controller;

import java.math.BigInteger;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import com.coinigy.model.OrderAPIResponse;
import com.coinigy.model.OrderTypesListDTO;
import com.coinigy.model.OrdersDTO;
import com.coinigy.model.PriceTickerDTO;
import com.coinigy.postparam.BalanceParam;
import com.coinigy.postparam.BuyParam;
import com.coinigy.postparam.OrderParam;
import com.coinigy.service.TradePairService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	TradePairService tradePairService;

	
	@RequestMapping(value = "/exchageData", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public List<ExchangeDTO> getExchangeList() {
		return tradePairService.getExchangeList();
	}

	@RequestMapping(value = "/ticker/{exchangeCode}/{base}/{counter}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON })
	public List<PriceTickerDTO> priceTicker(@PathVariable("exchangeCode") String exchangeCode,
			@PathVariable("base") String base, @PathVariable("counter") String counter) {
		String coinPair = base + "/" + counter;
		return tradePairService.getPriceTicker(exchangeCode, coinPair);
	}

	@RequestMapping(value = "/markets/{exchangeCode}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON })
	public List<MarketPairDTO> marketListByExchangeCode(@PathVariable("exchangeCode") String exchangeCode) {
		return tradePairService.getMarketListByExchangeCode(exchangeCode);
	}

	@RequestMapping(value = "/markets", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public List<MarketPairDTO> marketList() {
		return tradePairService.getMarketList();
	}

	@RequestMapping(value = "/data/{exchangeCode}/{base}/{counter}/{type}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON })
	public MarketDataDTO marketDataByType(@PathVariable("exchangeCode") String exchangeCode,
			@PathVariable("base") String base, @PathVariable("counter") String counter,
			@PathVariable("type") String type) {
		String coinPair = base + "/" + counter;
		return tradePairService.getMarketDataOfCuurencyPair(exchangeCode, coinPair, type);
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public List<AccountDTO> accounts() {
		return tradePairService.accounts();
	}

	@RequestMapping(value = "/balances", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON })
	public List<BalancesDTO> balances(@RequestBody BalanceParam balanceParam) {
		return tradePairService.balances(balanceParam);
	}

	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public OrdersDTO orders() {
		return tradePairService.orders();
	}

	@RequestMapping(value = "/orderTypes", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public OrderTypesListDTO orderTypes() {
		return tradePairService.ordersType();
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON })
	public AddOrderResponseDTO addOrders(@RequestBody OrderParam orderParam) {
		return tradePairService.addOrder(orderParam);
	}

	@RequestMapping(value = "/cancelOrder/{orderId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON })
	public CancelOrderResponseDTO cancelOrder(@PathVariable("orderId") BigInteger orderId) {
		return tradePairService.cancelOrder(orderId);
	}

	@RequestMapping(value = "/realtime/{base}/{counter}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON })
	public List<PriceTickerDTO> realtimeMarketData(@PathVariable("base") String base,
			@PathVariable("counter") String counter) {
		return tradePairService.getMarketDataOfRealtime(base + "/" + counter);
	}

	@RequestMapping(value = "/buy", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON })
	public String buy(@RequestBody BuyParam param) {
		try {
			AddOrderResponseDTO response = tradePairService.buy(param);
			logger.info("buy Response is " + response.getData() + " notification is " + response.getNotifications());
			if (response.getData().isEmpty() || response.getNotifications().isEmpty())
				return "{\"error_code\" : \"101\" , \"error\" : \"Something Wrong\"}";
			OrderAPIResponse api = new OrderAPIResponse();
			api.setExchangeCode(param.getExchangeCode());
			api.setOrderId(response.getData().get(0).getInternal_order_id());
			api.setTimestamp(response.getNotifications().get(0).getNotification_title_vars());
			api.setQuantity(param.getQuantity());
			api.setStatus(
					(response.getNotifications().get(0).getNotification_style().equalsIgnoreCase("success") ? "filled"
							: "pending"));
			api.setTradePair(param.getTradePair());
			String resp = "";
			try {
				resp = new ObjectMapper().writeValueAsString(api);
			} catch (JsonProcessingException e) {

			}
			return resp;
		} catch (AccountNotFoundException e) {
			return "{\"error_code\" : \"102\" , \"error\" : \"Account not found For this user\"}";
		} catch (MarketNotFoundException e) {
			return "{\"error_code\" : \"103\" , \"error\" : \"Market Not found for this pair\"}";
		} catch (ExchangeNotFoundException e1) {
			return "{\"error_code\" : \"104\" , \"error\" : \"Exchange not found\"}";
		} catch (AccountNotActiveException e1) {
			return "{\"error_code\" : \"105\" , \"error\" : \"Account not active\"}";
		}
	}
	 // This method will be invoked at 11:30 pm IST and get the all data of my linked accounts in CoinIgy 
	@RequestMapping(value = "/dailyPriceTicker", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON })
	public List<PriceTickerDTO> exchangeDataForCurrency() {
      	return tradePairService.getDailyPriceTicker();	
	}
	

}