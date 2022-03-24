package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.turret.commands.RotateToAngleRTR;

public class DeputyStopLookingAtTargetOiBinder {

    public DeputyStopLookingAtTargetOiBinder(YawControl yawControl, Trigger centerLeft){
        centerLeft.whenActive(new RotateToAngleRTR(yawControl, yawControl::getCurrentAngleRTR));

    }
}
