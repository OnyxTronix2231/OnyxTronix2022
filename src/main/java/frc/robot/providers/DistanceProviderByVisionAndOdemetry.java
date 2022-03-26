package frc.robot.providers;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class DistanceProviderByVisionAndOdemetry implements DistanceProvider {

    private final DistanceProviderByVision distanceProviderByVision;
    private final DistanceProviderByOdemetry distanceProviderByOdemetry;

    public DistanceProviderByVisionAndOdemetry(DistanceProviderByVision distanceProviderByVision,
                                               DistanceProviderByOdemetry distanceProviderByOdemetry) {
        this.distanceProviderByVision = distanceProviderByVision;
        this.distanceProviderByOdemetry = distanceProviderByOdemetry;
    }

    @Override
    public double getAsDouble() {
        return Vision.getInstance().hasTarget() ? distanceProviderByVision.getAsDouble()
                : distanceProviderByOdemetry.getAsDouble();
    }
}
