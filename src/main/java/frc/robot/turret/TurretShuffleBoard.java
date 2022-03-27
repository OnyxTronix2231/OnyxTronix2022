package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.commands.RotateByAngleOnce;

import static frc.robot.turret.TurretConstants.Calculation.absoluteEncoderUnitsToDegrees;

public class TurretShuffleBoard {

    private final TurretComponents components;

    public TurretShuffleBoard(Turret turret, TurretComponents components) {
        this.components = components;

        Shuffleboard.getTab("Turret").addNumber("AngleRTR DEG", turret::getCurrentAngleRTR);
        Shuffleboard.getTab("Turret").addNumber("AngleRTR ENC", () -> components.getMotor().getSelectedSensorPosition());
        Shuffleboard.getTab("Turret").addNumber("enc", () -> components.getRoboRIOEncoder().getAbsolutePosition()* 4096);
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR DEG", () ->
                absoluteEncoderUnitsToDegrees(components.getController().getSetpoint()));
        Shuffleboard.getTab("Turret").addNumber("Motor Speed", () -> components.getEncoder().getRate());
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR ENC", () ->
                components.getController().getSetpoint());
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR DEG num 2", () ->
                absoluteEncoderUnitsToDegrees(components.getController().getSetpoint()));
    }

    public void update() {
    }
}
