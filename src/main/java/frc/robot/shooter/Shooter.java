package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.RPMToEncUnitsDecisec;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.encUnitsDecisecToRPM;
import static frc.robot.shooter.ShooterConstants.TOLERANCE;

public class Shooter extends SubsystemBase {

    private final ShooterComponents components;
    private final ShooterShuffleBoard shuffleBoard;

    public Shooter(ShooterComponents components) {
        this.components = components;
        shuffleBoard = new ShooterShuffleBoard(this);
    }

    public void periodic() {
        //shuffleBoard.update();
    }

    public void setSpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public double getSpeed() {
        return components.getMasterMotor().getMotorOutputPercent();
    }

    public void initSetPIDSpeed(double RPM) {
        components.getController().setSetpoint(RPMToEncUnitsDecisec(RPM));
        components.getController().enable();
    }

    public void updateSetPIDSpeed(double RPM) {
        components.getController().update(RPMToEncUnitsDecisec(RPM));
    }

    public double getCurrentRPM() {
        return encUnitsDecisecToRPM(components.getCounter().getRate());
    }

    public double getError() {
        return components.getController().getCurrentError();
    }

    public double getEncoderUnits() {
        return components.getCounter().getRate();
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public ShooterComponents getComponents(){
        return components;
    }

    public boolean isOnTarget(){
        return components.getController().isOnTarget(RPMToEncUnitsDecisec(TOLERANCE));
    }
}
