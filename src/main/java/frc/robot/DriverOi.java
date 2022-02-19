package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.button.Trigger;
=======
import frc.robot.Conveyor.loader.Loader;
import frc.robot.Conveyor.loader.LoaderOiBinder;
import frc.robot.Conveyor.ballTrigger.BallTriggerOiBinder;
import frc.robot.Conveyor.ballTrigger.BallTrigger;
>>>>>>> parent of f38dcfd (fixed acourdung to CR and change ball transfer logic)
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

<<<<<<< HEAD
    public DriverOi withTurret(Turret turret, Vision vision) {
        Trigger moveLeft = new JoystickButton(controller, controller.getBumperLeft());
        Trigger moveRight = new JoystickButton(controller, controller.getBumperRight());
        Trigger move10 = new JoystickButton(controller, controller.getButtonUp());
        Trigger move50 = new JoystickButton(controller, controller.getButtonRight());
        Trigger move90 = new JoystickButton(controller, controller.getButtonDown());
        Trigger move180 = new JoystickButton(controller, controller.getButtonLeft());
        Trigger byVision = new JoystickButton(controller, controller.getCenterLeft());
        new DriverTurretOiBinder(turret, vision, moveLeft, moveRight, move10, move50, move90, move180, byVision);
=======
    public DriverOi withTrigger(BallTrigger ballTrigger) {
        JoystickButton triggerMoveBySpeed = new JoystickButton(consoleController, consoleController.getButtonDown());
        new BallTriggerOiBinder(ballTrigger, triggerMoveBySpeed);
        return this;
    }
    public DriverOi withLoader(Loader loader) {
        JoystickButton loaderMoveBySpeed = new JoystickButton(consoleController, consoleController.getButtonUp());
        new LoaderOiBinder(loader, loaderMoveBySpeed);
>>>>>>> parent of f38dcfd (fixed acourdung to CR and change ball transfer logic)
        return this;
    }
}
