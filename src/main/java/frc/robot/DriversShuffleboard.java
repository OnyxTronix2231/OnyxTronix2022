package frc.robot;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.Arc;
import frc.robot.camera.CameraComponents;
import frc.robot.camera.CameraComponentsA;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

import java.util.Map;

public class DriversShuffleboard {

    public DriversShuffleboard(Vision vision, Shooter shooter, Arc arc, Turret turret, HttpCamera limeLightFeed){

        Shuffleboard.getTab("Main").addBoolean("Shooter is on Target", shooter::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Arc is on Target", arc::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Turret is on Target", turret::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Vision has Target", vision::hasTarget);

        Shuffleboard.getTab("Main").addNumber("vision distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Main").addNumber("vision angle", vision::getHorizontalAngleTurretToTargetRTT);
        //Shuffleboard.getTab("Main").addNumber("shooter target", shooter::getSetpoint);
        //Shuffleboard.getTab("Main").addNumber("arc target", arc::getSetpoint);
        Shuffleboard.getTab("Main").addNumber("shooter RPM", shooter::getCurrentRPM);
        Shuffleboard.getTab("Main").addNumber("arc angle", arc::getCurrentAngle);

        Shuffleboard.getTab("Main").add("LL", limeLightFeed).withPosition(7, 1).withSize(3,3)
                .withProperties(Map.of("Show Crosshair", false, "Show Controls", false));

        CameraComponents cameras = new CameraComponentsA();
        Shuffleboard.getTab("Main").add("BACK", cameras.getFirstCamera()).withPosition(0, 1).withSize(4,3)
                .withProperties(Map.of("Show Crosshair", false, "Show Controls", false));;
        Shuffleboard.getTab("Main").add("FRONT", (cameras.getSecondCamera())).withPosition(4, 1).withSize(3,3)
                .withProperties(Map.of("Show Crosshair", false, "Show Controls", false));;

    }
}
