package frc.robot.yawControl.Commands;

import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import static frc.robot.vision.VisionConstants.TARGET_NOT_FOUND;

public class RotateByPoseOrByVision extends ConditionalCommand {

    public RotateByPoseOrByVision (YawControl yawControl, Vision vision) {
        super(new RotateByVision(yawControl, vision),
                new RotateByPose(yawControl), () -> vision.getHorizontalAngleTurretToTargetRTT() != TARGET_NOT_FOUND);
    }
}
