package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

import java.util.function.DoubleSupplier;

public class RotateNonVisionDepended extends RotateToAngleRTF {

    public RotateNonVisionDepended(YawControl yawControl, Vision vision) {
        super(yawControl, ()-> yawControl.getAngleNonVisionDependent(vision) );
        addRequirements(yawControl);
    }
}
