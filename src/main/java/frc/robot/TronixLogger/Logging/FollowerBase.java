package frc.robot.TronixLogger.Logging;

import java.util.function.Supplier;

public abstract class FollowerBase<T> implements Follower<T> {

    private T value;
    private T lastValue;
    private final String name;
    private final int counter;

    public FollowerBase(String name, Supplier<T> supplier, int counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public T getValue() {
        return value;
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
    public void updateLastValue() {
        lastValue = value;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
