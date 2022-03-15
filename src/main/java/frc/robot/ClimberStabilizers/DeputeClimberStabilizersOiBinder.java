package frc.robot.ClimberStabilizers;

import frc.robot.ClimberStabilizers.commands.MoveStabilizerBySpeed;
import humanControls.JoystickAxis;

public class DeputeClimberStabilizersOiBinder {

    public DeputeClimberStabilizersOiBinder(ClimberStabilizers climberStabilizers, JoystickAxis moveStabilizers) {
        moveStabilizers.whileActiveContinuous(new MoveStabilizerBySpeed(climberStabilizers, moveStabilizers::getRawAxis));
    }
}
