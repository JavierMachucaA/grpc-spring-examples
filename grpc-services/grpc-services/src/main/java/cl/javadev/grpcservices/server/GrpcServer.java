package cl.javadev.grpcservices.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9001)
                .addService(new BankService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
