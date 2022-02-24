package frc.robot.arc;

import frc.robot.arc.commands.MoveArcBySpeed;
import humanControls.JoystickAxis;

public class ArcDriverOiBinder {

    public ArcDriverOiBinder(Arc arc, JoystickAxis changeAngle) {
        arc.setDefaultCommand(new MoveArcBySpeed(arc, ()-> arc.getAngle()));
    }
}
