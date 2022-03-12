package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateToAngleRTR;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, Trigger rotateAngleRTF) {
        rotateAngleRTF.toggleWhenActive(new RotateToAngleRTF(yawControl, yawControl::getAngleRTFToTarget));
    }
}
