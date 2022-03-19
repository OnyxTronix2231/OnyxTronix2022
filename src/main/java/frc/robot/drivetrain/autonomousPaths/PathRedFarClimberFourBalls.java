package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberFourBalls extends AbstractPath {

    static final double X_START_POSE = 8.943985451508386;
    static final double X_BALL_POSE = 15.073;
    static final double X_SHOOTING_POSE = 12.329;

    static final double Y_START_POSE = 6.15;
    static final double Y_BALL_POSE = 7.330;
    static final double Y_SHOOTING_POSE = 5.497;

    static final double START_DEGREE = -90;
    static final double DESTINATION_DEGREE = 29;
    static final double SHOOTING_DESTINATION_DEGREE = 180;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberFourBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
        addPath(X_BALL_POSE,Y_BALL_POSE,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);

        addPath(X_SHOOTING_POSE, Y_SHOOTING_POSE, SHOOTING_DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
