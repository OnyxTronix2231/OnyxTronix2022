package frc.robot.climber;

import frc.robot.climber.commands.MoveArmsBySpeed;
import humanControls.JoystickAxis;

public class DeputeClimberOiBinder {

    public DeputeClimberOiBinder(Climber climber, JoystickAxis climb) {
        climb.whileActiveContinuous(new MoveArmsBySpeed(climber, climb::getRawAxis));

    }
}
