package frc.robot.providers;

import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class AngleProvider implements DoubleSupplier {

    private final Vision vision;
    private final YawControl yawControl;

    public AngleProvider(Vision vision, YawControl yawControl) {
        this.vision = vision;
        this.yawControl = yawControl;
    }

    @Override
    public double getAsDouble() {
        return vision.hasTarget() ? vision.getHorizontalAngleTurretToTargetRTR(yawControl)
                : yawControl.getAngleRTRToTarget();
    }
}
