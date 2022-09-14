package cl.javdev.manager.controller;


import cl.javdev.manager.domain.ExecutionGlobalStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/manager")
@Log4j2
public class IndexController {

    private final ExecutionGlobalStatus executionGlobalStatus;

    public IndexController() {
        this.executionGlobalStatus = new ExecutionGlobalStatus();
    }

    @GetMapping("")
    public Mono<String> hello () {
        return Mono.just("Hello");
    }

    @GetMapping("wait")
    public Mono<ResponseEntity<?>> waiter() throws InterruptedException {
        Long seconds = 15L;
        log.info("Wait "+seconds+" seconds");
        Thread.sleep(seconds*1000);
        log.info("Response ready");
        return Mono.just(new ResponseEntity<>("Response finish", HttpStatus.OK));
    }

    @GetMapping("instant")
    public Flux<List<String>> instant () {
        List<String> list = Arrays.asList("Instant ", "response ", "List");
        log.info("response to client inmidently ");
        return Flux.just(list);
    }

    @GetMapping("runRead")
    public Mono<String> runRead() {
        log.info("initRead");
        executionGlobalStatus.setRunRead(true);
        log.info("read status changed to start");
        return Mono.just("Read is initiated");
    }

    @GetMapping("stopRead")
    public Mono<String> stopRead() {
        log.info("stopRead");
        executionGlobalStatus.setRunRead(false);
        log.info("read status changed to stop");
        return Mono.just("Read is stop");
    }

    @GetMapping("getStatus")
    public Mono<ExecutionGlobalStatus> getExecutionGlobalStatus () {
        return Mono.just(executionGlobalStatus);
    }
}