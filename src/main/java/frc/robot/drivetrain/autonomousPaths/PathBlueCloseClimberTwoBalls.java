package frc.robot.drivetrain.autonomousPaths;

public class PathBlueCloseClimberTwoBalls extends AbstractPath { // CHECKED

    static final double X_START_POSE = 6.121;
    static final double X_FIRST_BALL = 5.3;

    static final double Y_START_POSE = 5.565;
    static final double Y_FIRST_BALL = 6.015;

    static final double START_DEGREE = -40;
    static final double DESTINATION_DEGREE = -40;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueCloseClimberTwoBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPathReverse(X_FIRST_BALL,Y_FIRST_BALL,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
