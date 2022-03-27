package frc.robot.providers;

import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class AngleProviderByVisionAndOdemetry implements AngleProvider {

    private final AngleProviderByVision angleProviderByVision;
    private final AngleProviderByOdemetry angleProviderByOdemetry;

    public AngleProviderByVisionAndOdemetry(AngleProviderByVision angleProviderByVision,
                                            AngleProviderByOdemetry angleProviderByOdemetry) {
        this.angleProviderByVision = angleProviderByVision;
        this.angleProviderByOdemetry = angleProviderByOdemetry;
    }

    @Override
    public double getAsDouble() {
        return Vision.getInstance().hasTarget() ? angleProviderByVision.getAsDouble()
                : angleProviderByOdemetry.getAsDouble();
    }
}
