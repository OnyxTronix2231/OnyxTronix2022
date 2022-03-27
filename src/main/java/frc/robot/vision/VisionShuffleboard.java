package frc.robot.vision;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.yawControl.YawControl;

public class VisionShuffleboard {

    private final Vision vision;

    public VisionShuffleboard(Vision vision) {
        this.vision = vision;
    }

    public void init() {
        Shuffleboard.getTab("shoot").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("shoot").addNumber("Angle RTT", vision::getHorizontalAngleTurretToTargetRTT);
    }
}
