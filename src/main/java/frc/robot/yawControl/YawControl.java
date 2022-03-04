package frc.robot.yawControl;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;

import static frc.robot.Constants.*;
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

    public double getAngleToAPose(Pose2d pose2d){
        Pose2d currentPos = driveTrain.getPose();
        double angle = Math.toDegrees(Math.atan(-(currentPos.getY() - pose2d.getY()) /
                (currentPos.getX() - pose2d.getX())));
        if (currentPos.getX() > pose2d.getX())
            angle += DEG_IN_HALF_CIRCLE;
        return angle;
    }

    public double getAngleToTargetByPose() {
        return getAngleToAPose(new Pose2d(TARGET_POSE_X, TARGET_POSE_Y, new Rotation2d()));
    }

    public double getAngleToEjectBall(){
        Pose2d currentPos = driveTrain.getPose();
        if (currentPos.getX() < TARGET_POSE_X){
            return DRIVERS_DIRECTION;
        } if (currentPos.getY() < TARGET_POSE_Y){
            return getAngleToAPose(P1);
        } return getAngleToAPose(P2);
    }

    public double getAngleToTargetSideRTF(){
        double angle = getAngleToTargetByPose();
        angle += Math.toDegrees(Math.atan(SIDE_TARGET_OFFSET / driveTrain.getDistanceFromTargetByEncoders()));
        return angle;
    }
}
