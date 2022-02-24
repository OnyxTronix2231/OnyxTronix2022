package frc.robot.shooter;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.*;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.rpmToEncUnitsDecisec;

public class Shooter extends SubsystemBase {

    private final ShooterComponents shooterComponents;
    private final ShooterShuffleBoard shuffleBoard;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
        shuffleBoard = new ShooterShuffleBoard(this, shooterComponents);
    }

    public void periodic() {
        shuffleBoard.update();
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public void initSetPIDSpeed(double rpm) {
        shooterComponents.getController().setSetpoint(rpmToEncUnitsDecisec(rpm));
        shooterComponents.getController().enable();
    }

    public double getSpeed() {
        return shuffleBoard.getRPM();
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().update(rpmToEncUnitsDecisec(rpm));
    }

    public void stop() {
        setSpeed(0);
        shooterComponents.getController().disable();
    }
}
