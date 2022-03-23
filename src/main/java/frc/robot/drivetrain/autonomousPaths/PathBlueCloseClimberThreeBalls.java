package frc.robot.drivetrain.autonomousPaths;

public class PathBlueCloseClimberThreeBalls extends AbstractPath{

    static final double X_START_POSE = 6.571;
    static final double X_FIRST_BALL = 1.24;

    static final double Y_START_POSE = 5.306;
    static final double Y_FIRST_BALL = 1.505;

    static final double START_DEGREE = -30;
    static final double DESTINATION_DEGREE = -160;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueCloseClimberThreeBalls() {

        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_FIRST_BALL,Y_FIRST_BALL,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}

