package frc.robot.drivetrain.autonomousPaths;

public class PathRedFarClimberThreeBalls extends  AbstractPath {

    static final double X_START_POSE = 8.943985451508386;
    static final double X_DESTINATION_MIDDLE_POINT = 10.215;
    static final double X_POSE_BALL = 11.947;

    static final double Y_START_POSE = 6.15;
    static final double Y_DESTINATION_MIDDLE_POINT = 6.476;
    static final double Y_POSE_BALL = 6.419;

    static final double START_DEGREE = -90;
    static final double DESTINATION_MIDDLE_POINT_DEGREE = -10;
    static final double DESTINATION_DEGREE = 0;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathRedFarClimberThreeBalls(){
        setStartPose(X_START_POSE, Y_START_POSE, START_DEGREE);
      //  addPath(X_DESTINATION_MIDDLE_POINT,Y_DESTINATION_MIDDLE_POINT,DESTINATION_MIDDLE_POINT_DEGREE,
        //        MAX_VELOCITY_METERS_PER_SECOND, MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPath(X_POSE_BALL, Y_POSE_BALL, DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
                MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
