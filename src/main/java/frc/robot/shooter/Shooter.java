package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.RPMToEncUnitsDecisec;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;

public class Shooter extends SubsystemBase {

    private final ShooterComponents shooterComponents;
    private final ShooterShuffleBoard shuffleBoard;

    public Shooter(ShooterComponents shooterComponents) {
        this.shooterComponents = shooterComponents;
        shuffleBoard = new ShooterShuffleBoard(this);
        shuffleBoard.init();
    }

    public void periodic() {
        shuffleBoard.update();
    }

    public void setPID(double kP, double kI, double kD, double kF) {
        shooterComponents.getController().setPIDFTerms(kP, kI, kD, kF);
    }

    public void setSpeed(double speed) {
        shooterComponents.getMasterMotor().set(speed);
    }

    public void initSetPIDSpeed(double RPM) {
        shooterComponents.getController().setSetpoint(RPMToEncUnitsDecisec(RPM));
        shooterComponents.getController().enable();
    }

    public double getCurrentRPM() {
        return encUnitsDecisecToRPM(shooterComponents.getCounter().getRate());
    }

    public double getSpeed() {
        return shuffleBoard.getSpeed();
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().update(RPMToEncUnitsDecisec(rpm));
    }

    public void stop() {
        setSpeed(0);
        shooterComponents.getController().disable();
    }
}
