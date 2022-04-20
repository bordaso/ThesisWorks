package ec33nw.map.datahandler.controllers.iexcloud;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import ec33nw.map.datahandler.util.GrpcRestDtoParser;
import iexcloud.gen.Balancesheet;
import iexcloud.gen.IexcloudServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import pl.zankowski.iextrading4j.api.stocks.v1.BalanceSheets;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.v1.BalanceSheetRequestBuilder;

public class IexCloudGrpcServer {
	
	  private final int port;
	  private final Server server;
	  private static final String SANDBOX_TOKEN = "Tpk_2f56411b27df448f80fe029e05d3e67e";
	  private static final IEXCloudClient cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_STABLE_SANDBOX,
	            new IEXCloudTokenBuilder()
	                    .withPublishableToken(SANDBOX_TOKEN)
	                    .build());
	
    ManagedChannel channel = ManagedChannelBuilder
            .forAddress("localhost", 50051)
            .usePlaintext()
            .build();

    public IexCloudGrpcServer(int port) throws IOException {
        this(ServerBuilder.forPort(port), port);
      }

    public IexCloudGrpcServer(ServerBuilder<?> serverBuilder, int port) {
      this.port = port;
      server = serverBuilder.addService(new IexCloudGrpcService())
          .build();
    }
    
    
    private static class IexCloudGrpcService extends IexcloudServiceGrpc.IexcloudServiceImplBase {
    	
    	@Override
        public void getSymbols(iexcloud.gen.NoParam request,
                io.grpc.stub.StreamObserver<iexcloud.gen.Symbol> responseObserver) {

            }
    	
    	@Override
        public void getBalancesheets(iexcloud.gen.Symbol request,
                io.grpc.stub.StreamObserver<iexcloud.gen.Balancesheets> responseObserver) {
    		final BalanceSheets balanceSheets = cloudClient.executeRequest(new BalanceSheetRequestBuilder()
    				.withSymbol(request.getName())
    		        .build());		
    		
    		
    		
    		try {
    			Balancesheet bseet = GrpcRestDtoParser.INSTANCE.parseRestToGrpc(Balancesheet.class, BalanceSheets.class, Balancesheet.newBuilder(), balanceSheets.getBalanceSheet().get(0)).build();
    			System.out.println("______"+bseet.toString());
    		} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }

		@Override
        public void getIncomeStatements(iexcloud.gen.Symbol request,
            io.grpc.stub.StreamObserver<iexcloud.gen.IncomeStatements> responseObserver) {
          
        }

		@Override
        public void getCashflowStatements(iexcloud.gen.Symbol request,
            io.grpc.stub.StreamObserver<iexcloud.gen.CashflowStatements> responseObserver) {
          
        }

		@Override
        public void getPeers(iexcloud.gen.Symbol request,
            io.grpc.stub.StreamObserver<iexcloud.gen.Symbol> responseObserver) {
          
        }
    }
    
}
