package frc.robot.TronixLogger.Logging;

import edu.wpi.first.wpilibj.DataLogManager;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.function.Supplier;

public class TronixLogger {

    public static TronixLogger tronixLoggerInstance;
    ArrayList<BooleanFollower> booleanFollowers;
    ArrayList<DoubleFollower> doubleFollowers;
    ArrayList<FollowerBase> followerBases;

    private TronixLogger() {
        booleanFollowers = new ArrayList<>();
        doubleFollowers = new ArrayList<>();
        followerBases = new ArrayList<>();
    }

    public static TronixLogger getInstance() {
        if (tronixLoggerInstance == null) {
            tronixLoggerInstance = new TronixLogger();
        }
        return tronixLoggerInstance;
    }

    public String timeStamp() {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        return localTime.format(format);
    }

    public void update() {
        for (var followerBases : followerBases) {
            followerBases.updateByDelay();
        }
    }

    public void addBooleanListener(String methodName, Supplier<Boolean> condition, int delayInMS) {
        BooleanFollower booleanFollower = new BooleanFollower(methodName, condition, delayInMS,
                log-> DataLogManager.log(timeStamp() + " - " + "was changed to" + log.getValue()));
        booleanFollowers.add(booleanFollower);
        followerBases.add(booleanFollower);
    }

    public void addDoubleListener(String methodName, Supplier<Double> doubleSupplier, int delayInMS, int tolerance) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, doubleSupplier ,delayInMS,
                log -> DataLogManager.log(timeStamp() + " - "  + " " + log.getName() + " was changed to " + log.getValue()),
                        tolerance);
        doubleFollowers.add(doubleFollower);
        followerBases.add(doubleFollower);
    }
}
