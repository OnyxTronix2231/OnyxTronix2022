package frc.robot.drivetrain.commands;

import frc.robot.drivetrain.DriveTrain;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class ResetOdometryToKnownPoseRed extends ResetOdometryByKnownPose {

    public ResetOdometryToKnownPoseRed(DriveTrain driveTrain) {
        super(driveTrain, LAUNCH_PAD_POSITION_RED_X, LAUNCH_PAD_POSITION_RED_Y, LAUNCH_PAD_RED_DEGREE);
    }
}
