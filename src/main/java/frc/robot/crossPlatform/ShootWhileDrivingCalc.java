package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.yawControl.YawControl;

public class ShootWhileDrivingCalc {

    private final DriveTrain drivetrain;
    private final Vision vision;
    private final Shooter shooter;
    private final Arc arc;
    private final YawControl yawControl;

    public ShootWhileDrivingCalc
            (DriveTrain drivetrain, Vision vision, Shooter shooter, Arc arc, YawControl yawControl) {
        this.drivetrain = drivetrain;
        this.vision = vision;
        this.shooter = shooter;
        this.arc = arc;
        this.yawControl = yawControl;
    }

    public Vector2d getShooterOnlyVector() {
        /**the vector that represents the first movement of the ball in the air (from the side)

        robot   ^             hub
               /            \     /
           /\ /              \_ _/
        __|_|                |   |
        \---/                |   |
        ______________________________floor

        * size -> speed of the shooting system (m/s)
        * direction -> arc's direction (deg)*/

        double size = shooter.getNeededSpeed();
        double direction = arc.getNeededdirection();
        double x = size * Math.cos(Math.toRadians(direction));
        double y = size * Math.sin(Math.toRadians(direction));
        return new Vector2d(x, y);
    }

    public Vector2d getXZVector() {
        /**the vector that represents the horizontal movement of the ball (from the top)

        robot                 hub

        /---\                _---_
        |()-+--->           {     }
        \---/                -___-

        * size -> horizontal speed of shooting system (m/s)
        * direction -> turret's direction*/

        double size = getShooterOnlyVector().x;
        double direction = yawControl.getdirectionNonVisionDependent(vision);
        double x = size * Math.cos(Math.toRadians(direction));
        double y = size * Math.sin(Math.toRadians(direction));
        return new Vector2d(x, y);
    }

    public Vector2d getMovementVector() {
        /**the vector that represents the movement of the robot (from the top)

        robot                   hub
                _->
        /---\_--               _---_
        |() |                 {     }
        \---/                  -___-

        * size -> speed of the robot (m/s)
        * direction -> robot's direction*/

        double size = drivetrain.getCorrectRobotSpeed();
        double direction = drivetrain.getHeading();
        double x = size * Math.cos(Math.toRadians(direction));
        double y = size * Math.sin(Math.toRadians(direction));
        return new Vector2d(x, y);
    }

    public Vector2d getCorrectTrajectory() {
        /**the vector that represents the fixed horizontal movement of the ball (from the top)
        it is fixed according to the movement of the whole robot

        robot   ^               hub
               /
        /---\/                 _---_
        |()-+                 {     }
        \---/                  -___-

        * size -> new & fixed horizontal speed of shooting system (m/s)
        * direction -> new & fixed turret's direction*/

        Vector2d turretVector = getXZVector();
        Vector2d movementVector = getMovementVector();
        return new Vector2d(turretVector.x - movementVector.x, turretVector.y - movementVector.y);
    }

    public Vector2d getFixedShootingVector() {
        /**the vector that represents the fixed movement of the ball in the air (from the side)
        it is fixed by the changed horizontal vector

        robot   ^             hub
               /            \     /
           /\ /              \_ _/
        __|_|                |   |
        \---/                |   |
        ______________________________floor

        * size -> fixed speed of the shooting system (m/s)
        * direction -> fixed arc's direction (deg)*/
        double x = getCorrectTrajectory().magnitude();
        double y = getShooterOnlyVector().y;
        return new Vector2d(x, y);
    }

    public double getTurretFixeddirection() {
        Vector2d correctVector = getCorrectTrajectory();
        return Math.toDegrees(Math.atan(correctVector.y / correctVector.x));
    }

    public double getShooterFixedSpeedMPS() {
        return getFixedShootingVector().magnitude();
    }

    public double getShooterFixedDirection() {
        Vector2d correctVector = getFixedShootingVector();
        return Math.toDegrees(Math.atan(correctVector.y / correctVector.x));
    }
}
