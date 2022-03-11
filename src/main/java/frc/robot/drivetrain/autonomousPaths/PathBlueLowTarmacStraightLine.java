package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public class PathBlueLowTarmacStraightLine implements AutonomousPaths {
    private static final double X_START_POSE= 6.29;
    private static final double X_FIRST_POINT = 4.468;

    private static final double Y_START_POSE = 3.912;
    private static final double Y_FIRST_POINT = 3.979;

    private final Pose2d startPose;
    private final Path firstPath;

    ArrayList<Path> paths;

    public PathBlueLowTarmacStraightLine() {
        paths = new ArrayList<>();
        startPose = new Pose2d(X_START_POSE, Y_START_POSE,
                Rotation2d.fromDegrees(180));
        firstPath = new Path(
                List.of(),
                new Pose2d(X_FIRST_POINT, Y_FIRST_POINT, Rotation2d.fromDegrees(180)),
                new MaxVelocityConstraint(2),
                new CentripetalAccelerationConstraint(2)
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
