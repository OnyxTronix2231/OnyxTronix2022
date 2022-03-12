package frc.robot.vision;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class VisionShuffleboard {
    private final Vision vision;

    public VisionShuffleboard(Vision vision) {
        this.vision = vision;
    }

    public void init() {
        Shuffleboard.getTab("Vision").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Vision").addNumber("Angle RTT", vision::getHorizontalAngleTurretToTargetRTT);
        Shuffleboard.getTab("Vision").addNumber("X vision", ()->vision.getXAndYAuto().getX());
        Shuffleboard.getTab("Vision").addNumber("Y vision", ()->vision.getXAndYAuto().getY());
    }

    public void periodic(){}
}
