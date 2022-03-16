package frc.robot.vision;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class VisionShuffleboard {
    private final Vision vision;

    public VisionShuffleboard(Vision vision) {
        this.vision = vision;
    }

    public void init() {
        Shuffleboard.getTab("Vision").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Vision").addNumber("Angle RTT", vision::getHorizontalAngleTurretToTargetRTT);
    }
}
