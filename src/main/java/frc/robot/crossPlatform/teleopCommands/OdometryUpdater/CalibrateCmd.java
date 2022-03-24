package frc.robot.crossPlatform.teleopCommands.OdometryUpdater;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class CalibrateCmd extends InstantCommand {

    public CalibrateCmd(UpdateOdometryByVision updateOdometryByVision) {
        super(updateOdometryByVision::updateOdometry);
    }
}
