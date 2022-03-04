package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.TestArcOiBinder;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.TestBallTriggerOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.TestLoaderOiBinder;
import frc.robot.intake.Intake;
import frc.robot.intake.TestIntakeOiBinder;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.TestShooterOiBinder;
import humanControls.ConsoleController;
import humanControls.JoystickAxis;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class TestOi {

    final ConsoleController controller;

    public TestOi() {
        controller = new OnyxXboxController(DRIVE_JOYSTICK_PORT);
    }

    public TestOi withShooter(Shooter shooter) {
        Trigger shooterTrigger = new JoystickButton(controller, controller.getBumperLeft());
        new TestShooterOiBinder(shooter, shooterTrigger);
        return this;
    }

    public TestOi withArc(Arc arc) {
        new TestArcOiBinder(arc);
        return this;
    }

    public TestOi withLoader(Loader loader) {
        Trigger loadBySpeed = new JoystickAxis(controller, controller.getLeftTrigger());
        new TestLoaderOiBinder(loader, loadBySpeed);
        return this;
    }

    public TestOi withBallTrigger(BallTrigger ballTrigger) {
        Trigger ballTriggerBySpeed = new JoystickAxis(controller, controller.getRightTrigger());
        new TestBallTriggerOiBinder(ballTrigger, ballTriggerBySpeed);
        return this;
    }

    public TestOi withIntake(Intake intakeFront, Intake intakeBack) {
        Trigger openFrontPiston = new JoystickButton(controller, controller.getButtonDown());
        Trigger openBackPiston = new JoystickButton(controller, controller.getButtonLeft());

        Trigger closeFrontPiston = new JoystickButton(controller, controller.getButtonUp());
        Trigger closeBackPiston = new JoystickButton(controller, controller.getButtonRight());

        Trigger moveFrontIntake = new JoystickButton(controller, controller.getBumperRight());
        Trigger moveBackIntake = new JoystickButton(controller, controller.getBumperLeft());

        new TestIntakeOiBinder(intakeFront, intakeBack, openFrontPiston, openBackPiston, closeFrontPiston,
                closeBackPiston, moveFrontIntake, moveBackIntake);
        return this;
    }
}


