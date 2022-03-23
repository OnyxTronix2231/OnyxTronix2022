package frc.robot.drivetrain;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.drivetrain.commands.ResetOdometryByKnownPoseByAlliance;

public class DeputyDriveTrainOiBinder {

    public DeputyDriveTrainOiBinder(DriveTrain driveTrain, Trigger resetPoseByOdometry) {
        resetPoseByOdometry.whenActive(new ResetOdometryByKnownPoseByAlliance(driveTrain));
    }
}
