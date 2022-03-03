package frc.robot.shooter;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.shooter.commands.ShootBySpeed;

import java.util.function.DoubleSupplier;

import static frc.robot.shooter.ShooterConstants.*;

public class ShooterShuffleBoard {

    private final Shooter shooter;
    private NetworkTableEntry kP;
    private NetworkTableEntry kI;
    private NetworkTableEntry kD;
    private NetworkTableEntry setRPM;
    private NetworkTableEntry setSpeed;
    private DoubleSupplier RPM;
    private DoubleSupplier speed;

    public ShooterShuffleBoard(Shooter shooter) {
        this.shooter = shooter;
        setRPM = Shuffleboard.getTab("Shooter").add("setRPM", 0).getEntry();
        Shuffleboard.getTab("Shooter").addNumber("RPM", shooter::getCurrentRPM);
        Shuffleboard.getTab("Shooter").addNumber("EncoderUnits", shooter::getEncoderUnits);
        Shuffleboard.getTab("Shooter").addNumber("err", shooter::getError);
        setSpeed = Shuffleboard.getTab("Shooter").add("setSpeed", 0).getEntry();
        kP = Shuffleboard.getTab("Shooter").add("kP", KP).getEntry();
        kI = Shuffleboard.getTab("Shooter").add("kI", KI).getEntry();
        kD = Shuffleboard.getTab("Shooter").add("kD", KD).getEntry();

        RPM = () -> setRPM.getDouble(0);
        speed = () -> setSpeed.getDouble(0);

        Shuffleboard.getTab("Shooter").add("ShootBySpeed", new ShootBySpeed(shooter, speed));
        Shuffleboard.getTab("Shooter").add("ShootByRPM", new ShootByRPM(shooter, RPM));
    }

    public void update() {
        shooter.setPID(kP.getDouble(KP), kI.getDouble(KI), kD.getDouble(KD), KF);
    }
}
