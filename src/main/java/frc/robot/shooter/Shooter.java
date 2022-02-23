package frc.robot.shooter;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.*;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.rpmToEncUnitsDecisec;

public class Shooter extends SubsystemBase {

    private final ShooterComponents shooterComponents;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry precentageOutput;
    private double speed;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
        Shuffleboard.getTab("Shooter").addNumber("RPM", () -> encUnitsDecisecToRPM(shooterComponents
                .getCounter().getRate()));
        precentageOutput = Shuffleboard.getTab("Shooter").add("precentageOutput", 0).getEntry();
        kP = Shuffleboard.getTab("Shooter").add("kP", KP).getEntry();
        kI = Shuffleboard.getTab("Shooter").add("kI", KI).getEntry();
        kD = Shuffleboard.getTab("Shooter").add("kD", KD).getEntry();
        Shuffleboard.getTab("Shooter").addNumber("err", () -> Math.abs(encUnitsDecisecToRPM(shooterComponents
                .getCounter().getRate()) - precentageOutput.getDouble(0)));
    }

    public void periodic() {
        speed = precentageOutput.getDouble(0);
        shooterComponents.getController().setPIDFTerms(kP.getDouble(KP), kI.getDouble(KI), kD.getDouble(KD), KF);
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public void initSetPIDSpeed(double rpm) {
        shooterComponents.getController().setSetpoint(rpmToEncUnitsDecisec(rpm));
        shooterComponents.getController().enable();
    }

    public double getSpeed() {
        return speed;
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().update(rpmToEncUnitsDecisec(rpm));
    }

    public void stop() {
        setSpeed(0);
        shooterComponents.getController().disable();
    }
}
