package frc.robot.turret.commands;

import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class RotateByVision extends RotateByAngleConstantly {

   public RotateByVision(Turret turret, Vision vision) {
       super(turret, vision::getHorizontalAngleTurretToTargetRTT);
   }
}
