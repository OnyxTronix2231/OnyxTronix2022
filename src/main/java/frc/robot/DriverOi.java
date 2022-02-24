package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcDriverOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.DriverShooterOIBinder;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final ConsoleController controller;

    public DriverOi() {
        controller = new OnyxXboxController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withDriveTrain(DriveTrain driveTrain) {
        JoystickAxis leftJoystick = new JoystickAxis(controller, controller.getAxisLeftY());
        JoystickAxis rightJoystick = new JoystickAxis(controller, controller.getAxisRightX());
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi withArc(Arc arc) {
        new ArcDriverOiBinder(arc);
        return this;
    }

    public DriverOi withShooter(Shooter shooter) {
        Trigger shooterTrigger = new JoystickButton(controller, controller.getBumperLeft());
        new DriverShooterOIBinder(shooter, shooterTrigger);
        return this;
    }
}
