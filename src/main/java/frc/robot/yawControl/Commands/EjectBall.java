package frc.robot.yawControl.Commands;

import frc.robot.yawControl.YawControl;

public class EjectBall extends RotateToAngleRTF{

    public EjectBall(YawControl yawControl){
        super(yawControl, yawControl::getAngleToEjectBall);
    }
}
