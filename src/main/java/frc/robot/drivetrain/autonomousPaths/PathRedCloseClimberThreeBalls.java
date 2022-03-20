package frc.robot.drivetrain.autonomousPaths;

public class PathRedCloseClimberThreeBalls extends AbstractPath {

    static final double X_START_POSE = 10;
    static final double X_POSE_BALL = 15.321;

    static final double Y_START_POSE = 3;
    static final double Y_POSE_BALL = 6.993;

    static final double START_DEGREE = 30.591;
    static final double DESTINATION_DEGREE = 45;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedCloseClimberThreeBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_POSE_BALL,Y_POSE_BALL,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
