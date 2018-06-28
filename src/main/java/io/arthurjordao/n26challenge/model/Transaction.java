package io.arthurjordao.n26challenge.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


final public class Transaction {
    private final BigDecimal amount;
    private final LocalDateTime timestamp;

    public Transaction(BigDecimal amount, LocalDateTime timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public boolean isValidTransaction() {
        final LocalDateTime sixtyMinutesAgo = LocalDateTime.now().minusMinutes(1);
        return timestamp.isAfter(sixtyMinutesAgo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(amount, that.amount) &&
                Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {

        return Objects.hash(amount, timestamp);
    }
}
