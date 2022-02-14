package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.loader.Loader;
import frc.robot.loader.LoaderOiBinder;
import frc.robot.trigger.BallTriggerOiBinder;
import frc.robot.trigger.BallTrigger;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private ConsoleController consoleController;

    public DriverOi() {
        consoleController = new ConsoleController(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withDriveTrain(DriveTrain driveTrain ) {
        JoystickAxis leftJoystick = new JoystickAxis(consoleController, consoleController.getAxisLeftY());
        JoystickAxis rightJoystick = new JoystickAxis(consoleController, consoleController.getAxisRightX());
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi withTrigger(BallTrigger ballTrigger) {
        JoystickButton triggerMoveBySpeed = new JoystickButton(consoleController, consoleController.getButtonDown());
        new BallTriggerOiBinder(ballTrigger, triggerMoveBySpeed);
        return this;
    }
    public DriverOi withLoader(Loader loader) {
        JoystickButton loaderMoveBySpeed = new JoystickButton(consoleController, consoleController.getButtonUp());
        new LoaderOiBinder(loader, loaderMoveBySpeed);
        return this;
    }
}
