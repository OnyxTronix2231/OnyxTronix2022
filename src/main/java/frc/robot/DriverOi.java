package frc.robot;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.crossPlatform.teleopCommands.DriverShooterArcAndConveyorOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeAndLoadBallsOiBinder;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeByDriveTrainAndLoadBallsOiBinder;
import frc.robot.intake.Intake;
import frc.robot.shooter.Shooter;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;
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

    public DriverOi withIntakeByDriveTrainAndLoadBalls(DriveTrainJoystickValueProvider joystickValueProvider, Intake intakeFront, Intake intakeBack,
                                                       Loader loader, BallTrigger ballTrigger) {
        Trigger collect = new JoystickButton(controller, controller.getButtonRight());
        new DriverIntakeByDriveTrainAndLoadBallsOiBinder(joystickValueProvider, intakeFront, intakeBack, loader, ballTrigger, collect);
        return this;
    }

    public DriverOi withShooterArcAndConveyor(Loader loader, BallTrigger ballTrigger, Shooter shooter, Arc arc){
        Trigger shoot = new JoystickButton(controller, controller.getBumperLeft());
        new DriverShooterArcAndConveyorOiBinder(loader, ballTrigger, shooter, arc, shoot);
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
