package frc.robot.drivetrain.autonomousPaths;

public class PathBlueFarClimberFourBalls extends AbstractPath{

    static final double X_START_POSE = 7.606;
    static final double X_BALL_POSE = 1.544;
    static final double X_SHOOTING_POSE = 4.67;

    static final double Y_START_POSE = 2.050;
    static final double Y_BALL_POSE = 0.965;
    static final double Y_SHOOTING_POSE = 2.798;

    static final double START_DEGREE = 90;
    static final double DESTINATION_DEGREE = -29;
    static final double SHOOTING_DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueFarClimberFourBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_BALL_POSE,Y_BALL_POSE,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPath(X_SHOOTING_POSE, Y_SHOOTING_POSE, SHOOTING_DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
