package frc.robot.turret;

import frc.robot.turret.commands.RotateBySpeed;
import onyxTronix.JoystickAxis;
import static frc.robot.turret.TurretConstants.*;

public class DeputyTurretOiBinder {

    public DeputyTurretOiBinder(Turret turret, JoystickAxis moveLeft, JoystickAxis moveRight) {
        moveLeft.whileActiveContinuous(new RotateBySpeed(turret,
                () -> moveLeft.getRawAxis() * -ROTATION_SETBACK));
        moveRight.whileActiveContinuous(new RotateBySpeed(turret,
                () -> moveRight.getRawAxis() * ROTATION_SETBACK));
    }
}
