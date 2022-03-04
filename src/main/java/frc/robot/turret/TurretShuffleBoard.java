package frc.robot.turret;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.turret.commands.RotateByAngleOnce;
import frc.robot.turret.commands.RotateByVision;
import frc.robot.vision.Vision;

import static frc.robot.turret.TurretConstants.Calculation.*;

public class TurretShuffleBoard {

    private final Turret turret;
    private NetworkTableEntry kP;
    private NetworkTableEntry kI;
    private NetworkTableEntry kD;
    private NetworkTableEntry kF;
    private NetworkTableEntry cruiseVel;
    private NetworkTableEntry acceleration;
    private NetworkTableEntry accSmoothing;

    public TurretShuffleBoard(Turret turret) {
        this.turret = turret;
    }

    public void init() {
        kP = Shuffleboard.getTab("Turret").add("set kP",
                turret.getTurretComponents().getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Turret").add("set kI",
                turret.getTurretComponents().getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Turret").add("set kD",
                turret.getTurretComponents().getController().getPIDFTerms().getKd()).getEntry();
        kF = Shuffleboard.getTab("Turret").add("set kF",
                turret.getTurretComponents().getController().getPIDFTerms().getKf()).getEntry();
        cruiseVel = Shuffleboard.getTab("Turret").add("set cruiseVel",
                turret.getTurretComponents().getController().getCruiseVelocity()).getEntry();
        acceleration = Shuffleboard.getTab("Turret").add("set acceleration",
                turret.getTurretComponents().getController().getAcceleration()).getEntry();
        accSmoothing = Shuffleboard.getTab("Turret").add("set accSmoothing",
                turret.getTurretComponents().getController().getAccelerationSmoothing()).getEntry();

        Shuffleboard.getTab("Turret").addNumber("AngleRTR DEG", turret::getCurrentAngleRTR);
        Shuffleboard.getTab("Turret").addNumber("AngleRTR ENC", () -> turret.getTurretComponents().getMotor().getSelectedSensorPosition());
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR DEG", () ->
                absoluteEncoderUnitsToDegrees(turret.getTurretComponents().getController().getSetpoint()));
        Shuffleboard.getTab("Turret").addNumber("Motor Speed", () -> turret.getTurretComponents().getEncoder().getRate());
        Shuffleboard.getTab("Turret").addNumber("DesiredRTR ENC", () ->
                turret.getTurretComponents().getController().getSetpoint());
        Shuffleboard.getTab("Turret").addNumber("error ENC", () -> (turret.getTurretComponents().getController().getCurrentError()));
        Shuffleboard.getTab("Turret").addNumber("error ENC Num", () -> (turret.getTurretComponents().getController().getCurrentError()));

        Shuffleboard.getTab("Turret").add("move 10", new RotateByAngleOnce(turret, () -> 10));
        Shuffleboard.getTab("Turret").add("move 50", new RotateByAngleOnce(turret, () -> 50));
        Shuffleboard.getTab("Turret").add("move 90", new RotateByAngleOnce(turret, () -> 90));
        Shuffleboard.getTab("Turret").add("move 180", new RotateByAngleOnce(turret, () -> 180));
    }

    public void update() {
        turret.getTurretComponents().getController().setPIDFTerms(
                kP.getDouble(turret.getTurretComponents().getController().getPIDFTerms().getKp()),
                kI.getDouble(turret.getTurretComponents().getController().getPIDFTerms().getKi()),
                kD.getDouble(turret.getTurretComponents().getController().getPIDFTerms().getKd()),
                kF.getDouble(turret.getTurretComponents().getController().getPIDFTerms().getKf()));
        turret.getTurretComponents().getController().setCruiseVelocity(
                (int) cruiseVel.getDouble(turret.getTurretComponents().getController().getCruiseVelocity()));
        turret.getTurretComponents().getController().setAcceleration(
                (int) acceleration.getDouble(turret.getTurretComponents().getController().getAcceleration()));
        turret.getTurretComponents().getController().setAccelerationSmoothing(
                (int) accSmoothing.getDouble(turret.getTurretComponents().getController().getAccelerationSmoothing()));
    }
}
