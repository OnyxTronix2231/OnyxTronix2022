package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public class PathBlueCloseClimberThreeBalls implements AutonomousPaths{

    static final double X_START_POSE = 6.571;
    static final double X_FIRST_BALL = 1.24;

    static final double Y_START_POSE = 5.306;
    static final double Y_FIRST_BALL = 1.505;

    static final double START_DEGREE = -140;
    static final double DESTINATION_DEGREE = 120;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    private final Pose2d startPose;
    private final Path firstPath;

    ArrayList<Path> paths = new ArrayList<>();

    public PathBlueCloseClimberThreeBalls() {

        startPose = new Pose2d(X_START_POSE, Y_START_POSE, Rotation2d.fromDegrees(START_DEGREE));

        firstPath = new Path(
                List.of(),
                new Pose2d(X_FIRST_BALL, Y_FIRST_BALL, Rotation2d.fromDegrees(DESTINATION_DEGREE)),
                new MaxVelocityConstraint(MAX_VELOCITY_METERS_PER_SECOND),
                new CentripetalAccelerationConstraint(MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ)
        );
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

