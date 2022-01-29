package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.*;

public class TestCommand extends SequentialCommandGroup {

     public TestCommand(DriveTrain driveTrain){
         super(
                 new MoveByPath(driveTrain, PATH_1)
         );
     }

}
