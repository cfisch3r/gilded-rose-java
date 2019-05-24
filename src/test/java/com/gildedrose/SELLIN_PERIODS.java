package com.gildedrose;

public enum SELLIN_PERIODS {
    BEFORE_SELL_BY_DATE(5), ON_SELL_BY_DATE(0), AFTER_SELL_BY_DATE(-1);

    private int value;

    SELLIN_PERIODS(int value) {

        this.value = value;
    }

    public int value() {
        return value;
    }
}
