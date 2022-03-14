package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class VisionShuffleboard {
    private final Vision vision;

    public VisionShuffleboard(Vision vision) {
        this.vision = vision;
    }

    public void init() {
        Shuffleboard.getTab("odo").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("odo").addNumber("Angle RTT", vision::getHorizontalAngleTurretToTargetRTT);
    }

    public void periodic(){}
}
