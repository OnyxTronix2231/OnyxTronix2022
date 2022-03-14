package frc.robot;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.Arc;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.Map;

public class DriversShuffleboard {

    public DriversShuffleboard(Vision vision, Shooter shooter, Arc arc, YawControl turret, HttpCamera limeLightFeed) {

        Shuffleboard.getTab("Main").addBoolean("Shooter is on Target", shooter::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Arc is on Target", arc::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Turret is on Target", turret::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Vision has Target", vision::hasTarget);

        Shuffleboard.getTab("Main").addNumber("vision distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Main").addNumber("vision angle", vision::getHorizontalAngleTurretToTargetRTT);
        Shuffleboard.getTab("Main").addNumber("shooter RPM", shooter::getCurrentRPM);
        Shuffleboard.getTab("Main").addNumber("arc angle", arc::getCurrentAngle);

        Shuffleboard.getTab("Main").add("LL", limeLightFeed).withProperties(
                Map.of("Show Crosshair", false, "Show Controls", false));

        Shuffleboard.getTab("odo").addNumber("vision x", () -> vision.getXAndYAuto(turret).getX());
        Shuffleboard.getTab("odo").addNumber("vision y", () -> vision.getXAndYAuto(turret).getY());


    }
}
