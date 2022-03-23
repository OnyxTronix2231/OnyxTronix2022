package frc.robot.stabilizers;

import frc.robot.stabilizers.commands.MoveStabilizerBySpeed;
import humanControls.JoystickAxis;

public class DeputyStabilizersOiBinder {

    public DeputyStabilizersOiBinder(Stabilizer climberStabilizer, JoystickAxis moveStabilizers) {
        moveStabilizers.whileActiveContinuous(new MoveStabilizerBySpeed(climberStabilizer, moveStabilizers::getRawAxis));
    }
}
