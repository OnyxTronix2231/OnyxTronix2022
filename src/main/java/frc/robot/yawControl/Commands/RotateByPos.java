package frc.robot.yawControl.Commands;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.yawControl.Commands.RotateToAngleRTF;
import frc.robot.yawControl.YawControl;

public class RotateByPos extends RotateToAngleRTF {

    public RotateByPos(YawControl yawControl) {
        super(yawControl, yawControl::getAngleToTargetByPose);
        addRequirements(yawControl);
    }
}
