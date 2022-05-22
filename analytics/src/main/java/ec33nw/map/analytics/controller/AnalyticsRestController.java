package ec33nw.map.analytics.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec33nw.map.analytics.AnalyticsApplication;
import ec33nw.map.analytics.mapper.GrpcToJsonMapper;
import ec33nw.map.analytics.mapper.entities.BalanceSheets;
import ec33nw.map.analytics.mapper.entities.CashFlows;
import ec33nw.map.analytics.mapper.entities.IncomeStatements;
import iexcloud.gen.Symbol;

@RestController
@RequestMapping(path = "dhclientapi/v1/")
public class AnalyticsRestController {

	@GetMapping(path = "symbols", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = {"http://ec33nw.map.analytics.com", "http://ec33nw.map.analytics.api.com"})
	public List<String> getSymbols() {		
		return AnalyticsApplication.client.getSymbols();
	}
	
	@GetMapping(path = "balancesheet", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = {"http://ec33nw.map.analytics.com", "http://ec33nw.map.analytics.api.com"})
	public BalanceSheets getBalancesheet(@QueryParam(value = "symbol") String symbol) {	
		return GrpcToJsonMapper.INSTANCE.map(AnalyticsApplication.client.getBalancesheets(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "income", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = {"http://ec33nw.map.analytics.com", "http://ec33nw.map.analytics.api.com"})
	public IncomeStatements getIncomeStatement(@QueryParam(value = "symbol") String symbol) {		
		return GrpcToJsonMapper.INSTANCE.map(AnalyticsApplication.client.getIncomeStatements(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "cashflow", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = {"http://ec33nw.map.analytics.com", "http://ec33nw.map.analytics.api.com"})
	public CashFlows getCashflowStatement(@QueryParam(value = "symbol") String symbol) {			
		return GrpcToJsonMapper.INSTANCE.map(AnalyticsApplication.client.getCashflowStatements(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "peers", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = {"http://ec33nw.map.analytics.com", "http://ec33nw.map.analytics.api.com"})
	public List<String> getPeers(@QueryParam(value = "symbol") String symbol) {		
		return AnalyticsApplication.client.getPeers(Symbol.newBuilder().setName(symbol).build());
	}
	
}
