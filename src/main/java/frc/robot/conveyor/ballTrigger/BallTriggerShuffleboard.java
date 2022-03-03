package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTriggerShuffleboard {

    private NetworkTableEntry ballInPlaceValueEntry;
    private NetworkTableEntry identifiedBallValueEntry;
    private final BallTrigger ballTrigger;

    public BallTriggerShuffleboard(BallTrigger ballTrigger) {
        this.ballTrigger = ballTrigger;
    }

    public void init() {
        ballInPlaceValueEntry = Shuffleboard.getTab("BallTrigger").add("InPlaceValue",
                INPLACE_DISTANCE_MM).getEntry();
        identifiedBallValueEntry = Shuffleboard.getTab("BallTrigger").add("IdentifiedValue",
                IDENTIFIED_DISTANCE_MM).getEntry();

        NetworkTableEntry ballTriggerSpeed = Shuffleboard.getTab("BallTrigger").add("BallTriggerSpeed",
                BALLTRIGGER_SPEED).getEntry();
        Shuffleboard.getTab("BallTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_SPEED)));

//        Shuffleboard.getTab("BallTrigger").addNumber("DistanceDigital", ballTrigger::getDigitalDistance);
//        Shuffleboard.getTab("BallTrigger").addNumber("DistanceAnalog", ballTrigger::getAnalogDistance);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallIdentify", ballTrigger::isBallIdentified);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlace", ballTrigger::isBallInPlace);
    }

    public double getBallInPlaceValueEntry() {
        return ballInPlaceValueEntry != null ?
                ballInPlaceValueEntry.getDouble(INPLACE_DISTANCE_MM) : INPLACE_DISTANCE_MM;
    }

    public double getIdentifiedBallValueEntry() {
        return identifiedBallValueEntry != null ?
                identifiedBallValueEntry.getDouble(IDENTIFIED_DISTANCE_MM) : IDENTIFIED_DISTANCE_MM;
    }
}
