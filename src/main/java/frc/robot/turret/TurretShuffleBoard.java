package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import static frc.robot.turret.TurretConstants.Calculation.*;
import static frc.robot.turret.TurretConstants.ComponentsConstants.*;

public class TurretShuffleBoard {

    private final Turret turret;
    private final TurretComponents components;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;
    private final NetworkTableEntry cruiseVel;
    private final NetworkTableEntry acceleration;
    private final NetworkTableEntry accSmoothing;

    public TurretShuffleBoard(Turret turret, TurretComponents components) {
        this.turret = turret;
        this.components = components;

        kP = Shuffleboard.getTab("Turret").add("set kP",
                components.getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Turret").add("set kI",
                components.getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Turret").add("set kD",
                components.getController().getPIDFTerms().getKd()).getEntry();
        kF = Shuffleboard.getTab("Turret").add("set kF",
                components.getController().getPIDFTerms().getKf()).getEntry();
        cruiseVel = Shuffleboard.getTab("Turret").add("set cruiseVel",
                components.getController().getCruiseVelocity()).getEntry();
        acceleration = Shuffleboard.getTab("Turret").add("set acceleration",
                components.getController().getAcceleration()).getEntry();
        accSmoothing = Shuffleboard.getTab("Turret").add("set accSmoothing",
                components.getController().getAccelerationSmoothing()).getEntry();

        Shuffleboard.getTab("Turret").addNumber("AngleRTR DEG", turret::getCurrentAngleRTR);
        Shuffleboard.getTab("Turret").addNumber("AngleRTR ENC", ()-> components.getEncoder().getCount() % ENCODER_UNITS_IN_ROTATION);
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR DEG", ()->
                encoderUnitsToDegrees(components.getController().getSetpoint()));
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR ENC", ()->
                components.getController().getSetpoint());
    }

    public void update() {
        components.getController().setPIDFTerms(
                kP.getDouble(components.getController().getPIDFTerms().getKp()),
                kI.getDouble(components.getController().getPIDFTerms().getKi()),
                kD.getDouble(components.getController().getPIDFTerms().getKd()),
                kF.getDouble(components.getController().getPIDFTerms().getKf()));
        components.getController().setCruiseVelocity(
                (int)cruiseVel.getDouble(components.getController().getCruiseVelocity()));
        components.getController().setAcceleration(
                (int)acceleration.getDouble(components.getController().getAcceleration()));
        components.getController().setAccelerationSmoothing(
                (int)accSmoothing.getDouble(components.getController().getAccelerationSmoothing()));
    }
}
