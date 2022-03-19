package frc.robot.TronixLogger.Logging;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Supplier;

public class TronixLogger {

    private final String tag;
    BooleanFollower booleanFollower;
    DoubleFollower doubleFollower;
    ArrayList<BooleanFollower> booleanFollowers;
    ArrayList<DoubleFollower> doubleFollowers;
    ArrayList<FollowerBase> followerBases;

    public TronixLogger(String tag) {
        booleanFollowers = new ArrayList<>();
        doubleFollowers = new ArrayList<>();
        this.tag = tag;
    }

    public String timeStamp() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(format);
    }

    public void update() {
        for (var followerBases : followerBases) {
            booleanFollower.updateByDelay();
            doubleFollower.updateByDelay();
        }
    }

    public void addBooleanListener(String methodName, Supplier<Boolean> condition, int delayInMS) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, delayInMS,
                d-> System.out.println(timeStamp() + " - " + tag + "was changed to" + d.getValue()));
        booleanFollowers.add(booleanFollower);
        followerBases.add(booleanFollower);
    }

    public void addDoubleListener(String methodName, Supplier<Double> doubleSupplier, int delayInMS, int tolerance) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, doubleSupplier ,delayInMS,
                d -> System.out.println(
                        timeStamp() + " - " + tag + " " + d.getName() + " was changed to " + d.getValue()),
                        tolerance);
        doubleFollowers.add(doubleFollower);
        followerBases.add(doubleFollower);
    }
}
