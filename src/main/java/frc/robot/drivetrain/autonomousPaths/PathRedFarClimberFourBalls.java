package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberFourBalls extends AbstractPath { // CHECKED

//    static final double X_DESTINATION_MIDDLE_THIRD_POINT = 10.069;
//    static final double X_POSE_THIRD_BALL = 11.519;
    static final double X_BALL_POSE = 15.051;
    static final double X_SHOOTING_POSE = 12.87;

//    static final double Y_DESTINATION_MIDDLE_THIRD_POINT = 6.971;
//    static final double Y_POSE_THIRD_BALL = 6.779;
    static final double Y_BALL_POSE = 7.4;
    static final double Y_SHOOTING_POSE = 6.926;

    //static final double DESTINATION_DEGREE_THREE = 30;
    static final double DESTINATION_DEGREE = 29; // TODO, CHECK WITH BLUE AND DO -180
    static final double SHOOTING_DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberFourBalls() {
//        addPathWithMiddlePoint(X_POSE_THIRD_BALL, Y_POSE_THIRD_BALL, DESTINATION_DEGREE_THREE, MAX_VELOCITY_METERS_PER_SECOND,
//                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ, X_DESTINATION_MIDDLE_THIRD_POINT,
//                Y_DESTINATION_MIDDLE_THIRD_POINT);
        addPath(X_BALL_POSE,Y_BALL_POSE,DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPathReverse(X_SHOOTING_POSE, Y_SHOOTING_POSE, SHOOTING_DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
