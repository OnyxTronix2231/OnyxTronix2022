package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.PlayStation5Controller;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    final ConsoleController controller;

    public DriverOi() {
        controller = new PlayStation5Controller(DRIVE_JOYSTICK_PORT);
    }

    public DriverOi withDriveTrain(DriveTrain driveTrain) {
        JoystickAxis leftJoystick = new JoystickAxis(controller, controller.getAxisLeftY());
        JoystickAxis rightJoystick = new JoystickAxis(controller, controller.getAxisRightX());
        Trigger buttonA = new JoystickButton(controller, controller.getButtonDown());
        Trigger buttonB = new JoystickButton(controller, controller.getButtonRight());
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick, buttonA, buttonB);
        return this;
    }
}
