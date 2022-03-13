package frc.robot.drivetrain.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;

public class ResetOdometryByKnownPose extends InstantCommand {

    private final DriveTrain driveTrain;
    private final Pose2d resetPose;

    public ResetOdometryByKnownPose(DriveTrain driveTrain, double x, double y, double degree) {
        this.driveTrain = driveTrain;
        resetPose = new Pose2d(x, y, Rotation2d.fromDegrees(degree));
    }

    @Override
    public void initialize() {
        driveTrain.resetOdometryToPose(resetPose);
    }
}
