package frc.robot.turret;

import frc.robot.turret.commands.RotateTurretBySpeed;
import onyxTronix.JoystickAxis;
import static frc.robot.turret.TurretConstants.*;

public class DeputyTurretOiBinder {

    public DeputyTurretOiBinder(Turret turret, JoystickAxis moveLeft, JoystickAxis moveRight) {
        moveLeft.whileActiveContinuous(new RotateTurretBySpeed(turret,
                () -> moveLeft.getRawAxis() * -ROTATION_SETBACK));
        moveRight.whileActiveContinuous(new RotateTurretBySpeed(turret,
                () -> moveRight.getRawAxis() * ROTATION_SETBACK));
    }
}
