package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateToAngleRTR;

public class DriverYawControlOiBinder {

    public DriverYawControlOiBinder(YawControl yawControl, Trigger rotateByPose) {
        rotateByPose.whileActiveContinuous(new RotateToAngleRTR(yawControl, yawControl::getAngleRTRToTarget));
    }
}
