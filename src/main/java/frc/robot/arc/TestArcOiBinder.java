package frc.robot.arc;

import frc.robot.arc.commands.MoveArcBySpeed;

import static frc.robot.arc.ArcConstants.ComponentsConstants.SPEED;

public class TestArcOiBinder {
    public TestArcOiBinder(Arc arc) {
        arc.setDefaultCommand(new MoveArcBySpeed(arc, ()-> SPEED));
    }
}
