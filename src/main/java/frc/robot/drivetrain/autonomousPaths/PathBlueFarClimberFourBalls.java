package frc.robot.drivetrain.autonomousPaths;

public class PathBlueFarClimberFourBalls extends AbstractPath { // CHECKED

    static final double X_START_POSE = 7.606; // TODO CHECK
    static final double X_BALL_POSE = 1.499;
    static final double X_SHOOTING_POSE = 5.12;

    static final double Y_START_POSE = 2.050; // TODO CHECK
    static final double Y_BALL_POSE = 1.156;
    static final double Y_SHOOTING_POSE = 1.471;

    static final double START_DEGREE = 90;
    static final double DESTINATION_DEGREE = -170; // TODO CHECK, LOOKS GOOD BUT NEEDS TESTING
    static final double SHOOTING_DESTINATION_DEGREE = 180; // TODO CHECK

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueFarClimberFourBalls() {
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE); // TODO CHECK
        addPath(X_BALL_POSE,Y_BALL_POSE,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPathReverse(X_SHOOTING_POSE, Y_SHOOTING_POSE, SHOOTING_DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
