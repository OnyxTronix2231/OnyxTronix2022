package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.DriveByDistance;

public class DriverDriveTrainOiBinders {

        public DriverDriveTrainOiBinders(DriveTrain driveTrain, Trigger button){
            button.whenActive(new DriveByDistance(driveTrain, ()-> 1));
        }
    
}
