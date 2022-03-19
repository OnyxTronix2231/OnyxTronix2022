package frc.robot.drivetrain.autonomousPaths;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.drivetrain.Path;

import java.util.ArrayList;

public abstract class AbstractPath implements AutonomousPaths {

    protected ArrayList<Path> paths = new ArrayList<>();
    protected Pose2d startPose;

    @Override
    public Pose2d getStartPose() {
        return startPose;
    }

    @Override
    public Path getPath(int pathNumber){
        return paths.get(pathNumber - 1);
    }
}
