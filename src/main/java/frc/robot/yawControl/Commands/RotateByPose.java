package frc.robot.yawControl.Commands;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.yawControl.Commands.RotateToAngleRTF;
import frc.robot.yawControl.YawControl;

public class RotateByPose extends RotateToAngleRTF {

    public RotateByPose(YawControl yawControl) {
        super(yawControl, yawControl::getAngleToTargetByPose);
    }
}
