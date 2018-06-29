package io.arthurjordao.n26challenge.service;

import io.arthurjordao.n26challenge.model.Statics;
import io.arthurjordao.n26challenge.model.Transaction;
import io.arthurjordao.n26challenge.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository repository;

    public TransactionService() {  }

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public boolean saveTransaction(Transaction transaction) {
        if (transaction.isValidTransaction()) {
            repository.save(transaction);
            return true;
        } else {
            return false;
        }
    }

    public Statics getStatics() {
        return Statics.from(repository.getValidTransactions());
    }
}