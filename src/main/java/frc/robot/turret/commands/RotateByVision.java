package frc.robot.turret.commands;

import frc.robot.turret.Turret;

public class RotateByVision extends RotateByAngle {

    public RotateByVision(Turret turret, Vision vision) {
       super(turret, vision.ighfbvcnks); //add vision commands, By Dan Or and Eyal.
       addRequirements(turret);
    }
}
