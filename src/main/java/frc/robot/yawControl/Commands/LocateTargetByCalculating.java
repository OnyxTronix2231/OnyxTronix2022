package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

public class LocateTargetByCalculating extends RotateToAngleRTF {

   public LocateTargetByCalculating(YawControl yawControl, Vision vision) {
       super(yawControl, ()-> yawControl.getAngleNonVisionDependent(vision) );
       addRequirements(yawControl, vision);
   }
}