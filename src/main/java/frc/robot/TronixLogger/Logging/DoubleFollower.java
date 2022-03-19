package frc.robot.TronixLogger.Logging;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class DoubleFollower extends FollowerBase<Double> {


    private final double tolerance;
    private final Consumer<DoubleFollower> doubleConsumer;

    public DoubleFollower(String name, Supplier<Double> supplier, int counter, Consumer<DoubleFollower> doubleConsumer, double tolerance) {
        super(name, supplier, counter);
        this.tolerance = tolerance;
        this.doubleConsumer = doubleConsumer;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void update() {
        if (Math.abs(getValue()) > Math.abs(getLastValue()) + getTolerance()) {
            doubleConsumer.accept(this);
            updateLastValue();
        }
    }
}
