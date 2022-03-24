package frc.robot.crossPlatform.teleopCommands.OdometryUpdater;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import static frc.robot.crossPlatform.teleopCommands.OdometryUpdater.OdometryUpdaterConstants.*;

public class CalibrateAtStart extends SequentialCommandGroup {

    public CalibrateAtStart(DriveTrain driveTrain, YawControl yawControl, Vision vision) {
        super(
                new RotateByVision(yawControl, vision).withTimeout(VISION_FOCUS_TIME),
                new CalibrateCmd(new UpdateOdometryByVision(driveTrain, yawControl, vision))
        );
    }
}
