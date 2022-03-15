package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public class PathBlueFarClimberFourBalls implements AutonomousPaths{

    static final double X_START_POSE = 7.606;
    static final double X_BALL_POSE = 1.544;
    static final double X_SHOOTING_POSE = 4.67;

    static final double Y_START_POSE = 2.050;
    static final double Y_BALL_POSE = 0.965;
    static final double Y_SHOOTING_POSE = 2.798;

    static final double START_DEGREE = 90;
    static final double POSE_DEGREE = -29;
    static final double SHOOTING_POSE_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    private final Pose2d startPose;
    private final Path firstPath;
    private final Path shootingPlace;

    ArrayList<Path> paths = new ArrayList<>();

    public PathBlueFarClimberFourBalls() {
        startPose = new Pose2d(X_START_POSE, Y_START_POSE,
                Rotation2d.fromDegrees(START_DEGREE));

        firstPath = new Path(
                List.of(),
                new Pose2d(X_BALL_POSE, Y_BALL_POSE, Rotation2d.fromDegrees(POSE_DEGREE)),
                new MaxVelocityConstraint(MAX_VELOCITY_METERS_PER_SECOND),
                new CentripetalAccelerationConstraint(MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ)
        );
        paths.add(firstPath);

        shootingPlace = new Path(
                List.of(),
                new Pose2d(X_SHOOTING_POSE, Y_SHOOTING_POSE, Rotation2d.fromDegrees(SHOOTING_POSE_DEGREE)),
                new MaxVelocityConstraint(MAX_VELOCITY_METERS_PER_SECOND),
                new CentripetalAccelerationConstraint(MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ)
        );
        paths.add(shootingPlace);
    }

    @Override
    public Pose2d getStartPose() {
        return startPose;
    }

    @Override
    public Path getPath(int pathNumber) {
        return paths.get(pathNumber - 1);
    }
}
