package frc.robot;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.arc.CalibrateArcOiBinder;
import frc.robot.crossPlatform.teleopCommands.DeputeGetReadyToShootOiBinder;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;
import humanControls.ConsoleController;
import humanControls.OnyxXboxController;

import java.util.function.DoubleSupplier;

import static frc.robot.Constants.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {

    final ConsoleController controller;

    public DeputyOi() {
        controller = new OnyxXboxController(DEPUTY_JOYSTICK_PORT);
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
}
