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

    public String TimeStamp() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(format);
    }

    public int convertMileSecondsToUnits(int milliSeconds) {
        return milliSeconds /= 20
                ;
    }

    public void update() {

        for (var booleanFollower :
                booleanFollowers) {
            if (booleanFollower.getValue() != booleanFollower.getLastValue()) {
                System.out.println(TimeStamp() + " - " + tag + "was changed toz");
                booleanFollower.setLastValue();
            }
        }
    }

    public void updateDoubleFollower() {

        for (var doubleFollower :
                doubleFollowers) {
            if (doubleFollower.getValue() > doubleFollower.getLastValue() + doubleFollower.getTolerance() ||
                    doubleFollower.getValue() < doubleFollower.getLastValue() - doubleFollower.getTolerance()) {
 
                System.out.println(TimeStamp() + " - " + tag +" "+doubleFollower.getName() +" setPoint was changed to " + doubleFollower.getValue());
                doubleFollower.setLastValue();
            }
        }
    }

    public void addBooleanListener(String methodName, BooleanSupplier condition, int delayInMS) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, condition.getAsBoolean(),
                convertMileSecondsToUnits(delayInMS));
        booleanFollowers.add(booleanFollower);
    }

    public void addDoubleListener(String methodName, DoubleSupplier setPoint, int delayInMS, int tolerance) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, setPoint, delayInMS, tolerance);
        doubleFollowers.add(doubleFollower);
    }
}
