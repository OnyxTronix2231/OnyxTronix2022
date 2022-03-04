package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.PATH_B_FIRST_BALL;
import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.PATH_B_SECOND_BALL;

public class UpperTwoBalls extends SequentialCommandGroup {

    public UpperTwoBalls(DriveTrain driveTrain) {
        super(
                new ResetOdometryToPose(driveTrain, PathCommandsConstants.StartPoses.START_POSE_B),
                new MoveByPath(driveTrain, PATH_B_FIRST_BALL),
                // TODO: collecting the ball
                // TODO: shooting 2 balls
                new MoveByPath(driveTrain, PATH_B_SECOND_BALL)
                // TODO: collecting&shooting
        );
    }
}
