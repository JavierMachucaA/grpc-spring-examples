package cl.javadev.grpcservices.server;

import cl.javadev.models.Balance;
import cl.javadev.models.BalanceCheckRequest;
import cl.javadev.models.BankServiceGrpc;
import io.grpc.stub.StreamObserver;

public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {
        Integer account = request.getAccount();
        Balance balance = Balance.newBuilder().setAmount(account*10).build();
        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }
}
