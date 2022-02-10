package frc.robot.yawControl.Commands;

import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.yawControl.YawControl;
import java.util.function.DoubleSupplier;

public class RotateToAngleRTF extends RotateToAngleRTR {

    public RotateToAngleRTF(YawControl yawControl, DoubleSupplier angleSupplier) {
        super(yawControl,()-> yawControl.getRTFToRTRAngle(angleSupplier.getAsDouble()));
    }
}
