package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTriggerShuffleboard {

    private NetworkTableEntry identifiedBallValueEntry;
    private NetworkTableEntry isRedEntry;
    private NetworkTableEntry isBlueEntry;

    private final BallTrigger ballTrigger;
    private SendableChooser<String> isOurBall;

    public BallTriggerShuffleboard(BallTrigger ballTrigger) {
        this.ballTrigger = ballTrigger;
        isOurBall = new SendableChooser<>();
    }

    public void init() {

        identifiedBallValueEntry = Shuffleboard.getTab("BallTrigger").add("IdentifiedValue",
                IDENTIFIED_VOLTAGE).getEntry();

        isRedEntry = Shuffleboard.getTab("BallTrigger").add("isRedValue",
                THRESHOLD_REDNESS).getEntry();
        isBlueEntry = Shuffleboard.getTab("BallTrigger").add("isBlueValue",
                THRESHOLD_BLUENESS).getEntry();

        NetworkTableEntry ballTriggerSpeed = Shuffleboard.getTab("BallTrigger").add("BallTriggerSpeed",
                BALLTRIGGER_SPEED).getEntry();
        Shuffleboard.getTab("BallTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_SPEED)));


//        Shuffleboard.getTab("BallTrigger").addNumber("getRed", ballTrigger::getRed);
//        Shuffleboard.getTab("BallTrigger").addNumber("getBlue", ballTrigger::getBlue);
//
//        Shuffleboard.getTab("BallTrigger").addBoolean("isRed", ballTrigger::isRed);
//        Shuffleboard.getTab("BallTrigger").addBoolean("isBlue", ballTrigger::isBlue);


        Shuffleboard.getTab("BallTrigger").addNumber("AnalogVoltage", ballTrigger::getAnalogSensorVoltage);

//        Shuffleboard.getTab("BallTrigger").addNumber("DistanceColor", ballTrigger::getColorDistance);

        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlace", ballTrigger::isBallIdentified);

        Shuffleboard.getTab("BallTrigger").add(isOurBall);
    }

    public double getIdentifiedBallValueEntry() {
        return identifiedBallValueEntry != null ?
                identifiedBallValueEntry.getDouble(IDENTIFIED_VOLTAGE) : IDENTIFIED_VOLTAGE;
    }

    public double getIsRedEntry() {
        return isRedEntry != null ?
                isRedEntry.getDouble(THRESHOLD_REDNESS) : THRESHOLD_REDNESS;
    }

    public double getIsBlueEntry() {
        return isBlueEntry != null ?
                isBlueEntry.getDouble(THRESHOLD_BLUENESS) : THRESHOLD_BLUENESS;
    }
}
