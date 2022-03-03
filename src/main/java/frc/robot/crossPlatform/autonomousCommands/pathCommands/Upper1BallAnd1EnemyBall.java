package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.*;

public class Upper1BallAnd1EnemyBall extends SequentialCommandGroup {

    public Upper1BallAnd1EnemyBall(DriveTrain driveTrain) {
        super(
                new ResetOdometryToPose(driveTrain, PathCommandsConstants.StartPoses.START_POSE_C),
                new MoveByPath(driveTrain, PATH_C_FIRST_BALL),
                // TODO: collecting the ball
                // TODO: shooting 2 balls
                new MoveByPath(driveTrain, PATH_C_ENEMY_BALL)
                // TODO: collecting enemy ball& shooting it away
        );
    }
}
