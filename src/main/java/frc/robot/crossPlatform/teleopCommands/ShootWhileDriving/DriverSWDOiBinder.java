package frc.robot.crossPlatform.teleopCommands.ShootWhileDriving;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arc.Arc;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.yawControl.YawControl;

public class DriverSWDOiBinder {

    public DriverSWDOiBinder(DriveTrain driveTrain, YawControl yawControl, Shooter shooter, Arc arc, Trigger swd) {
        ShootWhileDrivingCalc swdCalc = new ShootWhileDrivingCalc(driveTrain);
        swd.whileActiveContinuous(new ShootWhileDrivingCmd(yawControl, arc, shooter, swdCalc));
    }
}
