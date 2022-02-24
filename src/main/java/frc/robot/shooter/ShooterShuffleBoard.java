package frc.robot.shooter;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.shooter.commands.ShootBySpeed;

import static frc.robot.shooter.ShooterConstants.*;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;

public class ShooterShuffleBoard {

    private final ShooterComponents shooterComponents;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry setRPM;
    private final NetworkTableEntry setSpeed;
    private double RPM;
    private double speed;

    public ShooterShuffleBoard(Shooter shooter, ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;

        Shuffleboard.getTab("Shooter").addNumber("RPM", () -> encUnitsDecisecToRPM(shooterComponents
                .getCounter().getRate()));
        setRPM = Shuffleboard.getTab("Shooter").add("setRPM", 0).getEntry();
        Shuffleboard.getTab("Shooter").addNumber("err", () -> Math.abs(encUnitsDecisecToRPM(shooterComponents
                .getCounter().getRate()) - setRPM.getDouble(0)));
        setSpeed = Shuffleboard.getTab("Shooter").add("setSpeed", 0).getEntry();
        kP = Shuffleboard.getTab("Shooter").add("kP", KP).getEntry();
        kI = Shuffleboard.getTab("Shooter").add("kI", KI).getEntry();
        kD = Shuffleboard.getTab("Shooter").add("kD", KD).getEntry();
        Shuffleboard.getTab("Shooter").add("ShootBySpeed", new ShootBySpeed(shooter, this::getSpeed));
        Shuffleboard.getTab("Shooter").add("ShootByRPM", new ShootByRPM(shooter, this::getRPM));
    }

    public void update() {
        shooterComponents.getController().setPIDFTerms(kP.getDouble(KP), kI.getDouble(KI), kD.getDouble(KD), KF);
        RPM = setRPM.getDouble(0);
        speed = setSpeed.getDouble(0);
    }

    public double getRPM() {
        return RPM;
    }

    public double getSpeed() {
        return speed;
    }
}
