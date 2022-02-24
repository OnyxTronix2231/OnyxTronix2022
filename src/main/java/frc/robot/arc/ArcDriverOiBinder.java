package frc.robot.arc;

import frc.robot.arc.commands.MoveArcBySpeed;
import humanControls.JoystickAxis;

public class ArcDriverOiBinder {

    public ArcDriverOiBinder(Arc arc) {
        arc.setDefaultCommand(new MoveArcBySpeed(arc, ()-> arc.getAngle()));
    }
}
