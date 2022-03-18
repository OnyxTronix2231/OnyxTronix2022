package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;

public interface AutonomousPaths {
    Pose2d getStartPose();

    Path getPath(int pathNumber);
}
