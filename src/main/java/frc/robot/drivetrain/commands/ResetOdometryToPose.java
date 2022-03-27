package frc.robot.drivetrain.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.drivetrain.DriveTrain;

public class ResetOdometryToPose extends CommandBase {

    private final DriveTrain driveTrain;
    private final Pose2d pose;


    public ResetOdometryToPose(DriveTrain driveTrain, Pose2d pose) {
        this.driveTrain = driveTrain;
        this.pose = pose;
    }

    @Override
    public void initialize() {
        driveTrain.resetOdometryToPose(pose);
    }

    @Override
    public boolean isFinished() {
        return driveTrain.isResetSucsessfuly();
    }
}
