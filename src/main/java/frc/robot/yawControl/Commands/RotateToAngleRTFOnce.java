package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;
import java.util.function.DoubleSupplier;

public class RotateToAngleRTFOnce extends RotateToAngleRTF {

    public RotateToAngleRTFOnce(YawControl yawControl, DoubleSupplier angleSupplier) {

        super(yawControl, angleSupplier);
        addRequirements(yawControl);
    }

    @Override
    public boolean isFinished() {
        return turret.isOnTarget();
    }
}
