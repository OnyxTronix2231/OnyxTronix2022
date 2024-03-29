package frc.robot.shooter;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.shooter.commands.ShootBySpeed;

import static frc.robot.shooter.ShooterConstants.*;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;

public class ShooterShuffleBoard {

    private final Shooter shooter;
    private final NetworkTableEntry kP;
    private final NetworkTableEntry kI;
    private final NetworkTableEntry kD;
    private final NetworkTableEntry kF;
    private final NetworkTableEntry setRPM;
    private final NetworkTableEntry setSpeed;

    public ShooterShuffleBoard(Shooter shooter) {
        this.shooter = shooter;

        Shuffleboard.getTab("Shooter").addNumber("RPM", shooter::getCurrentRPM);
        Shuffleboard.getTab("Shooter").addNumber("EncoderUnits", shooter::getEncoderUnits);
        Shuffleboard.getTab("Shooter").addNumber("encoderErr", shooter::getError);
        Shuffleboard.getTab("Shooter").addNumber("err", () -> encUnitsDecisecToRPM(shooter.getError()));
        Shuffleboard.getTab("Shooter").addNumber("setPoint", () ->
                encUnitsDecisecToRPM(shooter.getComponents().getController().getSetpoint()));

        kP = Shuffleboard.getTab("Shooter").add("kP", KP).getEntry();
        kI = Shuffleboard.getTab("Shooter").add("kI", KI).getEntry();
        kD = Shuffleboard.getTab("Shooter").add("kD", KD).getEntry();
        kF = Shuffleboard.getTab("Shooter").add("kF", KF).getEntry();

        setSpeed = Shuffleboard.getTab("Shooter").add("setSpeed", 0).getEntry();
        setRPM = Shuffleboard.getTab("Shooter").add("setRPM", 0).getEntry();

        Shuffleboard.getTab("Shooter").add("ShootBySpeed", new ShootBySpeed(shooter,
                () -> setSpeed.getDouble(0)));
        Shuffleboard.getTab("Shooter").add("ShootByRPM", new ShootByRPM(shooter,
                () -> setRPM.getDouble(0)));
    }

    public void update() {
        shooter.getComponents().getController().setPIDFTerms(
                kP.getDouble(shooter.getComponents().getController().getPIDFTerms().getKp()),
                kI.getDouble(shooter.getComponents().getController().getPIDFTerms().getKi()),
                kD.getDouble(shooter.getComponents().getController().getPIDFTerms().getKd()),
                kF.getDouble(shooter.getComponents().getController().getPIDFTerms().getKf()));
    }
}
