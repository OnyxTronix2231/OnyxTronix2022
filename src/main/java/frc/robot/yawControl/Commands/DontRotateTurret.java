package frc.robot.yawControl.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.yawControl.YawControl;

public class DontRotateTurret extends CommandBase {

    public DontRotateTurret(YawControl yawControl) {
        addRequirements(yawControl);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
