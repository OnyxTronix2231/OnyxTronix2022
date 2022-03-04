package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

import static frc.robot.crossPlatform.autonomousCommands.pathCommands.PathCommandsConstants.Paths.PATH_D_FIRST_BALL;

public class LowOneBall extends SequentialCommandGroup {

    public LowOneBall(DriveTrain driveTrain) {
        super(
                new ResetOdometryToPose(driveTrain, PathCommandsConstants.StartPoses.START_POSE_D),
                new MoveByPath(driveTrain, PATH_D_FIRST_BALL)
                // TODO: collecting the ball
                // TODO: shooting the 2 balls
        );
    }
}
