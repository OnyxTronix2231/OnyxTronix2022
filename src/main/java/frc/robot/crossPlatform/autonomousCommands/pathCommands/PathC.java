package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;

import static frc.robot.drivetrain.DriveTrainConstants.Paths.PATH_C_ENEMY_BALL;
import static frc.robot.drivetrain.DriveTrainConstants.Paths.PATH_C_FIRST_BALL;

public class PathC extends SequentialCommandGroup {
    public PathC(DriveTrain driveTrain) {
        super(
                new MoveByPath(driveTrain, PATH_C_FIRST_BALL),
                //collecting the ball
                // shooting 2 balls
                new MoveByPath(driveTrain, PATH_C_ENEMY_BALL)
                //collecting enemy ball& shooting it away
        );
    }
}
