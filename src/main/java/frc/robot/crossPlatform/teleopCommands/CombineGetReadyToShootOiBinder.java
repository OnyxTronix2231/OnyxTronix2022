package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import humanControls.JoystickAxis;

import java.util.function.DoubleSupplier;

public class CombineGetReadyToShootOiBinder {

    public CombineGetReadyToShootOiBinder(JoystickAxis driverButton, Trigger deputeButton, Shooter shooter, Arc arc,
                                          Turret turret, DoubleSupplier distanceFromTargetSupplier,
                                          DoubleSupplier angleSupplier) {
        driverButton.or(deputeButton).whileActiveContinuous(
                new GetReadyToShoot(shooter, arc, turret, distanceFromTargetSupplier, angleSupplier));
    }
}
