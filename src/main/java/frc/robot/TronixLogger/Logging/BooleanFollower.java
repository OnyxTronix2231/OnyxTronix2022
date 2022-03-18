package frc.robot.TronixLogger.Logging;

import java.util.function.BooleanSupplier;

public class BooleanFollower {
    private final String name;
    private final BooleanSupplier booleanSupplier;
    private boolean lastCondition;
    private final int updateInterval;

    public BooleanFollower(String name, BooleanSupplier booleanSupplier, boolean lastCondition, int updateInterval) {
        this.name = name;
        this.updateInterval = updateInterval;
        this.booleanSupplier = booleanSupplier;
        this.lastCondition = lastCondition;
    }

    public boolean getValue() {
        return booleanSupplier.getAsBoolean();
    }

    public boolean getLastValue() {
        return lastCondition;
    }

    public void setLastValue() {
        lastCondition = booleanSupplier.getAsBoolean();
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return updateInterval;
    }
}
