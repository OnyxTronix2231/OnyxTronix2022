package frc.robot.yawControl.Commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.commands.visionDependent.RotateByVision;
import frc.robot.yawControl.YawControl;

public class LocateTargetByCalculating extends ConditionalCommand {

    public LocateTargetByCalculating(YawControl yawControl, Vision vision, Pose2d currentPos) {
        super(new RotateByVision(yawControl, vision), new RotateByPos(yawControl, currentPos), ()-> vision.hasTarget());
        addRequirements(yawControl, vision);
    }
}
