package ec33nw.map.datahandler.controllers.iexcloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec33nw.map.datahandler.controllers.iexcloud.service.IexCloudService;
import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;

@RestController
@RequestMapping(path = "dhapi/v1/resttest")
public class IexCloudRestController {
	
	@Autowired
	private IexCloudService icService;

	@GetMapping(path = "symbols")
	public String getSymbols() {		
		final List<ExchangeSymbol> symbols = icService.getSymbols();
		return symbols.get(0).toString();
	}
	
	@GetMapping(path = "balancesheet")
	public String getBalancesheet() {		
		final BalanceSheets balanceSheets = icService.getBalanceSheets("A");
		return balanceSheets.getBalanceSheet().get(0).toString();
	}
	
	@GetMapping(path = "income")
	public String getIncomeStatement() {		
		final IncomeStatements incomeStatement = icService.getIncomeStatements("A");
		return incomeStatement.getIncome().get(0).toString();
	}
	
	@GetMapping(path = "cashflow")
	public String getCashflowStatement() {		
		final CashFlows cashFlows = icService.getCashflowStatements("A");
		return cashFlows.getCashFlow().get(0).toString();
	}
	
	@GetMapping(path = "peers")
	public List<String> getPeers() {		
		final List<String> peers = icService.getPeers("A");	
		return peers;
	}
	
}
