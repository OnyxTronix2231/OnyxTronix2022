package frc.robot;

import crossPlatform.telopCommands.DriverIntakeAndConveyorOiBinder;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.DriverConveyorOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.intake.Intake;
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
        Trigger byVision = new JoystickButton(controller, controller.getLeftTrigger());
        new DriverTurretOiBinder(turret, vision, moveLeft, moveRight, byVision);
        return this;
    }

    public DriverOi withConveyor(Loader loader, BallTrigger ballTrigger) {
        Trigger load = new JoystickButton(controller, controller.getButtonUp());
        new DriverConveyorOiBinder(loader, ballTrigger, load);
        return this;
    }

    public DriverOi withConvoyerAndIntakeFront(Loader loader, BallTrigger ballTrigger, Intake intake){
        Trigger load = new JoystickButton(controller, controller.getButtonRight());
        new DriverIntakeAndConveyorOiBinder(loader,ballTrigger, intake, load);
        return this;
    }

    public DriverOi withConvoyerAndIntakeBack(Loader loader, BallTrigger ballTrigger, Intake intake) {
        Trigger load = new JoystickButton(controller, controller.getButtonLeft());
        new DriverIntakeAndConveyorOiBinder(loader, ballTrigger, intake, load);
        return this;
    }
}
