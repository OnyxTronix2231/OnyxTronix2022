package frc.robot.vision;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class VisionShuffleboard {
    private Vision vision;
    private NetworkTableEntry angle;

    public VisionShuffleboard(Vision vision){
        this.vision = vision;
    }

    public void init(){
        Shuffleboard.getTab("Vision").addNumber("Distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Vision").addNumber("Angle", vision::getHorizontalAngleTurretToTargetRTT);
        angle = Shuffleboard.getTab("Vision").add("angleIn", 0 ).getEntry();
    }
}
