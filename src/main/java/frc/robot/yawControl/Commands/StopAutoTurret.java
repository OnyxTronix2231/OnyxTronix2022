package frc.robot.yawControl.Commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.yawControl.YawControl;

public class StopAutoTurret {

    public StopAutoTurret(YawControl yawControl){
        yawControl.setDefaultCommand(new InstantCommand());
    }
}