package frc.robot.TronixLogger.Logging;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class BooleanFollower extends FollowerBase<Boolean> {

    private final Consumer<BooleanFollower> booleanConsumer;

    public BooleanFollower(String name, Supplier<Boolean> supplier, int counter, Consumer<BooleanFollower> booleanConsumer) {
        super(name, supplier, counter);
        this.booleanConsumer = booleanConsumer;
    }

    @Override
    public void update() {
        if (getValue() != getLastValue()) {
            booleanConsumer.accept(this);
            updateLastValue();
        }
    }
}
