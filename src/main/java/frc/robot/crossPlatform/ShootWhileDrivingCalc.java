package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.robot.yawControl.YawControl;

public class ShootWhileDrivingCalc {

    private final DriveTrain drivetrain;
    private final Vision vision;
    private final Shooter shooter;
    private final Arc arc;
    private final YawControl yawControl;

    public ShootWhileDrivingCalc(DriveTrain drivetrain, Vision vision, Shooter shooter, Arc arc, YawControl yawControl) {
        this.drivetrain = drivetrain;
        this.vision = vision;
        this.shooter = shooter;
        this.arc = arc;
        this.yawControl = yawControl;
    }

    public static Vector2d getShooterOnly2DVector() {

        return null;
    }

    public static Vector2d getXZ2DVector() {

        return null;
    }

    public static double getTurretFixedAngle() {

        return 0;
    }

    public static double getShootertFixedSpeedMPS() {

        return 0;
    }

    public static double getShootertFixedAngle() {

        return 0;
    }


}
