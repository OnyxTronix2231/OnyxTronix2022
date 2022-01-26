package frc.robot.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class TestCommand extends SequentialCommandGroup {

    public TestCommand(DriveTrain driveTrain){
        super(
                new MoveByPath(driveTrain, Paths.PATH_1)
        );
    }
}
