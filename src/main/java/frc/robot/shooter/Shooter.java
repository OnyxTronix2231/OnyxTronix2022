package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.RPMToEncUnitsDecisec;

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

    public void initSetPIDSpeed(double RPM) {
        shooterComponents.getController().setSetpoint(RPMToEncUnitsDecisec(RPM));
        shooterComponents.getController().enable();
    }

    public double getSpeed() {
        return shuffleBoard.getRPM();
    }

    public void updateSetPIDSpeed(double rpm) {
        shooterComponents.getController().update(RPMToEncUnitsDecisec(rpm));
    }

    public void stop() {
        setSpeed(0);
        shooterComponents.getController().disable();
    }
}
