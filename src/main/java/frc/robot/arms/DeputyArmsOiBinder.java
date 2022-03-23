package frc.robot.arms;

import frc.robot.arms.commands.MoveArmsBySpeed;
import humanControls.JoystickAxis;

public class DeputyArmsOiBinder {

    public DeputyArmsOiBinder(Arms climber, JoystickAxis climb) {
        climb.whileActiveContinuous(new MoveArmsBySpeed(climber, climb::getRawAxis));
    }
}
