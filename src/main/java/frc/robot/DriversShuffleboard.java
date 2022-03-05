package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.arc.Arc;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class DriversShuffleboard {

    public DriversShuffleboard(Vision vision, Shooter shooter, Arc arc, Turret turret){

        Shuffleboard.getTab("Main").addBoolean("Shooter is on Target", shooter::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Arc is on Target", arc::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Turret is on Target", turret::isOnTarget);
        Shuffleboard.getTab("Main").addBoolean("Vision has Target", vision::hasTarget);

        Shuffleboard.getTab("Main").addNumber("vision distance", vision::getHorizontalDistanceTurretToTarget);
        Shuffleboard.getTab("Main").addNumber("vision angle", vision::getHorizontalAngleTurretToTargetRTT);
        Shuffleboard.getTab("Main").addNumber("shooter target", shooter::getSetpoint);
        Shuffleboard.getTab("Main").addNumber("arc target", arc::getSetpoint);
    }
}
