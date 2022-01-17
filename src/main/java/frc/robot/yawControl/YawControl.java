package frc.robot.yawControl;

import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;

public class YawControl extends Turret {

    private DriveTrain driveTrain;

    public YawControl(TurretComponents turretComponents, DriveTrain driveTrain) {
        super(turretComponents);
        this.driveTrain = driveTrain;
    }
    public double getTurretAngleRTF () {
        return Math.abs(getCurrentAngle() - driveTrain.getRobotAngle());
    }

    public double getAngleRTRToFixAngleRTF( double angleRTF) {
        // this func is correct if both systems enlarge the angle by rotating to the same side
        return angleRTF - driveTrain.getRobotAngle();
    }
}
