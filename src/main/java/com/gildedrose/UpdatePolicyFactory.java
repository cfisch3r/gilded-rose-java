package com.gildedrose;

class UpdatePolicyFactory {
    static UpdatePolicy create() {
        UpdatePolicy updatePolicy = new AgedBrieUpdatePolicy();
        updatePolicy.and(new BackstagePassUpdatePolicy())
                .and(new SulfurasUpdatePolicy()).and(new DefaultUpdatePolicy());
        return updatePolicy;
    }
}