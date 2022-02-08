package frc.robot.turret.commands;

import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateByAngle;

public class RotateByVision extends RotateByAngle {

   public RotateByVision(Turret turret, Vision vision) {
       super(turret, vision.vision()); //TODO: add the correct func from vision
   }
}
