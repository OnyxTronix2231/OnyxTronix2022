package frc.robot.turret;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.turret.TurretConstants.*;
import static frc.robot.turret.TurretConstants.Calculation.*;

public class Turret extends SubsystemBase {

    private final TurretComponents components;
    //private final TurretShuffleBoard turretShuffleBoard;

    private double startingAngle;
    private double targetAngle;

    public Turret(TurretComponents turretComponents) {
        components = turretComponents;
        //turretShuffleBoard = new TurretShuffleBoard(this, components);
    }

//    @Override
//    public void periodic() {
//        turretShuffleBoard.update();
//    }

    public double getCurrentAngleRTR() {
        return absoluteEncoderUnitsToDegrees(components.getEncoder().getCount());
    }

    public void stop() {
        setSpeed(0);
        components.getController().disable();
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void initMoveToDegreeRTR(double deg) {
        components.getController().setSetpoint(degreesToAbsoluteEncoderUnits(fixAngleAccordingToLimits(deg)));
        components.getController().enable();
    }

    public void updateMoveToDegreeRTR(double deg) {
        components.getController().update(degreesToAbsoluteEncoderUnits(fixAngleAccordingToLimits(deg)));
    }

    public void initMoveByDegree(double deg){
        startingAngle = getCurrentAngleRTR();
        targetAngle = deg;
        initMoveToDegreeRTR(startingAngle + deg);
    }

    public void updateMoveByDegree(double deg){
        if (targetAngle != deg) {
            startingAngle = getCurrentAngleRTR();
            targetAngle = deg;
        }
        updateMoveToDegreeRTR(startingAngle + deg);
    }

    public boolean isOnTarget() {
        return components.getController().isOnTarget(degreesToEncoderUnits(TOLERANCE_DEGREES));
    }
}
