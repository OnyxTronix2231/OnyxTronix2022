package frc.robot.drivetrain.autonomousPaths;

public class PathBlueFarClimberThreeBalls extends AbstractPath{

    static final double X_DESTINATION_MIDDLE_POINT = 6.605;
    static final double X_SECOND_BALL = 5.03;

    static final double Y_DESTINATION_MIDDLE_POINT = 1.595;
    static final double Y_SECOND_BALL = 1.662;

    static final double MIDDLE_DESTINATION_POINT_DEGREE = -170;
    static final double DESTINATION_DEGREE = 180;

    static final double MAX_VELOCITY_METERS_PER_SECOND = 2;
    static final double MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ = 2;

    public PathBlueFarClimberThreeBalls(){
        addPath(X_DESTINATION_MIDDLE_POINT,Y_DESTINATION_MIDDLE_POINT,MIDDLE_DESTINATION_POINT_DEGREE,
                MAX_VELOCITY_METERS_PER_SECOND, MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
        addPath(X_SECOND_BALL, Y_SECOND_BALL, DESTINATION_DEGREE, MAX_VELOCITY_METERS_PER_SECOND,
               MAX_CENTRIPETAL_ACCELERATION_METERS_PER_SECOND_SQ);
    }
}
