package frc.robot.providers;

import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class AngleProviderByVisionAndOdemetry implements AngleProvider {

    private final Vision vision;
    private final AngleProviderByVision angleProviderByVision;
    private final AngleProviderByOdemetry angleProviderByOdemetry;

    public AngleProviderByVisionAndOdemetry(Vision vision, AngleProviderByVision angleProviderByVision,
                                            AngleProviderByOdemetry angleProviderByOdemetry) {
        this.vision = vision;
        this.angleProviderByVision = angleProviderByVision;
        this.angleProviderByOdemetry = angleProviderByOdemetry;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? angleProviderByVision.getAsDouble()
                : angleProviderByOdemetry.getAsDouble();
    }
}
