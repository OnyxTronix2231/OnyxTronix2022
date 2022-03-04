package frc.robot.yawControl;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;

import static frc.robot.turret.TurretConstants.*;

public class YawControl extends Turret {

    private final DriveTrain driveTrain;

    public YawControl(TurretComponents turretComponents, DriveTrain driveTrain) {
        super(turretComponents);
        this.driveTrain = driveTrain;
        Shuffleboard.getTab("Turret").addNumber("AngleRTF", this::getTurretAngleRTF);
    }

    public double getTurretAngleRTF() {
        return (getCurrentAngleRTR() - driveTrain.getHeading()) % DEG_IN_CIRCLE;
    }

    public double getRTFToRTRAngle(double angleRTF) {
        return angleRTF + driveTrain.getHeading(); //TODO: find if rotating to same direction
    }

    public double getAngleToTargetByPose() {
        Pose2d currentPos = driveTrain.getPose();
        double angle = Math.toDegrees(Math.atan(-(currentPos.getY() - TARGET_POS.getY()) /
                (currentPos.getX() - TARGET_POS.getX())));
        if (currentPos.getX() > TARGET_POS.getX())
            angle += DEG_IN_HALF_CIRCLE;
        return angle;
    }
}
