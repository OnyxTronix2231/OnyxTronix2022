package frc.robot.arc;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.commands.MoveArcBySpeed;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.arc.commands.MoveLinearServoByDistance;
import onyxTronix.JoystickAxis;

import static frc.robot.arc.ArcConstants.ANGLE;

public class ArcDriverOiBinder {

    public ArcDriverOiBinder(Arc arc, JoystickAxis changeAngle) {
        changeAngle.whileActiveContinuous(new MoveArcBySpeed(arc, changeAngle::getRawAxis));
    }
}
