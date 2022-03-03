package frc.robot.crossPlatform;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.Calculation.absoluteEncoderUnitsToDegrees;

public class ShuffleBoardTurretAndVision {
    public ShuffleBoardTurretAndVision(Turret turret, TurretComponents components, Vision vision) {

        Shuffleboard.getTab("The amazing turret and vision").addNumber("Current AngleRTR", turret::getCurrentAngleRTR);

        Shuffleboard.getTab("The amazing turret and vision").addNumber("Desired angleRTR", () ->
                absoluteEncoderUnitsToDegrees(components.getController().getSetpoint()));

        Shuffleboard.getTab("The amazing turret and vision").add("move turret by vision", new RotateByVision(turret, vision));
    }
}
