package frc.robot.arms;

import frc.robot.arms.commands.MoveArmsBySpeed;
import humanControls.JoystickAxis;

public class DeputeArmsOiBinder {

    public DeputeArmsOiBinder(Arms climber, JoystickAxis climb) {
        climb.whileActiveContinuous(new MoveArmsBySpeed(climber, climb::getRawAxis));
    }
}
