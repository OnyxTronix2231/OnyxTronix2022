package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.CombineGetReadyOiBinder;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import humanControls.JoystickAxis;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class CombineOi {

    private final DriverOi driverOi;
    private final DeputyOi deputyOi;

    public CombineOi(DriverOi driverOi, DeputyOi deputyOi) {
        this.driverOi = driverOi;
        this.deputyOi = deputyOi;
    }

    public CombineOi withGetReady(Shooter shooter, Arc arc, Turret turret, DoubleSupplier distanceFromTargetSupplier,
                                  DoubleSupplier angleSupplier, BooleanSupplier con, Loader loader,
                                  BallTrigger ballTrigger) {
        JoystickAxis driverButton = new JoystickAxis(driverOi.controller, driverOi.controller.getRightTrigger());
        Trigger deputeButton = new JoystickButton(deputyOi.controller, deputyOi.controller.getBumperLeft());
        new CombineGetReadyOiBinder(driverButton, deputeButton, shooter, arc, turret, distanceFromTargetSupplier,
                angleSupplier, con, loader, ballTrigger);
        return this;
    }
}
