package ec33nw.map.datahandler.controllers.iexcloud;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.zankowski.iextrading4j.api.refdata.v1.ExchangeSymbol;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.CashFlows;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatements;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.refdata.v1.SymbolsRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.PeersRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.CashFlowRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.IncomeStatementRequestBuilder;

@RestController
@RequestMapping(path = "dhapi/v1/resttest")
public class IexCloudRestController {
	
	private static final String SANDBOX_TOKEN = "Tpk_2f56411b27df448f80fe029e05d3e67e";
	
	private static final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_STABLE_SANDBOX,
            new IEXCloudTokenBuilder()
                    .withPublishableToken(SANDBOX_TOKEN)
                    .build());

	@GetMapping(path = "symbols")
	public String getSymbols() {		
		final List<ExchangeSymbol> symbols = cloudClient.executeRequest(new SymbolsRequestBuilder()
		        .build());		
		return symbols.get(0).toString();
	}
	
	@GetMapping(path = "balancesheet")
	public String getBalancesheet() {		
		final BalanceSheets balanceSheets = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
				.withSymbol("A")
		        .build());		
		return balanceSheets.getBalanceSheet().get(0).toString();
	}
	
	@GetMapping(path = "income")
	public String getIncomeStatement() {		
		final IncomeStatements incomeStatement = cloudClient.executeRequest(new IncomeStatementRequestBuilder()
				.withSymbol("A")
		        .build());		
		return incomeStatement.getIncome().get(0).toString();
	}
	
	@GetMapping(path = "cashflow")
	public String getCashflowStatement() {		
		final CashFlows cashFlows = cloudClient.executeRequest(new CashFlowRequestBuilder()
				.withSymbol("A")
		        .build());		
		return cashFlows.getCashFlow().get(0).toString();
	}
	
	@GetMapping(path = "peers")
	public List<String> getPeers() {		
		final List<String> peers = cloudClient.executeRequest(new PeersRequestBuilder()
				.withSymbol("A")
		        .build());		
		return peers;
	}
	
}
