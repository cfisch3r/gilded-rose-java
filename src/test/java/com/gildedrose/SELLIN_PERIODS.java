package com.gildedrose;

public enum SELLIN_PERIODS {
    BEFORE_SELL_BY_DATE(5,"before Sell By Date"),
    ON_SELL_BY_DATE(0, "on Sell By Date"),
    AFTER_SELL_BY_DATE(-1, "after Sell By Date");

    private int value;
    private String description;

    SELLIN_PERIODS(int value, String description) {

        this.value = value;
        this.description = description;
    }

    public int value() {
        return value;
    }


    @Override
    public String toString() {
        return String.format("%s (%d)",this.description,value);
    }
}
