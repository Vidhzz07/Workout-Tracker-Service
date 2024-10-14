package com.workoutTracker.workout.Entities;


public enum SetKind {
    NORMAL(0),
    DROP(1),
    WARMUP(2),
    FAILURE(3);

    private int value;


    SetKind(int i) {
        this.value=i;
    }

    public int getValue()
    {
        return value;
    }

    public String getSetKind(int value)
    {
        return switch (value) {
            case 0 -> "NORMAL";
            case 1 -> "DROP";
            case 2 -> "WARMUP";
            case 3 -> "FAILURE";
            default -> "";
        };
    }
}