package frc.robot.TronixLogger.Logging;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;

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
        init();
    }

    public static TronixLogger getInstance() {
        if (tronixLoggerInstance == null) {
            tronixLoggerInstance = new TronixLogger();
        }
        return tronixLoggerInstance;
    }

    public void init() {
        OnyxDataLogManager.log("TronixLogger V 0.0.1 - ");
        OnyxDataLogManager.log("OS Version - " + System.getProperty("os.version"));
        OnyxDataLogManager.log("Event Name - " + DriverStation.getEventName());
        OnyxDataLogManager.log("Match Type - " + DriverStation.getMatchType().toString());
        OnyxDataLogManager.log("Match Number - " + "" + DriverStation.getMatchNumber());
        OnyxDataLogManager.log("Match Time - " + "s" + DriverStation.getMatchTime());
        OnyxDataLogManager.log("Alliance - " + DriverStation.getAlliance().name());
        OnyxDataLogManager.log("CAN Status"+RobotController.getCANStatus());
        OnyxDataLogManager.log("Battery Voltage - " + "V" + RobotController.getBatteryVoltage());
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
                log -> OnyxDataLogManager.log(timeStamp() + " - " + "was changed to" + log.getValue()));
        booleanFollowers.add(booleanFollower);
        followerBases.add(booleanFollower);
    }

    public void addDoubleListener(String methodName, Supplier<Double> doubleSupplier, int delayInMS,
                                  int tolerance) {
        DoubleFollower doubleFollower = new DoubleFollower(methodName, doubleSupplier, delayInMS,
                log -> OnyxDataLogManager.log(timeStamp() + " - " + " " + log.getName() + " was changed to " + log.getValue()),
                tolerance);
        doubleFollowers.add(doubleFollower);
        followerBases.add(doubleFollower);
    }
}
