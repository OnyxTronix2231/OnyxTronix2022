package frc.robot.stabilizers;

import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import humanControls.JoystickAxis;

public class DeputeStabilizersOiBinder {

    public DeputeStabilizersOiBinder(Stabilizers climberStabilizers, JoystickAxis moveStabilizers) {
        moveStabilizers.whileActiveContinuous(new MoveStabilizerBySpeed(climberStabilizers, moveStabilizers::getRawAxis));
    }
}
