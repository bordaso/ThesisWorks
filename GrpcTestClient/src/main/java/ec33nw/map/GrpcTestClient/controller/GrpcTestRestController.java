package ec33nw.map.GrpcTestClient.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec33nw.map.GrpcTestClient.GrpcTestClientApplication;
import ec33nw.map.GrpcTestClient.mapper.GrpcToJsonMapper;
import ec33nw.map.GrpcTestClient.mapper.entities.BalanceSheets;
import ec33nw.map.GrpcTestClient.mapper.entities.CashFlows;
import ec33nw.map.GrpcTestClient.mapper.entities.IncomeStatements;
import iexcloud.gen.Symbol;

@RestController
@RequestMapping(path = "dhclientapi/v1/")
public class GrpcTestRestController {

	@GetMapping(path = "symbols", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<String> getSymbols() {		
		return GrpcTestClientApplication.client.getSymbols();
	}
	
	@GetMapping(path = "balancesheet", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public BalanceSheets getBalancesheet(@QueryParam(value = "symbol") String symbol) {	
		return GrpcToJsonMapper.INSTANCE.map(GrpcTestClientApplication.client.getBalancesheets(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "income", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public IncomeStatements getIncomeStatement(@QueryParam(value = "symbol") String symbol) {		
		return GrpcToJsonMapper.INSTANCE.map(GrpcTestClientApplication.client.getIncomeStatements(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "cashflow", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public CashFlows getCashflowStatement(@QueryParam(value = "symbol") String symbol) {			
		return GrpcToJsonMapper.INSTANCE.map(GrpcTestClientApplication.client.getCashflowStatements(Symbol.newBuilder().setName(symbol).build()));
	}
	
	@GetMapping(path = "peers", produces=MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public List<String> getPeers(@QueryParam(value = "symbol") String symbol) {		
		return GrpcTestClientApplication.client.getPeers(Symbol.newBuilder().setName(symbol).build());
	}
	
}
