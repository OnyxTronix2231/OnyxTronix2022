package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.CalibrateArcOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.UpperThreeBalls;
import frc.robot.crossPlatform.teleopCommands.DriverGetReadyToClimeOiBinder;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeAndLoadBallsOiBinder;
import frc.robot.crossPlatform.teleopCommands.DriverIntakeByDriveTrainAndLoadBallsOiBinder;
import frc.robot.crossPlatform.teleopCommands.DriverShootBallOiBinder;
import frc.robot.driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriverDriveTrainOiBinders;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.SmartRotateByAngle;
import frc.robot.vision.Vision;
import frc.robot.yawControl.DriverYawControlOiBinder;
import frc.robot.yawControl.YawControl;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.PlayStation5Controller;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

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

    public DriverOi withIntakeFrontAndLoadBallsPlanB(Intake intake, Loader loader, BallTrigger ballTrigger) {
        Trigger load = new JoystickButton(controller, controller.getBumperRight());
        new DriverIntakeAndLoadBallsOiBinder(intake, loader, ballTrigger, load);
        return this;
    }

    public DriverOi withIntakeBackAndLoadBallsPlanB(Intake intake, Loader loader, BallTrigger ballTrigger) {
        Trigger load = new JoystickButton(controller, controller.getBumperLeft());
        new DriverIntakeAndLoadBallsOiBinder(intake, loader, ballTrigger, load);
        return this;
    }

    public DriverOi withShootBalls(Vision vision, Shooter shooter, Arc arc, YawControl yawControl,
                                   BallTrigger ballTrigger, Loader loader, DoubleSupplier distanceSupplier,
                                   DoubleSupplier angleSupplier, BooleanSupplier conditionSupplier) {
        Trigger shoot = new JoystickAxis(controller, controller.getRightTrigger());
        Trigger shootCloseToHighTarget = new JoystickAxis(controller, controller.getLeftTrigger());
        Trigger realiseBalls = new JoystickButton(controller, controller.getButtonUp());
        new DriverShootBallOiBinder(shooter, arc, ballTrigger, loader, vision, yawControl, distanceSupplier,
                angleSupplier, conditionSupplier, shoot, shootCloseToHighTarget, realiseBalls);
        return this;
    }

    public DriverOi withArcCalibration(Arc arc) {
        Trigger calibrate = new JoystickButton(controller, controller.getCenterRight());
        new CalibrateArcOiBinder(arc, calibrate);
        return this;
    }

    public DriverOi withGetReadyToClime(Turret turret, Arc arc, Intake intakeForward) {
        Trigger buttonLeft = new JoystickButton(controller, controller.getButtonLeft());
        new DriverGetReadyToClimeOiBinder(turret, arc, intakeForward, buttonLeft);
        return this;
    }

    public DriverOi withYawControl(YawControl yawControl){
        new DriverYawControlOiBinder(yawControl);
        return this;
    }

    public DriverOi withIntakeByDriveTrainAndLoadBalls(DriveTrainJoystickValueProvider joystickValueProvider,
                                                       Intake intakeFront, Intake intakeBack, Loader loader,
                                                       BallTrigger ballTrigger) {
        Trigger collect = new JoystickButton(controller, controller.getBumperLeft());
        new DriverIntakeByDriveTrainAndLoadBallsOiBinder(joystickValueProvider, intakeFront, intakeBack,
                loader, ballTrigger, collect);
        return this;
    }

    public DriverOi withTurretByOdometry(YawControl turret, AngleProvider angleProvider) {
        Trigger trigger = new JoystickButton(controller, controller.getBumperLeft());
        trigger.whileActiveOnce(new SmartRotateByAngle(turret, angleProvider));
        return this;
    }

    public DriverOi withDriveTrainCalb(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                       BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                       DistanceProvider distanceProvider, AngleProvider angleProvider) {
        Trigger calibrate = new JoystickButton(controller, controller.getButtonUp());
        calibrate.whileActiveOnce(new UpperThreeBalls(driveTrain, frontIntake, backIntake, loader,
                ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        return this;
    }
}
