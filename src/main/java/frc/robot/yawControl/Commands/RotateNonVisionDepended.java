package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class RotateNonVisionDepended extends RotateToAngleRTF{

    public RotateNonVisionDepended(YawControl yawControl, DoubleSupplier angleSupplier) {
        super(yawControl, ()-> yawControl.getAngleNoVisionDependent(vision) );
        addRequirements(yawControl, vision);
    }
}
