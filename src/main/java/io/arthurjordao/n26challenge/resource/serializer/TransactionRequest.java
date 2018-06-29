package io.arthurjordao.n26challenge.resource.serializer;

import io.arthurjordao.n26challenge.model.Transaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class TransactionRequest {
    private long timestamp;
    private BigDecimal amount;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Transaction toModel() {
        LocalDateTime timestamp =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(this.timestamp),
                        TimeZone.getDefault().toZoneId());

        return new Transaction(amount, timestamp);
    }
}
