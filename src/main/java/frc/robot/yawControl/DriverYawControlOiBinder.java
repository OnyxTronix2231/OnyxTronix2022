package frc.robot.yawControl;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

public class DriverYawControlOiBinder extends CommandBase {

    public DriverYawControlOiBinder(YawControl yawControl, Trigger rotateAngleRTF){
        rotateAngleRTF.toggleWhenActive(new RotateToAngleRTF(yawControl, ()-> 0));
    }
}
