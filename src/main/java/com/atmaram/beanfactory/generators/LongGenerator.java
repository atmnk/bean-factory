package com.atmaram.beanfactory.generators;

import java.util.Random;

public class LongGenerator implements Generator<Long> {
    private long min=0;
    private long max=10000;

    public LongGenerator(long min, long max) {
        this.min = min;
        this.max = max;
    }

    public LongGenerator(long max) {
        this.max = max;
    }

    public LongGenerator(){
    }

    @Override
    public Long generate() {
        long ret=this.min+(long)(Math.random()*(this.max-this.min));

        return ret;
    }
}
