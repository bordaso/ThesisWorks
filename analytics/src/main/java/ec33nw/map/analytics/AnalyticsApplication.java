package ec33nw.map.analytics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec33nw.map.analytics.impl.GrpcClientStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AnalyticsApplication {

	public static GrpcClientStub client;

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsApplication.class, args);
		//grpc server ports
		String target = "localhost:8980";
		String targetK8s = "192.168.49.2:30980";
		String targetInnnerK8s = "172.17.0.4:8980";

		if (args.length > 0) {
			if ("--help".equals(args[0])) {
				System.err.println("Usage: [targetInnnerK8s]");
				System.err.println("");
				System.err.println("  target  The server to connect to. Defaults to " + targetInnnerK8s);
				System.exit(1);
			}
			targetInnnerK8s = args[0];
		}

		ManagedChannel channel = ManagedChannelBuilder.forTarget(targetInnnerK8s).usePlaintext().build();
		client = new GrpcClientStub(channel);

	/*	try {
			channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println(e.getClass().toString() + "______" + e.getMessage());
		}*/
	}

}
