package frc.robot;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeAndLoadBallsOiBinder;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeByDriveTrainAndLoadBallsOiBinder;
import frc.robot.intake.Intake;
import frc.robot.turret.DriverTurretOiBinder;
import frc.robot.yawControl.DriverYawControlOiBinder;
import frc.robot.yawControl.YawControl;
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

    public DriverOi withYawControl(YawControl yawControl){
        Trigger moveRTF = new JoystickButton(controller, controller.getButtonUp());
        Trigger left = new JoystickButton(controller, controller.getBumperLeft());
        Trigger right = new JoystickButton(controller, controller.getBumperRight());
        new DriverYawControlOiBinder(yawControl, moveRTF);
        new DriverTurretOiBinder(yawControl, left, right);
        return this;
    }

    public DriverOi withIntakeByDriveTrainAndLoadBalls(DriveTrainJoystickValueProvider joystickValueProvider, Intake intakeFront, Intake intakeBack,
                                                       Loader loader, BallTrigger ballTrigger) {
        Trigger collect = new JoystickButton(controller, controller.getButtonRight());
        new DriverIntakeByDriveTrainAndLoadBallsOiBinder(joystickValueProvider, intakeFront, intakeBack, loader, ballTrigger, collect);
        return this;
    }

    public DriverOi withIntakeFrontAndLoadBallsPlanB(Intake intake, Loader loader, BallTrigger ballTrigger) {
        Trigger load = new JoystickButton(controller, controller.getButtonRight());
        new DriverIntakeAndLoadBallsOiBinder(intake, loader, ballTrigger, load);
        return this;
    }

    public DriverOi withIntakeBackAndLoadBallsPlanB(Intake intake, Loader loader, BallTrigger ballTrigger) {
        Trigger load = new JoystickButton(controller, controller.getButtonLeft());
        new DriverIntakeAndLoadBallsOiBinder(intake, loader, ballTrigger, load);
        return this;
    }
}
