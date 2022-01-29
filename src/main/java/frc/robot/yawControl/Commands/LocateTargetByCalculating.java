package frc.robot.yawControl.Commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.ConditionalCommand;
import frc.robot.turret.commands.RotateByAngle;
import frc.robot.turret.commands.visionDependent.RotateByVision;
import frc.robot.yawControl.YawControl;

public class LocateTargetByCalculating extends RotateToAngleRTF {

   public LocateTargetByCalculating(YawControl yawControl, Vision vision) {
       super(yawControl, ()-> yawControl.getAngleNoVisionDependent(vision) );
       addRequirements(yawControl, vision);
   }
}
