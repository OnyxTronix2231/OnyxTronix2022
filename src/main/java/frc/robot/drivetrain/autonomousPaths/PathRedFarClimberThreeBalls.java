package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberThreeBalls extends  AbstractPath { // CHECKED

    static final double X_FIRST_BALL = 8.943985451508386;
    static final double X_DESTINATION_MIDDLE_POINT = 10.069;
    static final double X_POSE_BALL = 11.519;

    static final double Y_FIRST_BALL = 7.54;
    static final double Y_DESTINATION_MIDDLE_POINT = 6.971;
    static final double Y_POSE_BALL = 6;

    static final double DESTINATION_FIRST_DEGREE = -90;
    static final double DESTINATION_MIDDLE_POINT_DEGREE = -35; // TODO CHECK
    static final double DESTINATION_DEGREE = 37;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberThreeBalls(){
        addPathReverse(X_FIRST_BALL, Y_FIRST_BALL, DESTINATION_FIRST_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPathWithMiddlePoint(X_POSE_BALL, Y_POSE_BALL, DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ, X_DESTINATION_MIDDLE_POINT, Y_DESTINATION_MIDDLE_POINT);
    }
}
