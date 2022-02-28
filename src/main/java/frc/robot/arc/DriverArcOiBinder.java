package frc.robot.arc;

import frc.robot.arc.commands.MoveArcBySpeed;

import static frc.robot.arc.ArcConstants.SPEED;

public class DriverArcOiBinder {

    public DriverArcOiBinder(Arc arc) {
        arc.setDefaultCommand(new MoveArcBySpeed(arc, ()-> SPEED));
    }
}
