package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public class PathRedFarClimberTwoBalls implements AutonomousPaths{

    static final double X_START_POSE = 8.943985451508386;
    static final double X_FIRST_BALL = 8.943985451508386;

    static final double Y_START_POSE = 6.15;
    static final double Y_FIRST_BALL = 7.650;

    static final double START_DEGREE = -90;
    static final double SPOT_DEGREE = -90;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    private final Pose2d startPose;
    private final Path firstPath;

    ArrayList<Path> paths = new ArrayList<>();

    public PathRedFarClimberTwoBalls(){
        startPose = new Pose2d(X_START_POSE, Y_START_POSE,
                Rotation2d.fromDegrees(START_DEGREE));

        firstPath = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL, Y_FIRST_BALL, Rotation2d.fromDegrees(SPOT_DEGREE)),
                new MaxVelocityConstraint(MAX_VELOCITY_METERS_PER_SECOND),
                new CentripetalAccelerationConstraint(MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ)
        ).setReversed();
        paths.add(firstPath);
    }

    @Override
    public Pose2d getStartPose() {
        return startPose;
    }

    @Override
    public Path getPath(int pathNumber){
        return paths.get(pathNumber - 1);
    }
}
