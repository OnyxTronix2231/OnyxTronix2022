package frc.robot;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class Logger {

    private final String tag;
    ArrayList<BooleanFollower> booleanFollowers;
    ArrayList<DoubleFollower> doubleFollowers;

    public Logger(String tag) {
        booleanFollowers = new ArrayList<>();
        doubleFollowers = new ArrayList<>();
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

    public void updateDoubleFollower() {

        for (var doubleFollower :
                doubleFollowers) {
            if (doubleFollower.getValue() > doubleFollower.getLastValue() + doubleFollower.getTolerance() ||
                    doubleFollower.getValue() < doubleFollower.getLastValue() - doubleFollower.getTolerance()) {

                System.out.println(tag + "setPoint was changed");
                doubleFollower.setLastValue();
            }
        }
    }

    public void addBooleanListener(String methodName, BooleanSupplier condition, int miliSec) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, condition.getAsBoolean(),
                convertMiliSecondsToUnits(miliSec));
    }

    public void addDoubleListener(String methodName, DoubleSupplier setPoint, int delay, int tolerace) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, setPoint, delay, tolerace);
    }

    public class BooleanFollower {

        private final String name;
        private final BooleanSupplier booleanSupplier;
        private boolean lastCondition;
        private int updateInterval;

        public BooleanFollower(
                String name, BooleanSupplier booleanSupplier, boolean lastCondition, int updateInterval) {
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

    public class DoubleFollower {

        private final String name;
        private final DoubleSupplier doubleSupplier;
        private double lastValue;
        private int updateInterval;
        private double tolerance;

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
}
