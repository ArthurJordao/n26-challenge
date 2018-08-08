package io.arthurjordao.n26challenge.resource;

import io.arthurjordao.n26challenge.model.Statistics;
import io.arthurjordao.n26challenge.model.Transaction;
import io.arthurjordao.n26challenge.resource.serializer.StaticsResponse;
import io.arthurjordao.n26challenge.resource.serializer.TransactionRequest;
import io.arthurjordao.n26challenge.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionResource {

    private TransactionService service;

    @Autowired
    public TransactionResource(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/transactions")
    public ResponseEntity<?> create(@RequestBody TransactionRequest transactionRequest) {
        Transaction transaction = transactionRequest.toModel();
        boolean success = service.saveTransaction(transaction);
        if (success) {
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    @RequestMapping("/statistics")
    public ResponseEntity<StaticsResponse> statistics() {
        Statistics statistics = service.getStatics();
        return new ResponseEntity<>(StaticsResponse.from(statistics), HttpStatus.OK);
    }
}
