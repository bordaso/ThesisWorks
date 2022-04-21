package ec33nw.map.datahandler.controllers.iexcloud;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ec33nw.map.datahandler.controllers.iexcloud.service.IexCloudService;
import ec33nw.map.datahandler.util.GrpcRestDtoParser;
import iexcloud.gen.BalanceSheetGrpc;
import iexcloud.gen.BalanceSheetsGrpc;
import iexcloud.gen.CashflowStatementGrpc;
import iexcloud.gen.CashflowStatementsGrpc;
import iexcloud.gen.IexcloudServiceGrpc;
import iexcloud.gen.IncomeStatementGrpc;
import iexcloud.gen.IncomeStatementsGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.api.stocks.v1.IncomeStatement;
import pl.zankowski.iextrading4j.api.stocks.v1.Report;

public class IexCloudGrpcServer {

	private final int port;
	private final Server server;
	@Autowired
	private IexCloudService icService;

	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

	public IexCloudGrpcServer(int port) throws IOException {
		this(ServerBuilder.forPort(port), port);
	}

	public IexCloudGrpcServer(ServerBuilder<?> serverBuilder, int port) {
		this.port = port;
		server = serverBuilder.addService(new IexCloudGrpcService()).build();
	}

	private class IexCloudGrpcService extends IexcloudServiceGrpc.IexcloudServiceImplBase {

		@Override
		public void getSymbols(iexcloud.gen.NoParam request,
				io.grpc.stub.StreamObserver<iexcloud.gen.Symbol> responseObserver) {

		}

		@Override
		public void getBalancesheets(iexcloud.gen.Symbol request,
				io.grpc.stub.StreamObserver<iexcloud.gen.BalanceSheetsGrpc> responseObserver) {		
			
			List<? extends BalanceSheetGrpc> statements = getStatements(icService.getBalanceSheets(request.getName()).getBalanceSheet(),
					BalanceSheetGrpc.class, BalanceSheets.class, BalanceSheetGrpc.newBuilder());			
			BalanceSheetsGrpc response = BalanceSheetsGrpc.newBuilder().addAllBalanceSheetGrpc(statements).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();				
			System.out.println("balance sheet response______" + response.toString());
		}

		@Override
		public void getIncomeStatements(iexcloud.gen.Symbol request,
				io.grpc.stub.StreamObserver<iexcloud.gen.IncomeStatementsGrpc> responseObserver) {
			
			List<? extends IncomeStatementGrpc> statements = getStatements(icService.getIncomeStatements(request.getName()).getIncome(),
					IncomeStatementGrpc.class, IncomeStatement.class, IncomeStatementGrpc.newBuilder());			
			IncomeStatementsGrpc response = IncomeStatementsGrpc.newBuilder().addAllIncomeStatementGrpc(statements).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();				
			System.out.println("income response______" + response.toString());
		}

		@Override
		public void getCashflowStatements(iexcloud.gen.Symbol request,
				io.grpc.stub.StreamObserver<iexcloud.gen.CashflowStatementsGrpc> responseObserver) {
			
			List<? extends CashflowStatementGrpc> statements = getStatements(icService.getBalanceSheets(request.getName()).getBalanceSheet(),
					CashflowStatementGrpc.class, BalanceSheets.class, CashflowStatementGrpc.newBuilder());			
			CashflowStatementsGrpc response = CashflowStatementsGrpc.newBuilder().addAllCashflowStatementGrpc(statements).build();
			responseObserver.onNext(response);
			responseObserver.onCompleted();				
			System.out.println("cash flow response______" + response.toString());
		}

		@Override
		public void getPeers(iexcloud.gen.Symbol request,
				io.grpc.stub.StreamObserver<iexcloud.gen.Symbol> responseObserver) {

		}
		
		private <T extends com.google.protobuf.GeneratedMessageV3, BLDR extends com.google.protobuf.GeneratedMessageV3.Builder<?>, R extends Report>  
		List<T> getStatements(List<R> sheets, Class<?> bsGrpcClass, Class<?> restClass, BLDR builderObj) {

			try {
				List<T> bseets = new ArrayList<>();				
				for(R sheet : sheets) {
					@SuppressWarnings("unchecked")
					T bseet = 
					(T) GrpcRestDtoParser.INSTANCE.parseRestToGrpc(bsGrpcClass, restClass,
							builderObj, sheet).build();					
					bseets.add(bseet);
				}				
				return bseets;
			} catch (IllegalAccessException e) {
				System.out.println(e.getClass().toString() + "______" + e.getMessage());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getClass().toString() + "______" + e.getMessage());
			} catch (InvocationTargetException e) {
				System.out.println(e.getClass().toString() + "______" + e.getMessage());
			} catch (NoSuchMethodException e) {
				System.out.println(e.getClass().toString() + "______" + e.getMessage());
			} catch (SecurityException e) {
				System.out.println(e.getClass().toString() + "______" + e.getMessage());
			}			
			return null;
		}
	}

}
