package frc.robot.climberArms;

import frc.robot.climberArms.commands.MoveArmsBySpeed;
import humanControls.JoystickAxis;

public class DeputeClimberOiBinder {

    public DeputeClimberOiBinder(ClimberArms climber, JoystickAxis climb) {
        climb.whileActiveContinuous(new MoveArmsBySpeed(climber, climb::getRawAxis));
    }
}
