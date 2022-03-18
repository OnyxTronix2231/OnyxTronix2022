package frc.robot.drivetrain.commands;

import frc.robot.drivetrain.DriveTrain;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class ResetOdometryToKnownPoseBlue extends ResetOdometryByKnownPose {

    public ResetOdometryToKnownPoseBlue(DriveTrain driveTrain) {
        super(driveTrain, LAUNCH_PAD_POSITION_BLUE_X, LAUNCH_PAD_POSITION_BLUE_Y, LAUNCH_PAD_BLUE_DEGREE);
    }
}
