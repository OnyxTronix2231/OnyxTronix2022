package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.*;

public class BallTriggerShuffleboard {

    private final NetworkTableEntry ballInPlaceValueEntry;
    private final NetworkTableEntry identifiedBallValueEntry;

    public BallTriggerShuffleboard(BallTrigger ballTrigger) {


        ballInPlaceValueEntry = Shuffleboard.getTab("BallTrigger").add("InPlaceValue", INPLACE_DISTANCE_MM).getEntry();
        identifiedBallValueEntry = Shuffleboard.getTab("BallTrigger").add("IdentifiedValue", IDENTIFIED_DISTANCE_MM).getEntry();

        var ballTriggerSpeed = Shuffleboard.getTab("BallTrigger").add("BallTriggerSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("BallTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                () -> ballTriggerSpeed.getDouble(BALLTRIGGER_SPEED)));

        Shuffleboard.getTab("BallTrigger").addNumber("Distance", ballTrigger::getDistance);
        // Shuffleboard.getTab("BallTrigger").addNumber("DistanceColor",ballTrigger::getDistanceColor);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallIdentify", ballTrigger::isBallIdentified);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlace", ballTrigger::isBallInPlace);
    }

    public double getBallInPlaceValueEntry() {
        return ballInPlaceValueEntry.getDouble(INPLACE_DISTANCE_MM);
    }

    public double getIdentifiedBallValueEntry() {
        return identifiedBallValueEntry.getDouble(IDENTIFIED_DISTANCE_MM);
    }
}
