package frc.robot.turret.commands;

import frc.robot.turret.Turret;

public class MoveByVision extends MoveByAngle {

    public MoveByVision(Turret turret, Vision vision) {
       super(turret, vision.ighfbvcnks);
       addRequirements(turret);
    }
}
