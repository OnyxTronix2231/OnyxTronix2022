package frc.robot.drivetrain.autonomousPaths;

public class PathBlueFarClimberTwoBalls extends AbstractPath {

    static final double X_START_POSE = 7.606;
    static final double X_FIRST_BALL = 7.606;

    static final double Y_START_POSE = 2.050;
    static final double Y_FIRST_BALL = 0.55;

    static final double START_DEGREE = 90;
    static final double DESTINATION_DEGREE = 90;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueFarClimberTwoBalls(){
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_FIRST_BALL,Y_FIRST_BALL,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
