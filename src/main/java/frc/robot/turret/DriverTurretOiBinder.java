package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateByAngleOnce;
import frc.robot.turret.commands.RotateBySpeed;
import frc.robot.turret.commands.RotateByVision;

import static frc.robot.turret.TurretConstants.*;

public class DriverTurretOiBinder {

    public DriverTurretOiBinder(Turret turret, Vision vision, Trigger moveLeft, Trigger moveRight, Trigger move10, Trigger move50,
                                Trigger move90, Trigger move180, Trigger byVision) {
        moveLeft.whileActiveContinuous(new RotateBySpeed(turret, () -> DEFAULT_TURRET_SPEED));
        moveRight.whileActiveContinuous(new RotateBySpeed(turret, () -> -DEFAULT_TURRET_SPEED));
        move10.whenActive(new RotateByAngleOnce(turret, () -> 10));
        move50.whenActive(new RotateByAngleOnce(turret, () -> 50));
        move90.whenActive(new RotateByAngleOnce(turret, () -> 90));
        move180.whenActive(new RotateByAngleOnce(turret, () -> 180));
        byVision.whileActiveContinuous(new RotateByVision(turret, vision));
    }
}
