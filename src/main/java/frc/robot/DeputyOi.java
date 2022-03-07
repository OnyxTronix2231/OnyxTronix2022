package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.climber.Climber;
import frc.robot.climber.DeputeClimberOiBinder;
import frc.robot.arc.Arc;
import frc.robot.arc.CalibrateArcOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.DeputyBallTriggerOiBinder;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.DeputyLoaderOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DeputeGetReadyToShootOiBinder;
import frc.robot.crossPlatform.teleopCommands.DeputyShootBallOiBinder;
import frc.robot.shooter.Shooter;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.yawControl.YawControl;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;
import humanControls.PlayStation5Controller;

import java.util.function.DoubleSupplier;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new OnyxXboxController(DEPUTY_JOYSTICK_PORT);
    }

    public DeputyOi withClimber(Climber climber){
        JoystickAxis climb = new JoystickAxis(controller, controller.getAxisLeftY(),  0.2);
        Trigger moveRightArmSlow = new JoystickAxis(controller, controller.getRightTrigger());
        Trigger moveLeftArmSlow = new JoystickAxis(controller, controller.getLeftTrigger());
        JoystickAxis moveLeftArm = new JoystickAxis(controller, controller.getAxisRightY());
        new DeputeClimberOiBinder(climber, climb, moveRightArmSlow, moveLeftArmSlow, moveLeftArm);
        return this;
    }

    public DeputyOi withGetReadyToShoot(Shooter shooter, Arc arc, YawControl yawControl,
                                        DoubleSupplier distanceSupplier, DoubleSupplier angleSupplier) {
        Trigger getReady = new JoystickButton(controller, controller.getBumperLeft());
        new DeputeGetReadyToShootOiBinder(shooter, arc, yawControl, getReady, distanceSupplier, angleSupplier);
        return this;
    }

    public DeputyOi withArcCalibration(Arc arc){
        Trigger calibrate = new JoystickButton(controller, controller.getCenterRight());
        new CalibrateArcOiBinder(arc, calibrate);
        return this;
    }

    public DeputyOi withLoader(Loader loader) {
        Trigger ejectLoaderBalls = new JoystickButton(controller, controller.getButtonRight());
        Trigger feedBallTriggerWithBalls = new JoystickButton(controller, controller.getButtonDown());
        new DeputyLoaderOiBinder(loader, feedBallTriggerWithBalls, ejectLoaderBalls);
        return this;
    }

    public DeputyOi withBallTrigger(BallTrigger ballTrigger) {
        Trigger ejectTriggerBalls = new JoystickButton(controller, controller.getButtonLeft());
        Trigger feedShooterWithBalls = new JoystickButton(controller, controller.getButtonUp());
        new DeputyBallTriggerOiBinder(ballTrigger, feedShooterWithBalls, ejectTriggerBalls);
        return this;
    }

    public DeputyOi withShootToEjectBalls(Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger) {
        Trigger shootToEjectBalls = new JoystickButton(controller, controller.getBumperRight()); // TODO check with buttons, check with turret maybe
        new DeputyShootBallOiBinder(shooter, arc, loader, ballTrigger, shootToEjectBalls);
        return this;
    }
}
