package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

import java.util.function.DoubleSupplier;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, DoubleSupplier angle) {
        yawControl.setDefaultCommand(new RotateToAngleRTF(yawControl, angle ));
    }
}
