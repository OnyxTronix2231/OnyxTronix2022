package frc.robot.vision;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.yawControl.YawControl;

public class VisionShuffleboard {

    private final Vision vision;

    public VisionShuffleboard(Vision vision) {
        this.vision = vision;
    }

    public void init() {
        Shuffleboard.getTab("vision").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("vision").addNumber("Angle", vision::getVerticalAngleOffset);
        Shuffleboard.getTab("vision").addNumber("Limelight Angle", vision::getLimelightVerticalAngle);
        Shuffleboard.getTab("vision").addNumber("middleTargetY", vision::getMiddleTargetY);
        Shuffleboard.getTab("vision").addNumber("normalizedMiddleTargetY", vision::getNormalizedMiddleTargetY);
        Shuffleboard.getTab("vision").addNumber("pixelMiddleTargetY", vision::getPixelMiddleTargetY);
        Shuffleboard.getTab("vision").addNumber("pixelTopTargetY", vision::getPixelTopTargetY);
        Shuffleboard.getTab("vision").addNumber("normalizedTopTargetY", vision::getNormalizedTopTargetY);
        Shuffleboard.getTab("vision").addNumber("topTargetY", vision::getTopTargetY);
    }
}
