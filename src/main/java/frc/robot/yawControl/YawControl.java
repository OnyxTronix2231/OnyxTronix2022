package frc.robot.yawControl;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;
import static frc.robot.turret.TurretConstants.*;

public class YawControl extends Turret {

    private final DriveTrain driveTrain;

    public YawControl(TurretComponents turretComponents, DriveTrain driveTrain) {
        super(turretComponents);
        this.driveTrain = driveTrain;
    }

    public double getTurretAngleRTF() {
        return Math.abs(getCurrentAngle() - driveTrain.getHeading());
    }

    public double getAngleRTRToFixAngleRTF( double angleRTF) {
        // this func is correct if both systems enlarge the angle by rotating to the same side
        return angleRTF - driveTrain.getHedding();
    }

    public double getAngleToTargetRTF(Pose2d currentPos) {
        double angle = Math.toDegrees(Math.atan((currentPos.getY() - TARGET_POS.getY())/
                (currentPos.getX() - TARGET_POS.getX())));
        if (currentPos.getX() > TARGET_POS.getX())
            angle += 180;
        return angle;
    }
}

