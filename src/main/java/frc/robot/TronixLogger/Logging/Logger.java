package frc.robot.TronixLogger.Logging;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public String Time() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = localTime.format(format);
        return formattedTime;
    }

    public int convertMileSecondsToUnits(int mileSeconds) {
        return mileSeconds /= 20;
    }

    public void update() {

        for (var booleanFollower :
                booleanFollowers) {
            if (booleanFollower.getValue() != booleanFollower.getLastValue()) {
                System.out.println(Time() + " - " + tag + "was changed toz");
                booleanFollower.setLastValue();
            }
        }
    }

    public void updateDoubleFollower() {

        for (var doubleFollower :
                doubleFollowers) {
            if (doubleFollower.getValue() > doubleFollower.getLastValue() + doubleFollower.getTolerance() ||
                    doubleFollower.getValue() < doubleFollower.getLastValue() - doubleFollower.getTolerance()) {

                System.out.println(Time() + " - " + tag + " setPoint was changed");
                doubleFollower.setLastValue();
            }
        }
    }

    public void addBooleanListener(String methodName, BooleanSupplier condition, int miliSec) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, condition.getAsBoolean(),
                convertMileSecondsToUnits(miliSec));
        booleanFollowers.add(booleanFollower);
    }

    public void addDoubleListener(String methodName, DoubleSupplier setPoint, int delay, int tolerace) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, setPoint, delay, tolerace);
        doubleFollowers.add(doubleFollower);
    }
}
