package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.TestBallTriggerOiBinder;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.TestLoaderOiBinder;
import humanControls.ConsoleController;
import humanControls.OnyxXboxController;

import static frc.robot.Constants.DRIVE_JOYSTICK_PORT;

public class TestOi {

    final ConsoleController controller;

    public TestOi() {
        controller = new OnyxXboxController(DRIVE_JOYSTICK_PORT);
    }

    public TestOi withLoader(Loader loader) {
        Trigger loadBySpeed = new JoystickButton(controller, controller.getButtonRight());
        new TestLoaderOiBinder(loader, loadBySpeed);
        return this;
    }

    public TestOi withBallTrigger(BallTrigger ballTrigger) {
        Trigger ballTriggerBySpeed = new JoystickButton(controller, controller.getButtonLeft());
        new TestBallTriggerOiBinder(ballTrigger, ballTriggerBySpeed);
        return this;
    }


}


