package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.trajectory.constraint.CentripetalAccelerationConstraint;
import edu.wpi.first.math.trajectory.constraint.MaxVelocityConstraint;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;
import java.util.List;

public class PathBlueUpperThreeBalls implements AutonomousPaths{

    static final double X_SECOND_BALL = 5.3;

    static final double Y_SECOND_BALL = 1.707;

    private final Path firstPath;

    ArrayList<Path> paths;

    public PathBlueUpperThreeBalls(){
       firstPath =  new Path(
               List.of(),
               new Pose2d(X_SECOND_BALL, Y_SECOND_BALL, Rotation2d.fromDegrees(180)),
               new MaxVelocityConstraint(2),
               new CentripetalAccelerationConstraint(2)
       );
       paths.add(firstPath);
    }
    @Override
    public Pose2d getStartPose() {
        return null;
    }

    @Override
    public Path getPath(int pathNumber){
        return paths.get(pathNumber - 1);
    }
}
