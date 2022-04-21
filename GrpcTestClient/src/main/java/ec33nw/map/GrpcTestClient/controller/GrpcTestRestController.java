package ec33nw.map.GrpcTestClient.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec33nw.map.GrpcTestClient.GrpcTestClientApplication;
import iexcloud.gen.Symbol;

@RestController
@RequestMapping(path = "dhclientapi/v1/grpctest")
public class GrpcTestRestController {

	@GetMapping(path = "symbols")
	public List<String> getSymbols() {		
		return GrpcTestClientApplication.client.getSymbols();
	}
	
	@GetMapping(path = "balancesheet")
	public String getBalancesheet() {	
		 return GrpcTestClientApplication.client.getBalancesheets(Symbol.newBuilder().setName("A").build()).getBalanceSheetGrpc(0).toString();
	}
	
	@GetMapping(path = "income")
	public String getIncomeStatement() {		
		return GrpcTestClientApplication.client.getIncomeStatements(Symbol.newBuilder().setName("A").build()).getIncomeStatementGrpc(0).toString();
	}
	
	@GetMapping(path = "cashflow")
	public String getCashflowStatement() {			
		return GrpcTestClientApplication.client.getCashflowStatements(Symbol.newBuilder().setName("A").build()).getCashflowStatementGrpc(0).toString();
	}
	
	@GetMapping(path = "peers")
	public List<String> getPeers() {		
		return GrpcTestClientApplication.client.getPeers(Symbol.newBuilder().setName("A").build());
	}
	
}
