package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.DriverConveyorOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.BallTriggerOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.LoaderOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.turret.DriverTurretOiBinder;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;
import humanControls.PlayStation5Controller;

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

    public DriverOi withTurret(Turret turret, Vision vision) {
        Trigger moveLeft = new JoystickButton(controller, controller.getBumperLeft());
        Trigger moveRight = new JoystickButton(controller, controller.getBumperRight());
        Trigger move10 = new JoystickButton(controller, controller.getButtonUp());
        Trigger move50 = new JoystickButton(controller, controller.getButtonRight());
        Trigger move90 = new JoystickButton(controller, controller.getButtonDown());
        Trigger move180 = new JoystickButton(controller, controller.getButtonLeft());
        Trigger byVision = new JoystickButton(controller, controller.getCenterLeft());
        new DriverTurretOiBinder(turret, vision, moveLeft, moveRight, move10, move50, move90, move180, byVision);
        return this;
    }

    public DriverOi withConveyor(Loader loader, BallTrigger ballTrigger){
        Trigger load = new JoystickButton(controller, controller.getButtonUp());
        new DriverConveyorOiBinder(loader, ballTrigger, load);
        return this;
    }

    public DriverOi withLoader(Loader loader){
        Trigger loadBySpeed = new JoystickButton(controller,controller.getButtonRight());
        new LoaderOiBinder(loader,loadBySpeed);
        return this;
    }

    public DriverOi withBallTrigger(BallTrigger ballTrigger){
        Trigger ballTriggerBySpeed = new JoystickButton(controller,controller.getButtonLeft());
        new BallTriggerOiBinder(ballTrigger,ballTriggerBySpeed);
        return this;
    }
}