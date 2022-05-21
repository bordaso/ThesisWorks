package ec33nw.map.analytics.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import iexcloud.gen.BalanceSheetsGrpc;
import iexcloud.gen.CashflowStatementsGrpc;
import iexcloud.gen.IexcloudServiceGrpc;
import iexcloud.gen.IexcloudServiceGrpc.IexcloudServiceBlockingStub;
import iexcloud.gen.IexcloudServiceGrpc.IexcloudServiceStub;
import iexcloud.gen.IncomeStatementsGrpc;
import iexcloud.gen.NoParam;
import iexcloud.gen.Symbol;
import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

public class GrpcClientStub {

	private final IexcloudServiceBlockingStub blockingStub;
	private final IexcloudServiceStub asyncStub;

	public GrpcClientStub(Channel channel) {
		blockingStub = IexcloudServiceGrpc.newBlockingStub(channel);
		asyncStub = IexcloudServiceGrpc.newStub(channel);
	}

	public List<String> getSymbols() {
		NoParam npRequest = NoParam.newBuilder().build();
		List<String> symbols = new ArrayList<>();
		try {
			Iterator<Symbol> it = blockingStub.getSymbols(npRequest);
			for (int i = 1; it.hasNext(); i++) {
				Symbol symbol = it.next();
				System.out.println("Result #" + i + " : " + symbol);
				symbols.add(symbol.getName());
			}
			return symbols;
		} catch (StatusRuntimeException e) {
			System.out.println("getSymbols RPC failed: " + e.getStatus());

		}
		return symbols;
	}

	public BalanceSheetsGrpc getBalancesheets(Symbol request) {
		try {
			BalanceSheetsGrpc balancesheets = blockingStub.getBalancesheets(request);
			return balancesheets;
		} catch (StatusRuntimeException e) {
			System.out.println("getBalancesheets RPC failed: " + e.getStatus());
		}
		return null;
	}

	public IncomeStatementsGrpc getIncomeStatements(Symbol request) {
		try {
			IncomeStatementsGrpc incomeStatements = blockingStub.getIncomeStatements(request);
			return incomeStatements;
		} catch (StatusRuntimeException e) {
			System.out.println("getIncomeStatements RPC failed: " + e.getStatus());
		}
		return null;
	}

	public CashflowStatementsGrpc getCashflowStatements(Symbol request) {
		try {
			CashflowStatementsGrpc cashflowStatements = blockingStub.getCashflowStatements(request);
			return cashflowStatements;
		} catch (StatusRuntimeException e) {
			System.out.println("getCashflowStatements RPC failed: " + e.getStatus());
		}
		return null;
	}

	public List<String> getPeers(Symbol request) {
		List<String> symbols = new ArrayList<>();
		try {
			Iterator<Symbol> it = blockingStub.getPeers(request);
			for (int i = 1; it.hasNext(); i++) {
				Symbol symbol = it.next();
				System.out.println("Result #" + i + " : " + symbol);
				symbols.add(symbol.getName());
			}
			return symbols;
		} catch (StatusRuntimeException e) {
			System.out.println("getPeers RPC failed: " + e.getStatus());

		}
		return null;
	}

}
