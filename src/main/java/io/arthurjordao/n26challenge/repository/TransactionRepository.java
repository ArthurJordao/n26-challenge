package io.arthurjordao.n26challenge.repository;

import io.arthurjordao.n26challenge.model.Transaction;
import io.arthurjordao.n26challenge.persistence.InMemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class TransactionRepository {
    private InMemoryDatabase<Transaction> database;

    @Autowired
    public TransactionRepository(InMemoryDatabase<Transaction> database) {
        this.database = database;
    }

    public void save(Transaction transaction) {
        database.save(transaction);
    }


    public List<Transaction> getValidTransactions() {
        return database.query(Transaction::isValidTransaction);
    }
}
