package frc.robot.turret;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.Calculation.*;

public class TurretShuffleBoard {


   public TurretShuffleBoard(Turret turret, TurretComponents components) {



        Shuffleboard.getTab("Turret").addNumber("Current AngleRTR", turret::getCurrentAngleRTR);

        Shuffleboard.getTab("Turret").addNumber("Desired angleRTR", () ->
                absoluteEncoderUnitsToDegrees(components.getController().getSetpoint()));

       // Shuffleboard.getTab("Turret").add("move turret by vision", new RotateByVision(turret, vision));
    }

    public void update() {
    }
}
