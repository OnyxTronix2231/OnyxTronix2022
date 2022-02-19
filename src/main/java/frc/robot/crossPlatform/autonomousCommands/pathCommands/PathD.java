package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.Path;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.PATH_D_FIRST_BALL;

public class PathD extends SequentialCommandGroup {
    public PathD(DriveTrain driveTrain) {
        super(
                new MoveByPath(driveTrain, PATH_D_FIRST_BALL)
                //collecting the ball
                //shooting the 2 balls
        );
    }
}
