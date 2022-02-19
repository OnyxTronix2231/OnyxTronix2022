package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj.drive.Vector2dEx;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.vision.Vector2dEx;
import frc.robot.yawControl.YawControl;

public class ShootWhileDrivingCalc {

    private final DriveTrain drivetrain;
    private final Shooter shooter;
    private final Arc arc;
    private final YawControl yawControl;

    public ShootWhileDrivingCalc
            (DriveTrain drivetrain, Shooter shooter, Arc arc, YawControl yawControl) {
        this.drivetrain = drivetrain;
        this.shooter = shooter;
        this.arc = arc;
        this.yawControl = yawControl;
    }

    public Vector2dEx getShooterOnlyVector() {
        /**the vector that represents the first movement of the ball in the air (from the side)

        robot   ^             hub
               /            \     /
           /\ /              \_ _/
        __|_|                |   |
        \---/                |   |
        ______________________________floor

        * magnitude -> speed of the shooting system (m/s)
        * direction -> arc's direction (deg)*/

        double magnitude = shooter.getNeededSpeed();
        double direction = arc.getNeededDirection();
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    public Vector2dEx getXZVector() {
        /**the vector that represents the horizontal movement of the ball (from the top)

        robot                 hub

        /---\                _---_
        |()-+--->           {     }
        \---/                -___-

        * magnitude -> horizontal speed of shooting system (m/s)
        * direction -> turret's direction*/

        double magnitude = getShooterOnlyVector().x;
        double direction = yawControl.getAngleToTargetByPose();
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    public Vector2dEx getMovementVector() {
        /**the vector that represents the movement of the robot (from the top)

        robot                   hub
                _->
        /---\_--               _---_
        |() |                 {     }
        \---/                  -___-

        * magnitude -> speed of the robot (m/s)
        * direction -> robot's direction*/

        double magnitude = drivetrain.getCorrectRobotSpeed();
        double direction = drivetrain.getHeading();
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    public Vector2dEx getCorrectTrajectory() {
        /**the vector that represents the fixed horizontal movement of the ball (from the top)
        it is fixed according to the movement of the whole robot

        robot   ^               hub
               /
        /---\/                 _---_
        |()-+                 {     }
        \---/                  -___-

        * magnitude -> new & fixed horizontal speed of shooting system (m/s)
        * direction -> new & fixed turret's direction*/

        Vector2dEx turretVector = getXZVector();
        Vector2dEx movementVector = getMovementVector();
        turretVector.subtract(movementVector);
        return turretVector.clone();
    }

    public Vector2dEx getFixedShootingVector() {
        /**the vector that represents the fixed movement of the ball in the air (from the side)
        it is fixed by the changed horizontal vector

        robot   ^             hub
               /            \     /
           /\ /              \_ _/
        __|_|                |   |
        \---/                |   |
        ______________________________floor

        * magnitude -> fixed speed of the shooting system (m/s)
        * direction -> fixed arc's direction (deg)*/

        double x = getCorrectTrajectory().magnitude();
        double y = getShooterOnlyVector().y;
        return new Vector2dEx(x, y);
    }

    public double getTurretFixedDirection() {
        Vector2dEx correctVector = getCorrectTrajectory();
        return correctVector.direction();
    }

    public double getShooterFixedSpeedMPS() {
        return getFixedShootingVector().magnitude();
    }

    public double getArcFixedDirection() {
        Vector2dEx correctVector = getFixedShootingVector();
        return correctVector.direction();
    }
}
