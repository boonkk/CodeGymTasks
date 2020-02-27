package com.codegym.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long amountPaid;
    private int impressionsRemaining;

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerImpression() {
        return amountPerImpression;
    }

    private int duration;

    private long amountPerImpression;

    public Advertisement(Object content, String name, long amountPaid, int impressionsRemaining, int duration) {
        this.content = content;
        this.name = name;
        this.amountPaid = amountPaid;
        this.impressionsRemaining = impressionsRemaining;
        this.duration = duration;
        amountPerImpression = amountPaid / impressionsRemaining;
    }

    public void revalidate() {
        if(impressionsRemaining<=0)
            throw new UnsupportedOperationException();
        impressionsRemaining--;
    }

    public int getImpressionsRemaining() {
        return impressionsRemaining;
    }
}
