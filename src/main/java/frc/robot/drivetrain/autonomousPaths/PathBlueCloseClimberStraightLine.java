package frc.robot.drivetrain.autonomousPaths;

public class PathBlueCloseClimberStraightLine extends AbstractPath {
    private static final double X_START_POSE= 6.29;
    private static final double X_FIRST_POINT = 4.468;

    private static final double Y_START_POSE = 3.912;
    private static final double Y_FIRST_POINT = 3.979;

    static final double START_DEGREE = 0;
    static final double DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueCloseClimberStraightLine() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_FIRST_POINT,Y_FIRST_POINT,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
