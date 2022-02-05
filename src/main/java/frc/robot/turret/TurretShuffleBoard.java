package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.TurretComponents;

import static frc.robot.turret.TurretConstants.calculations.*;

public class TurretShuffleBoard{

    private final TurretComponents components;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;

    public TurretShuffleBoard(TurretComponents components) {
        this.components = components;

        kP = Shuffleboard.getTab("Turret").add("set kP",
                components.getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Turret").add("set kI",
                components.getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Turret").add("set kD",
                components.getController().getPIDFTerms().getKd()).getEntry();
        kF = Shuffleboard.getTab("Turret").add("set kF",
                components.getController().getPIDFTerms().getKf()).getEntry();
    }

    public void update() {
        components.getController().setPIDFTerms(
                kP.getDouble(components.getController().getPIDFTerms().getKp()),
                kI.getDouble(components.getController().getPIDFTerms().getKi()),
                kD.getDouble(components.getController().getPIDFTerms().getKd()),
                kF.getDouble(components.getController().getPIDFTerms().getKf()));
    }
}

