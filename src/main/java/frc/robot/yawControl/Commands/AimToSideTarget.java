package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

public class AimToSideTarget extends RotateToAngleRTF{

    public AimToSideTarget(YawControl yawControl){
        super(yawControl, yawControl::getAngleToTargetSideRTF);
    }
}
