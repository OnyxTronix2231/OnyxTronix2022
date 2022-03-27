package frc.robot.crossPlatform.teleopCommands.ShootWhileDriving;

import frc.robot.arc.Arc;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.shooter.Shooter;
import frc.robot.vision.Vector2dEx;
import frc.robot.yawControl.YawControl;

import static frc.robot.arc.ArcConstants.ArcCalculations.*;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.*;

public class ShootWhileDrivingCalc {

    private final DriveTrain drivetrain;

    public ShootWhileDrivingCalc(DriveTrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    /**
     * the vector that represents the first movement of the ball in the air (from the side)
     *
     * robot   ^             hub
     *        /            \     /
     *    /\ /              \_ _/
     * __|_|                |   |
     * \---/                |   |
     * ______________________________floor
     *
     * magnitude -> speed of the shooting system (m/s)
     * direction -> arc's direction (deg)
     */
    public Vector2dEx getShooterOnlyVector() {
        double distance = encUnitsDecisecToRPM(drivetrain.getDistanceFromTargetByEncoders());
        double magnitude = RPMToMPS((distanceToRPM(distance)));
        double direction = distanceToAngle(distance);
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    /**
     * the vector that represents the horizontal movement of the ball (from the top)
     *
     * robot                 hub
     *
     * /---\                _---_
     * |()-+--->           {     }
     * \---/                -___-
     *
     * magnitude -> horizontal speed of shooting system (m/s)
     * direction -> turret's direction
     */
    public Vector2dEx getXZVector() {
        double magnitude = getShooterOnlyVector().x;
        double direction = drivetrain.getAngleToTargetByPose();
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    /**
     * the vector that represents the movement of the robot (from the top)
     *
     * robot                   hub
     *          _->
     * /---\_--               _---_
     * |() |                 {     }
     * \---/                  -___-
     *
     * magnitude -> speed of the robot (m/s)
     * direction -> robot's direction
     */
    public Vector2dEx getMovementVector() {
        double magnitude = drivetrain.getRobotSpeedMPS();
        double direction = drivetrain.getHeading();
        return Vector2dEx.fromMagnitudeDirection(magnitude, direction);
    }

    /**
     * the vector that represents the fixed horizontal movement of the ball (from the top)
     * it is fixed according to the movement of the whole robot
     *
     * robot   ^               hub
     *        /
     * /---\/                 _---_
     * |()-+                 {     }
     * \---/                  -___-
     *
     * magnitude -> new & fixed horizontal speed of shooting system (m/s)
     * direction -> new & fixed turret's direction
     */

    public Vector2dEx getCorrectTrajectory() {
        Vector2dEx turretVector = getXZVector();
        Vector2dEx movementVector = getMovementVector();
        turretVector.add(movementVector);
        return turretVector.clone();
    }

    /**
     * the vector that represents the fixed movement of the ball in the air (from the side)
     * it is fixed by the changed horizontal vector
     *
     * robot   ^             hub
     *        /            \     /
     *    /\ /              \_ _/
     * __|_|                |   |
     * \---/                |   |
     * ______________________________floor
     *
     * magnitude -> fixed speed of the shooting system (m/s)
     * direction -> fixed arc's direction (deg)
     */
    public Vector2dEx getFixedShootingVector() {
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
