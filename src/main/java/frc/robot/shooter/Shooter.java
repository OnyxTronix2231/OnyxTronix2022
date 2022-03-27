package frc.robot.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.shooter.ShooterConstants.ShooterCalculations.*;
import static frc.robot.shooter.ShooterConstants.TOLERANCE;

public class Shooter extends SubsystemBase {

    private final ShooterComponents components;
//    private final ShooterShuffleBoard shuffleBoard;
    private boolean isRealeBallsButtonpress = false;

    public Shooter(ShooterComponents components) {
        this.components = components;
//        shuffleBoard = new ShooterShuffleBoard(this);
    }

    public void periodic() {
//        shuffleBoard.update();
    }

    public void setSpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void initSetPIDSpeed(double RPM) {
        components.getController().setSetpoint(RPMToEncUnitsDecisec(RPM));
        components.getController().enable();
    }

    public double getSetpoint() {
        return encUnitsDecisecToRPM(components.getController().getSetpoint());
    }

    public void initShootByDistance(double distance) {
        initSetPIDSpeed(distanceToRPM(distance));
    }

    public void updateShootByDistance(double distance) {
        updateSetPIDSpeed(distanceToRPM(distance));
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

    public boolean isOnTarget() {
        return components.getController().isOnTarget(RPMToEncUnitsDecisec(TOLERANCE));
    }

    public ShooterComponents getComponents() {
        return components;
    }

    public boolean isRealeBallsButtonpress() {
        return isRealeBallsButtonpress;
    }

    public void setRealeBallsButtonpress(boolean press){
        isRealeBallsButtonpress = press;
    }
}
