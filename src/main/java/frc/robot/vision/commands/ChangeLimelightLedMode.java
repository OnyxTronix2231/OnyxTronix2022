package frc.robot.vision.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.vision.Vision;
import vision.limelight.enums.LimelightLedMode;

public class ChangeLimelightLedMode extends InstantCommand {

    public ChangeLimelightLedMode(Vision vision, LimelightLedMode limelightLedMode) {
        super(() -> vision.setLedMode(limelightLedMode));
    }
}
