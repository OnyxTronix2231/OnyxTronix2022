package frc.robot.crossPlatform.teleopCommands;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import humanControls.JoystickAxis;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class CombineGetReadyOiBinder {

    public CombineGetReadyOiBinder(JoystickAxis driverButton, Trigger deputeButton, Shooter shooter, Arc arc,
                                   Turret turret, DoubleSupplier distanceFromTargetSupplier,
                                   DoubleSupplier angleSupplier, BooleanSupplier condisions,
                                   Loader loader, BallTrigger ballTrigger) {
        driverButton.or(deputeButton).whileActiveContinuous(
                new GetReadyToShoot(shooter, arc, turret, distanceFromTargetSupplier, angleSupplier));
    }
}
