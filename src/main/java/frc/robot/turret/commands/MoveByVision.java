package frc.robot.turret.commands;

import frc.robot.turret.Turret;

public class MoveByVision {

    private MoveByAngle moveByAngle;

    public MoveByVision(Turret turret, Vision vision) {
        moveByAngle = new MoveByAngle(turret, vision.get)
    }
}
