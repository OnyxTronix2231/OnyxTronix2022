package frc.robot.providers;

import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

public class AngleProviderByOdemetry implements AngleProvider {

    private final YawControl yawControl;

    public AngleProviderByOdemetry(YawControl yawControl) {
        this.yawControl = yawControl;
    }

    @Override
    public double getAsDouble() {
        return (-yawControl.getAngleRTRToTarget() - yawControl.getCurrentAngleRTR());
    }
}
