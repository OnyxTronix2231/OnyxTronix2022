package frc.robot.advancedClimber;

import frc.robot.climber.Climber;
import frc.robot.climber.ClimberComponents;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_PITCH_ANGLE;

public class AdvancedClimber extends Climber {

    private final DriveTrain driveTrain;

    public AdvancedClimber(ClimberComponents components, DriveTrain driveTrain) {
        super(components);
        this.driveTrain = driveTrain;
    }

    public boolean hasReachedFourthBar() {
        return isLeftEncoderOnTarget() && isRightEncoderOnTarget() && isOnDesiredPitchAngle();
    }

    public boolean isOnDesiredPitchAngle() {
        return driveTrain.getPitch() >= DESIRED_PITCH_ANGLE;
    }

    public double getCurrentPitch() {
        return driveTrain.getPitch();
    }
}
