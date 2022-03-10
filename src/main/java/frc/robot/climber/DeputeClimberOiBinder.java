package frc.robot.climber;

import frc.robot.climber.commands.*;
import humanControls.JoystickAxis;

public class DeputeClimberOiBinder {

    public DeputeClimberOiBinder(Climber climber, JoystickAxis climb) {
        climb.whileActiveContinuous(new ClimbBySpeed(climber, climb::getRawAxis));
    }
}
