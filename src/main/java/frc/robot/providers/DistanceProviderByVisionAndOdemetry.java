package frc.robot.providers;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vision;

import java.util.function.DoubleSupplier;

public class DistanceProviderByVisionAndOdemetry implements DistanceProvider {

    private final Vision vision;
    private final DistanceProviderByVision distanceProviderByVision;
    private final DistanceProviderByOdemetry distanceProviderByOdemetry;

    public DistanceProviderByVisionAndOdemetry(Vision vision, DistanceProviderByVision distanceProviderByVision,
                                               DistanceProviderByOdemetry distanceProviderByOdemetry) {
        this.vision = vision;
        this.distanceProviderByVision = distanceProviderByVision;
        this.distanceProviderByOdemetry = distanceProviderByOdemetry;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? distanceProviderByVision.getAsDouble()
                : distanceProviderByOdemetry.getAsDouble();
    }
}
