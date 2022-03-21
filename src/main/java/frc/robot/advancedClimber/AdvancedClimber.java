package frc.robot.advancedClimber;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.stabilizers.Stabilizer;
import frc.robot.stabilizers.StabilizerComponents;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_ROLL_ANGLE;

public class AdvancedClimber extends Stabilizer {

    private final DriveTrain driveTrain;

    public AdvancedClimber(StabilizerComponents components, DriveTrain driveTrain) {
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
