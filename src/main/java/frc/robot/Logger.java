package frc.robot;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Logger {

    private final String tag;
    ArrayList<BooleanFollower> booleanFollowers;

    public Logger(String tag) {
        booleanFollowers = new ArrayList<>();
        this.tag = tag;
    }

    public int convertMiliSecondsToUnits(int miliSeconds) {
        return miliSeconds /= 20;
    }

    public void update() {
        for (var booleanFollower :
                booleanFollowers) {
            if (booleanFollower.getValue() != booleanFollower.getLastValue()) {
                System.out.println(tag + "was changed toz");
                booleanFollower.setLastValue();

            }
        }
    }

    public void addBooleanListener(String methodName, BooleanSupplier condition, int miliSec) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, condition.getAsBoolean());
    }

    public class BooleanFollower {

        private final String name;
        private final BooleanSupplier booleanSupplier;
        private boolean lastCondition;
        private int counter;

        public BooleanFollower(String name, BooleanSupplier booleanSupplier, boolean lastCondition, int counter) {
            this.name = name;
            this.counter = counter;
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

        public int getCounter(){
            return counter;
        }
    }
}
