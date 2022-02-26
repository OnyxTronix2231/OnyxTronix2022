package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.turret.DriverTurretOiBinder;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;
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
        new DriverDriveTrainOiBinders(driveTrain, leftJoystick, rightJoystick);
        return this;
    }

    public DriverOi withTurret(Turret turret, Vision vision) {
        Trigger moveLeft = new JoystickButton(controller, controller.getBumperLeft());
        Trigger moveRight = new JoystickButton(controller, controller.getBumperRight());
        Trigger byVision = new JoystickButton(controller, controller.getLeftTrigger());
        new DriverTurretOiBinder(turret, vision, moveLeft, moveRight, byVision);
        return this;
    }
}
