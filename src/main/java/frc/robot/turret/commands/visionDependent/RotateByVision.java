package frc.robot.turret.commands.visionDependent;

import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateByAngle;

public class RotateByVision extends RotateByAngle {

    public RotateByVision(Turret turret, Vision vision) {
       super(turret, vision.vision()); //add vision commands, By Dan Or and Eyal.
       addRequirements(turret);
    }
}
