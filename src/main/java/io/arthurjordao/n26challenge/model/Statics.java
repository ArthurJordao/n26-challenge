package io.arthurjordao.n26challenge.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

final public class Statics {
    final private BigDecimal sum;
    final private BigDecimal average;
    final private BigDecimal maximum;
    final private BigDecimal minimum;
    final private int count;

    public Statics(BigDecimal sum, BigDecimal average, BigDecimal maximum,
                   BigDecimal minimum, int count) {
        this.sum = sum;
        this.average = average;
        this.maximum = maximum;
        this.minimum = minimum;
        this.count = count;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public BigDecimal getMaximum() {
        return maximum;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public int getCount() {
        return count;
    }

    public static Statics from(List<Transaction> validTransactions) {
        final Stream<BigDecimal> amounts =
                validTransactions.stream().map(Transaction::getAmount);
        final BigDecimal sum =
                amounts.reduce(BigDecimal.ZERO, BigDecimal::add);
        final BigDecimal maximum =
                amounts.reduce(BigDecimal.ZERO,
                        (current, acc) -> current.compareTo(acc) > 0 ? current : acc);
        final BigDecimal minimum =
                amounts.reduce(BigDecimal.ZERO,
                        (current, acc) -> current.compareTo(acc) < 0 ? current : acc);
        final int count = validTransactions.size();

        final BigDecimal average = sum
                .divide(BigDecimal.valueOf(count),BigDecimal.ROUND_HALF_UP);

        return new Statics(sum, average, maximum, minimum, count);
    }
}
