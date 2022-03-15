package frc.robot.advancedClimber;

import frc.robot.ClimberStabilizers.ClimberStabilizers;
import frc.robot.ClimberStabilizers.ClimberStabilizersComponents;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.advancedClimber.AdvancedClimberConstants.DESIRED_PITCH_ANGLE;

public class AdvancedClimber extends ClimberStabilizers {

    private final DriveTrain driveTrain;

    public AdvancedClimber(ClimberStabilizersComponents components, DriveTrain driveTrain) {
        super(components);
        this.driveTrain = driveTrain;
    }

    public boolean isOnDesiredPitchAngle() {
        return driveTrain.getPitch() >= DESIRED_PITCH_ANGLE;
    }

    public double getCurrentPitch() {
        return driveTrain.getPitch();
    }
}
