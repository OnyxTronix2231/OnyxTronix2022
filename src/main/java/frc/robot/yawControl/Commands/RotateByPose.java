import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.yawControl.Commands.RotateToAngleRTF;
import frc.robot.yawControl.YawControl;

public class RotateByPos extends RotateToAngleRTF {

    public RotateByPos(YawControl yawControl, Pose2d currentPos) {
        super(yawControl, () -> yawControl.getAngleToTargetRTF(currentPos));
        super(yawControl, () -> yawControl.getAngleToTargetByPose(currentPos));
        addRequirements(yawControl);
    }
}