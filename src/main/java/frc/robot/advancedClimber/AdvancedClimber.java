package frc.robot.advancedClimber;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.stabilizers.Stabilizers;
import frc.robot.stabilizers.StabilizersComponents;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ROLL_ANGLE;

public class AdvancedClimber extends Stabilizers {

    private final DriveTrain driveTrain;

    public AdvancedClimber(StabilizersComponents components, DriveTrain driveTrain) {
        super(components);
        this.driveTrain = driveTrain;
        new AdvancedClimberShuffleBoard(this);
    }

    public boolean isOnDesiredRollAngle() {
        return driveTrain.getRoll() >= DESIRED_ROLL_ANGLE;
    }

    public double getCurrentPitch() {
        return driveTrain.getPitch();
    }

    public double getCurrentRoll() {
        return driveTrain.getRoll();
    }

    public double getCurrentYaw() {
        return driveTrain.getHeading();
    }
}
