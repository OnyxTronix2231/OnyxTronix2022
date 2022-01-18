package frc.robot.drivetrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.TrajectoryConstraint;


import java.util.Arrays;
import java.util.List;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class Path {
    private final Pose2d startPose;
    private final List<Translation2d> middlePoints;
    private final Pose2d endPose;
    private final TrajectoryConfig config;

    public Path(Pose2d startPose, List<Translation2d> middlePoints, Pose2d endPose,
                TrajectoryConstraint... constraints) {
        this.startPose = startPose;
        this.middlePoints = middlePoints;
        this.endPose = endPose;
        this.config = new TrajectoryConfig(MAX_SPEED_METERS_PER_SECOND, MAX_ACCELERATION_METERS_PER_SECOND_SQUARED)
                .setKinematics(DRIVE_KINEMATICS)
                .addConstraints(Arrays.asList(constraints));
    }

    public Pose2d getStartPose() {
        return startPose;
    }

    public Pose2d getEndPose() {
        return endPose;
    }

    public Path setReversed() {
        config.setReversed(true);
        return this;
    }

    public Trajectory toTrajectory(Pose2d startPose) {
        return TrajectoryGenerator.generateTrajectory(startPose, middlePoints, endPose, config);
    }

    public Trajectory toTrajectory() {
        return toTrajectory(startPose);
    }
}
