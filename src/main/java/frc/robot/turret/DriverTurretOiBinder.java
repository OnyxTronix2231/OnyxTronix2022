package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateBySpeed;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.*;

public class DriverTurretOiBinder {

    public DriverTurretOiBinder(Turret turret, Vision vision, Trigger moveLeft, Trigger moveRight, Trigger byVision) {
        moveLeft.whileActiveContinuous(new RotateBySpeed(turret, () -> DEFAULT_TURRET_SPEED));
        moveRight.whileActiveContinuous(new RotateBySpeed(turret, () -> -DEFAULT_TURRET_SPEED));
        byVision.whileActiveContinuous(new RotateByVision(turret, vision));
    }
}
