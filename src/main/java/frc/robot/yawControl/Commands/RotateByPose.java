package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

public class RotateByPose extends RotateToAngleRTF {

    public RotateByPose(YawControl yawControl) {
        super(yawControl, yawControl::getAngleToTargetByPose);
    }
}
