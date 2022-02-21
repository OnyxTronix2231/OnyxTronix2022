package frc.robot.conveyor.ballTrigger;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.IDENTIFIED_DISTANCE_MM;
import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.IN_PLACE_DISTANCE_MM;

public class BallTriggerShuffleboard {

    private final NetworkTableEntry ballInPlaceValue;
    private final NetworkTableEntry identifiedBallValue;

    public BallTriggerShuffleboard(BallTrigger ballTrigger) {


        ballInPlaceValue = Shuffleboard.getTab("BallTrigger").add("InPlaceValue", 0.0).getEntry();

        identifiedBallValue = Shuffleboard.getTab("BallTrigger").add("IdentifiedValue", 0.0).getEntry();

        var ballTriggerSpeed = Shuffleboard.getTab("BallTrigger").add("BallTriggerSpeed",
                0.0).getEntry();
        Shuffleboard.getTab("BallTrigger").add(new MoveBallTriggerBySpeed(ballTrigger,
                () -> ballTriggerSpeed.getDouble(0)));

        Shuffleboard.getTab("BallTrigger").addNumber("Distance", ballTrigger::getDistance);
       // Shuffleboard.getTab("BallTrigger").addNumber("DistanceColor",ballTrigger::getDistanceColor);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallIdentify", ballTrigger::isBallIdentified);
        Shuffleboard.getTab("BallTrigger").addBoolean("IsBallInPlace", ballTrigger::isBallInPlace);
    }

    public double getBallInPlaceValue() {
        return ballInPlaceValue.getDouble(IN_PLACE_DISTANCE_MM);
    }

    public double getIdentifiedBallValue() {
        return identifiedBallValue.getDouble(IDENTIFIED_DISTANCE_MM);
    }
}
