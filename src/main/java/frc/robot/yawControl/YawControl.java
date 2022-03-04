package frc.robot.yawControl;

import frc.robot.drivetrain.DriveTrain;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;

public class YawControl extends Turret {

    private final DriveTrain driveTrain;

    public YawControl(TurretComponents turretComponents, DriveTrain driveTrain) {
        super(turretComponents);
        this.driveTrain = driveTrain;
    }

    public double getTurretAngleRTF() {
        return getCurrentAngleRTR() - driveTrain.getHeading();
    }

    public double getRTFToRTRAngle(double angleRTF) {
        return angleRTF + driveTrain.getHeading(); //TODO: find if rotating to same direction
    }

    public double getAngleRTRToTarget() {
        return getRTFToRTRAngle(driveTrain.getAngleToTargetByPose());
    }
}
