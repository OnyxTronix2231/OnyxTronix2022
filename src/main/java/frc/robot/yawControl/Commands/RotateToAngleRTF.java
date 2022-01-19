package frc.robot.yawControl.Commands;

import frc.robot.turret.commands.RotateToAngle;
import frc.robot.yawControl.YawControl;
import java.util.function.DoubleSupplier;

public class RotateToAngleRTF extends RotateToAngle {

    public RotateToAngleRTF(YawControl yawControl, DoubleSupplier angleSupplier) {

        super(yawControl,()-> yawControl.getAngleRTRToFixAngleRTF(angleSupplier.getAsDouble()));
        addRequirements(yawControl);
    }
}
