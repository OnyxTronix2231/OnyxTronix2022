package frc.robot.providers;

import frc.robot.drivetrain.DriveTrain;

public class DistanceProviderByOdemetry implements DistanceProvider {

    private final DriveTrain driveTrain;

    public DistanceProviderByOdemetry(DriveTrain driveTrain) {
        this.driveTrain = driveTrain;
    }

    @Override
    public double getAsDouble() {
        return driveTrain.getDistanceFromTargetByPose();
    }
}
