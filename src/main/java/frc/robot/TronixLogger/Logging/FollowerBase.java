package frc.robot.TronixLogger.Logging;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class FollowerBase<T> implements Follower<T> {

    private Supplier<T> supplier;
    private T lastValue;
    private final String name;
    private final int delayInMS;
    private int count = 0;

    public FollowerBase(String name, Supplier<T> supplier, int delayInMS) {
        this.name = name;
        this.delayInMS = delayInMS;
        this.supplier = supplier;
        lastValue = supplier.get();
    }

    @Override
    public T getValue() {
        return supplier.get();
    }

    @Override
    public void updateLastValue() {
        lastValue = supplier.get();
    }

    @Override
    public T getLastValue() {
        return lastValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDelay() {
        return delayInMS;
    }

    @Override
    public int convertMileSecondsToUnits(int delayInMS) {
        return delayInMS / 20;
    }

    @Override
    public void updateByDelay() {
        if (convertMileSecondsToUnits(getDelay()) <= count) {
            update();
            count = 0;
        }
        count++;
    }
}
