package io.arthurjordao.n26challenge.resource.serializer;

import io.arthurjordao.n26challenge.model.Statics;

import java.math.BigDecimal;

public class StaticsResponse {
    private BigDecimal sum;
    private BigDecimal average;
    private BigDecimal maximum;
    private BigDecimal minimum;
    private int count;

    public StaticsResponse(BigDecimal sum, BigDecimal average, BigDecimal maximum, BigDecimal minimum, int count) {
        this.sum = sum;
        this.average = average;
        this.maximum = maximum;
        this.minimum = minimum;
        this.count = count;
    }

    public StaticsResponse() {
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    public BigDecimal getMaximum() {
        return maximum;
    }

    public void setMaximum(BigDecimal maximum) {
        this.maximum = maximum;
    }

    public BigDecimal getMinimum() {
        return minimum;
    }

    public void setMinimum(BigDecimal minimum) {
        this.minimum = minimum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static StaticsResponse from(Statics statics) {
        return new StaticsResponse(statics.getSum(), statics.getAverage(), statics.getMaximum(),
                statics.getMinimum(), statics.getCount());
    }
}
