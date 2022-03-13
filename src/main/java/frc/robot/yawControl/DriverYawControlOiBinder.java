package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

import static frc.robot.turret.TurretConstants.MIDDLE_ANGLE;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl) {
        yawControl.setDefaultCommand(new RotateToAngleRTF(yawControl, yawControl::getAngleRTFToTarget));
    }
}
