package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberFourBalls extends AbstractPath { // CHECKED

    static final double X_BALL_POSE = 15.208;
    static final double X_SHOOTING_POSE = 11.699;

    static final double Y_BALL_POSE = 6.982;
    static final double Y_SHOOTING_POSE = 6.836;

    static final double DESTINATION_DEGREE = 29; // TODO, CHECK WITH BLUE AND DO -180
    static final double SHOOTING_DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberFourBalls() {
        addPath(X_BALL_POSE,Y_BALL_POSE,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPathReverse(X_SHOOTING_POSE, Y_SHOOTING_POSE, SHOOTING_DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
