package frc.robot.crossPlatform.autonomousCommands.pathCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.commands.MoveByPath;
import frc.robot.drivetrain.commands.ResetOdometryToPose;

public class MeterForwardTest extends SequentialCommandGroup {

    public MeterForwardTest(DriveTrain driveTrain) {
        super(
                new ResetOdometryToPose(driveTrain, new Pose2d(0,0, Rotation2d.fromDegrees(0))),
                new MoveByPath(driveTrain, PathCommandsConstants.Paths.METER_FORWARD)
        );
    }
}
