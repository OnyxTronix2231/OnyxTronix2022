package frc.robot.yawControl.Commands;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.yawControl.YawControl;

public class RotateToPos extends RotateToAngleRTF {

    public RotateToPos(YawControl yawControl, Pose2d currentPos) {
        super(yawControl, () -> yawControl.getAngleToTargetRTF(currentPos));
        addRequirements(yawControl);
    }
}
