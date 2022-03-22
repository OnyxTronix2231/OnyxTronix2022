package frc.robot;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.Arc;
import frc.robot.camera.CameraComponents;
import frc.robot.conveyor.loader.Loader;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

import java.util.Map;

public class DriversShuffleboard {

    public DriversShuffleboard(HttpCamera limeLightFeed,
                               CameraComponents cameraComponents) {

        Shuffleboard.getTab("Main").add("LL", limeLightFeed).withProperties(
                Map.of("Show Crosshair", false, "Show Controls", false)).withWidget("Camera Stream");

        Shuffleboard.getTab("Main").add("Camera1", cameraComponents.getFirstCamera()).withProperties(
                Map.of("Show Crosshair", false, "Show Controls", false)).withWidget("Camera Stream");
    }
}
