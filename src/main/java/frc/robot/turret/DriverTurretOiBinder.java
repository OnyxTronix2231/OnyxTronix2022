package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateBySpeed;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.DEFAULT_TURRET_SPEED;

public class DriverTurretOiBinder {

    public DriverTurretOiBinder(Turret turret, Trigger moveLeft, Trigger moveRight) {
        moveLeft.whileActiveContinuous(new RotateBySpeed(turret, () -> DEFAULT_TURRET_SPEED));
        moveRight.whileActiveContinuous(new RotateBySpeed(turret, () -> -DEFAULT_TURRET_SPEED));
    }
}
