package frc.robot.drivetrain.autonomousPaths;

public class PathBlueCloseClimberTwoBalls extends AbstractPath {

    static final double X_START_POSE = 6.571;
    static final double X_FIRST_BALL = 4.715;

    static final double Y_START_POSE = 5.306;
    static final double Y_FIRST_BALL = 6.419;

    static final double START_DEGREE = -140;
    static final double DESTINATION_DEGREE = -140;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueCloseClimberTwoBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPathReverse(X_FIRST_BALL,Y_FIRST_BALL,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
