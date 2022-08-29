package frc.robot.yawControl;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;
import frc.robot.yawControl.Commands.RotateToAngleRTF;

import static frc.robot.Constants.TARGET_POSE_X;
import static frc.robot.Constants.TARGET_POSE_Y;
import static frc.robot.turret.TurretConstants.*;

public class YawControl extends Turret {

    private final DriveTrain driveTrain;

    public YawControl(TurretComponents turretComponents, DriveTrain driveTrain) {
        super(turretComponents);
        this.driveTrain = driveTrain;
        Shuffleboard.getTab("vision").addBoolean("is on target", this::isOnTarget);
    }

    public double getTurretAngleRTF() {
        return getCurrentAngleRTR() + driveTrain.getHeading();
    }

    public double getRTFToRTRAngle(double angleRTF) {
        return angleRTF - driveTrain.getHeading(); //TODO: find if rotating to same direction
    }

    public double getAngleRTRToTarget() {
        return getRTFToRTRAngle(driveTrain.getAngleToTargetByPose());
    }

    public double getAngleRTFToTarget() {
        return driveTrain.getAngleToTargetByPose();
    }
  
    public double getRobotAngleRTF(){
        return driveTrain.getHeading();
    }

    public double getAngleToEjectBall() {
        Pose2d currentPos = driveTrain.getPose();
        if (currentPos.getX() < TARGET_POSE_X) {
            return DRIVERS_DIRECTION;
        }
        if (currentPos.getY() < TARGET_POSE_Y) {
            return driveTrain.getAngleToAPose(P1);
        }
        return driveTrain.getAngleToAPose(P2);
    }

    public double getAngleToTargetSideRTF() {
        double angle = driveTrain.getAngleToTargetByPose();
        angle += Math.toDegrees(Math.atan(SIDE_TARGET_OFFSET / driveTrain.getDistanceFromTargetByEncoders()));
        return angle;
    }
}