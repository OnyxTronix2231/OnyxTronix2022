package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.CalibrateArcOiBinder;
import frc.robot.climber.Climber;
import frc.robot.climber.DeputeClimberOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.DeputyBallTriggerOiBinder;
import frc.robot.conveyor.loader.DeputyLoaderOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DeputeGetReadyToShootOiBinder;
import frc.robot.crossPlatform.teleopCommands.DeputyShootBallOiBinder;
import frc.robot.drivetrain.DeputyDriveTrainOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.PlayStation5Controller;

import java.util.function.DoubleSupplier;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new PlayStation5Controller(DEPUTY_JOYSTICK_PORT);
    }

    public DeputyOi withClimber(Climber climber) {
        JoystickAxis climb = new JoystickAxis(controller, controller.getAxisLeftY());
        new DeputeClimberOiBinder(climber, climb);
        return this;
    }

    public DeputyOi withGetReadyToShoot(Shooter shooter, Arc arc, YawControl yawControl,
                                        DoubleSupplier distanceSupplier, DoubleSupplier angleSupplier) {
        Trigger getReady = new JoystickButton(controller, controller.getBumperLeft());
        new DeputeGetReadyToShootOiBinder(shooter, arc, yawControl, distanceSupplier, angleSupplier, getReady);
        return this;
    }

    public DeputyOi withArcCalibration(Arc arc) {
        Trigger calibrate = new JoystickButton(controller, controller.getCenterRight());
        new CalibrateArcOiBinder(arc, calibrate);
        return this;
    }

    public DeputyOi withLoader(Loader loader) {
        Trigger ejectLoaderBalls = new JoystickButton(controller, controller.getButtonDown());
        new DeputyLoaderOiBinder(loader, ejectLoaderBalls);
        return this;
    }

    public DeputyOi withBallTrigger(BallTrigger ballTrigger) {
        Trigger moveBallFromBallTriggerToLoader = new JoystickButton(controller, controller.getButtonUp());
        new DeputyBallTriggerOiBinder(ballTrigger, moveBallFromBallTriggerToLoader);
        return this;
    }

    public DeputyOi withShooter(Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger,
                                Turret turret, Vision vision) {
        Trigger shootToEjectBalls = new JoystickAxis(controller, controller.getRightTrigger());
        Trigger shootWithVision = new JoystickAxis(controller, controller.getLeftTrigger());
        new DeputyShootBallOiBinder(shooter, arc, loader, ballTrigger, vision, turret, shootToEjectBalls,
                shootWithVision);
        return this;
    }

    public DeputyOi withResetOdometry(DriveTrain driveTrain) {
        Trigger resetOdometry = new JoystickButton(controller, controller.getCenterLeft());
        new DeputyDriveTrainOiBinder(driveTrain, resetOdometry);
        return this;
    }
}
