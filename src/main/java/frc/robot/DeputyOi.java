package frc.robot;

<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.advancedClimber.AdvancedClimber;
import frc.robot.arc.Arc;
import frc.robot.arms.Arms;
import frc.robot.arms.DeputyArmsOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.DeputyBallTriggerOiBinder;
import frc.robot.conveyor.loader.DeputyLoaderOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.teleopCommands.DeputyShootBallOiBinder;
import frc.robot.crossPlatform.teleopCommands.ShootWhileDriving.DriverSWDOiBinder;
import frc.robot.crossPlatform.teleopCommands.ShootWhileDriving.LoadBallsOiBinder;
import frc.robot.drivetrain.DeputyDriveTrainOiBinder;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.stabilizers.DeputyStabilizersOiBinder;
import frc.robot.turret.Turret;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.vision.Vision;
import frc.robot.yawControl.DeputyStopLookingAtTargetOiBinder;
import frc.robot.yawControl.YawControl;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.PlayStation5Controller;
=======
import edu.wpi.first.wpilibj.XboxController;
>>>>>>> main

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final XboxController xboxController;

    public DeputyOi() {
<<<<<<< HEAD
        controller = new PlayStation5Controller(DEPUTY_JOYSTICK_PORT);
    }

    public DeputyOi withClimber(Arms arms, AdvancedClimber advancedClimber) {
        JoystickAxis climb = new JoystickAxis(controller, controller.getAxisLeftY());
        JoystickAxis moveStabilizers = new JoystickAxis(controller, controller.getAxisRightY());
        //Trigger autoClimb = new JoystickButton(controller, controller.getButtonRight());
        new DeputyArmsOiBinder(arms, climb);
        new DeputyStabilizersOiBinder(advancedClimber, moveStabilizers);
        //new DeputyAutoClimbOiBinder(advancedClimber, arms, autoClimb); // TODO Test AutoClimb
        return this;
    }

//    public DeputyOi withArcCalibration(Arc arc) {
//        Trigger calibrate = new JoystickButton(controller, controller.getCenterRight());
//        new CalibrateArcOiBinder(arc, calibrate);
//        return this;
//    }

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

    public DeputyOi withStopLookingAtTarget(YawControl yawControl) { //todo check
        Trigger centerLeft = new JoystickButton(controller, controller.getCenterRight());
        new DeputyStopLookingAtTargetOiBinder(yawControl, centerLeft);
        return this;
    }

    public DeputyOi withShooter(DriveTrain driveTrain, Shooter shooter, Arc arc, Loader loader, BallTrigger ballTrigger,
                                Turret turret) {
        Trigger shootToEjectBalls = new JoystickAxis(controller, controller.getRightTrigger());
        Trigger shootWithVision = new JoystickAxis(controller, controller.getLeftTrigger());
        new DeputyShootBallOiBinder(driveTrain, shooter, arc, loader, ballTrigger, turret, shootToEjectBalls,
                shootWithVision);
        return this;
    }

    public DeputyOi withResetOdometry(DriveTrain driveTrain) {
        Trigger resetOdometry = new JoystickButton(controller, controller.getCenterLeft());
        new DeputyDriveTrainOiBinder(driveTrain, resetOdometry);
        return this;
    }

    public DeputyOi withTurret(DriveTrain driveTrain, YawControl yawControl, Shooter shooter, Arc arc, BallTrigger ballTrigger, Loader loader) {

        Trigger swd = new JoystickButton(controller, controller.getButtonRight());
        new DriverSWDOiBinder(driveTrain, yawControl, shooter, arc, swd);


        return this;

=======
        xboxController = new XboxController(Deputy_JOYSTICK_PORT);
>>>>>>> main
    }
}
