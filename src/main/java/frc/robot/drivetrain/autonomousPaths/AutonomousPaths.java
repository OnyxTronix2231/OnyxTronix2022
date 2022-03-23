package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;

public interface AutonomousPaths {

    void addPath(double x, double y, double degree, double maxVelocityConstraint, double accelerationConstraint);

    void setStartPose(double x, double y, double degree);

    Pose2d getStartPose();

    Path getPath(int pathNumber);
}
