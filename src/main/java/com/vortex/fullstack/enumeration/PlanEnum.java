package com.vortex.fullstack.enumeration;

public enum PlanEnum {

    TALK_MORE_30(30),
    TALK_MORE_60(60),
    TALK_MORE_120(120);

    private Integer value;

    private PlanEnum(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
