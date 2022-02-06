package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.turret.Turret;
import frc.robot.yawControll.YawControl;
import vision.limelight.Limelight;
import vision.limelight.target.LimelightTarget;
import static frc.robot.Constants.TARGET_X_RTF;
import static frc.robot.Constants.TARGET_Y_RTF;
import static frc.robot.vision.VisionConstants.*;


public class Vision extends SubsystemBase {

    private final Limelight limelight;
    private LimelightTarget limelightTarget;
    private Vector2dEx turretToTargetVectorRTT;

    public Vision() {
        super();
        Shuffleboard.getTab("Vision").addNumber("Angle RTT", this::getHorizontalAngelTurretToTargetRTT);
        this.limelight = Limelight.getInstance();
    }

    @Override
    public void periodic() {
        System.out.println(limelight.targetFound());
        this.limelightTarget = limelight.getTarget();
        updateTurretToTargetVectorRTT();
    }

    private double getDistanceLimelightFromTarget() {
        if (limelight.targetFound()) {
            double verticalAngleLimelightToTarget = limelightTarget.getVerticalOffsetToCrosshair();
            double verticalAngleRobotToTarget = LIMELIGHT_ANGLE_TO_HORIZON_DEG + verticalAngleLimelightToTarget;
            return LIMELIGHT_TO_TARGET_CM / Math.tan(Math.toRadians(verticalAngleRobotToTarget));
        }
        return -999;
    }

    private void updateTurretToTargetVectorRTT() {
        if (limelight.targetFound()) {
            double limelightOffsetFromTarget = limelightTarget.getHorizontalOffsetToCrosshair();
            Vector2dEx limelightToTurret = Vector2dEx.fromMagnitudeDirection(LIMELIGHT_TO_TURRET_CM, 0);
            turretToTargetVectorRTT = Vector2dEx.fromMagnitudeDirection(getDistanceLimelightFromTarget(),
                    limelightOffsetFromTarget);
            turretToTargetVectorRTT.add(limelightToTurret); //TODO: might be sub
        } else {
            turretToTargetVectorRTT = null;
        }
    }

    public double getHorizontalAngelTurretToTargetRTT() {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.direction();
        return -999;
    }

    public double getHorizontalAngelTurretToTargetRTR(Turret turret) {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.direction() + turret.getAngleRTR();
        return -999;
    }

    public double getHorizontalDistanceTurretToTarget() {
        if (turretToTargetVectorRTT != null)
            return turretToTargetVectorRTT.magnitude();
        return -999;
    }

    public boolean hasTarget() {
        return limelight.targetFound();
    }

    public double getRobotToTargetAngleRTF(YawControl yawControl) {
        double horizontalAngelTurretToTargetRTT = getHorizontalAngelTurretToTargetRTT();
        return horizontalAngelTurretToTargetRTT + yawControl.getTurretAngleRTF();
    }

    public Translation2d getXAndY(YawControl yawControl) {
        double robotToTargetAngleRTF = getRobotToTargetAngleRTF(yawControl);
        double x = TARGET_X_RTF - Math.cos(Math.toRadians(robotToTargetAngleRTF));
        double y = TARGET_Y_RTF - Math.sin(Math.toRadians(robotToTargetAngleRTF));
        return new Translation2d(x, y);
    }
}
