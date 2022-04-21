package ec33nw.map.GrpcTestClient;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec33nw.map.GrpcTestClient.impl.GrpcTestClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@SpringBootApplication
public class GrpcTestClientApplication {

	public static GrpcTestClient client;

	public static void main(String[] args) {
		SpringApplication.run(GrpcTestClientApplication.class, args);
		String target = "localhost:8980";
		if (args.length > 0) {
			if ("--help".equals(args[0])) {
				System.err.println("Usage: [target]");
				System.err.println("");
				System.err.println("  target  The server to connect to. Defaults to " + target);
				System.exit(1);
			}
			target = args[0];
		}

		ManagedChannel channel = ManagedChannelBuilder.forTarget(target).usePlaintext().build();
		client = new GrpcTestClient(channel);

	/*	try {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println(e.getClass().toString() + "______" + e.getMessage());
		}*/
	}

}
