package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateBySpeed;
import onyxTronix.JoystickAxis;
import static frc.robot.turret.TurretConstants.*;

public class DeputyTurretOiBinder {

    public DeputyTurretOiBinder(Turret turret, Trigger moveLeft, Trigger moveRight) {
        moveLeft.whileActiveContinuous(new RotateBySpeed(turret, () -> DEFULT_TURRET_SPEED));
        moveRight.whileActiveContinuous(new RotateBySpeed(turret, () -> -DEFULT_TURRET_SPEED));
    }
}
