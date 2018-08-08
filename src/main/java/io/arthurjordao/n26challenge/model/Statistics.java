package io.arthurjordao.n26challenge.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

final public class Statistics {
    final private BigDecimal sum;
    final private BigDecimal average;
    final private BigDecimal maximum;
    final private BigDecimal minimum;
    final private int count;

    public Statistics(BigDecimal sum, BigDecimal average, BigDecimal maximum,
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

    public static Statistics from(List<Transaction> transactions) {
        final List<BigDecimal> amounts =
                transactions.stream().map(Transaction::getAmount).collect(Collectors.toList());
        final BigDecimal sum =
                amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        final BigDecimal maximum =
                amounts.stream().reduce((current, acc) ->
                        current.compareTo(acc) > 0 ? current : acc).orElse(BigDecimal.ZERO);
        final BigDecimal minimum =
                amounts.stream().reduce((current, acc) ->
                        current.compareTo(acc) < 0 ? current : acc).orElse(BigDecimal.ZERO);
        final int count = transactions.size();
        final BigDecimal average;
        if (count != 0) {
             average = sum
                    .divide(BigDecimal.valueOf(count), BigDecimal.ROUND_HALF_UP);
        } else {
            average = BigDecimal.ZERO;
        }

        return new Statistics(sum, average, maximum, minimum, count);
    }
}
