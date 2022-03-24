package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberThreeBalls extends  AbstractPath { // CHECKED

    static final double X_DESTINATION_MIDDLE_POINT = 10.102;
    static final double X_POSE_BALL = 11.193;

    static final double Y_DESTINATION_MIDDLE_POINT = 6.813;
    static final double Y_POSE_BALL = 6.386;

    static final double DESTINATION_MIDDLE_POINT_DEGREE = -35; // TODO CHECK
    static final double DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberThreeBalls(){
        addPathWithMiddlePoint(X_POSE_BALL, Y_POSE_BALL, DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ, X_DESTINATION_MIDDLE_POINT, Y_DESTINATION_MIDDLE_POINT);
    }
}
