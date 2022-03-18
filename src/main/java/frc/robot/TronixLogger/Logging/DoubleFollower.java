package frc.robot.TronixLogger.Logging;

import java.util.function.DoubleSupplier;

public class DoubleFollower {

    private final String name;
    private final DoubleSupplier doubleSupplier;
    private double lastValue;
    private final int updateInterval;
    private final double tolerance;

    public DoubleFollower(String name, DoubleSupplier doubleSupplier, int updateInterval, double tolerance) {
        this.name = name;
        this.updateInterval = updateInterval;
        this.doubleSupplier = doubleSupplier;
        this.tolerance = tolerance;
    }

    public double getValue() {
        return doubleSupplier.getAsDouble();
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue() {
        lastValue = doubleSupplier.getAsDouble();
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return updateInterval;
    }

    public double getTolerance() {
        return tolerance;
    }


}
