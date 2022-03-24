package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPath implements AutonomousPaths {

    protected ArrayList<Path> paths = new ArrayList<>();
    protected ArrayList<Path> pathReversed = new ArrayList<>();
    protected Pose2d startPose;

    @Override
    public void addPath(double x, double y, double degree, double maxVelocityConstraint, double accelerationConstraint) {
        paths.add(new Path(
                List.of(),
                new Pose2d(x, y, Rotation2d.fromDegrees(degree)),
                new MaxVelocityConstraint(maxVelocityConstraint),
                new CentripetalAccelerationConstraint(accelerationConstraint)
        ));
    }

    public void addPathReverse(double x, double y, double degree, double maxVelocityConstraint, double accelerationConstraint) {
        paths.add(new Path(
                List.of(),
                new Pose2d(x, y, Rotation2d.fromDegrees(degree)),
                new MaxVelocityConstraint(maxVelocityConstraint),
                new CentripetalAccelerationConstraint(accelerationConstraint)
        ).setReversed());
    }

    public void addPathWithMiddlePoint(double x, double y, double degree, double maxVelocityConstraint,
                                       double accelerationConstraint, double XMiddlePoint, double YMiddlePoint) {
        paths.add(new Path(
                List.of(new Translation2d(XMiddlePoint, YMiddlePoint)),
                new Pose2d(x, y, Rotation2d.fromDegrees(degree)),
                new MaxVelocityConstraint(maxVelocityConstraint),
                new CentripetalAccelerationConstraint(accelerationConstraint)
        ));
    }

    @Override
    public void setStartPose(double x, double y, double degree) {
        startPose = new Pose2d(x, y,
                Rotation2d.fromDegrees(degree));
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
