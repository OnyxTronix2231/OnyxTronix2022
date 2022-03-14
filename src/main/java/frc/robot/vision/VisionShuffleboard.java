package frc.robot.vision;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.yawControl.YawControl;

public class VisionShuffleboard {

    private final Vision vision;
    private final YawControl yawControl;

    public VisionShuffleboard(Vision vision, YawControl yawControl) {
        this.vision = vision;
        this.yawControl = yawControl;
    }

    public void init() {
        Shuffleboard.getTab("Vision").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Vision").addNumber("Angle RTT", vision::getHorizontalAngleTurretToTargetRTT);
        Shuffleboard.getTab("Vision").addNumber("X vision", ()->vision.getXAndYAuto(yawControl).getX());
        Shuffleboard.getTab("Vision").addNumber("Y vision", ()->vision.getXAndYAuto(yawControl).getY());
    }
}
