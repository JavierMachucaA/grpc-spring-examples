package cl.javdev.manager.controller;

import cl.javdev.model.ExecutionRequest;
import cl.javdev.model.ExecutionResponse;
import cl.javdev.model.ExecutionServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import org.lognet.springboot.grpc.GRpcService;

@Log4j2
@GRpcService
public class GrpcController extends ExecutionServiceGrpc.ExecutionServiceImplBase {

    @Override
    public void sendExecutionStatus(ExecutionRequest executionRequest, StreamObserver<ExecutionResponse> responseStreamObserver) {
        responseStreamObserver.onNext(printExecutionRequest(executionRequest));
        responseStreamObserver.onCompleted();
    }

    private ExecutionResponse printExecutionRequest(ExecutionRequest executionRequest) {
        log.info("Execution request grpc:"+executionRequest.toString());
        return ExecutionResponse.newBuilder().setId(Integer.parseInt(executionRequest.getIdExecution())).build();
    }
}
