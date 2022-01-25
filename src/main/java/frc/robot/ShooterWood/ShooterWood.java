package frc.robot.ShooterWood;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import static frc.robot.ShooterWood.ShooterWoodConstants.*;

public class ShooterWood extends SubsystemBase {

    private ShooterWoodComponents shooterWoodComponents;
    private NetworkTableEntry percentageOutput;
    private NetworkTableEntry kP;
    private NetworkTableEntry kI;
    private NetworkTableEntry kD;
    private double speed;

    public ShooterWood(ShooterWoodComponents shooterWoodComponents) {
        this.shooterWoodComponents = shooterWoodComponents;
        Shuffleboard.getTab("Shooter").addNumber("RPM", () -> encoderUnitsInDecisecondToRPM(shooterWoodComponents
                .getCounter().getRate()));
        percentageOutput = Shuffleboard.getTab("Shooter").add("percentageOutput", 0).getEntry();
        kP = Shuffleboard.getTab("Shooter").add("kP", shooterWoodComponents.getController().getPIDFTerms().getKp()).getEntry();
        kI = Shuffleboard.getTab("Shooter").add("kI", shooterWoodComponents.getController().getPIDFTerms().getKi()).getEntry();
        kD = Shuffleboard.getTab("Shooter").add("kD", shooterWoodComponents.getController().getPIDFTerms().getKd()).getEntry();
    }

    @Override
    public void periodic() {
        speed = percentageOutput.getDouble(0);
        shooterWoodComponents.getController().setPIDFTerms(kP.getDouble(0), kI.getDouble(0), kD.getDouble(0), PIDF_F);
    }

    public void setSpeed(double speed) {
        shooterWoodComponents.getMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
        shooterWoodComponents.getController().disable();
    }

    public double getSpeed() {
        return speed;
    }


    public double RPMToEncoderUnitsInDecisecond(double rpm) {
        return (rpm * ENCODER_UNITS_PER_ROUND) / DECISECONDS_PER_MIN;
    }

    public double encoderUnitsInDecisecondToRPM(double encoderUnits) {
        return (encoderUnits * DECISECONDS_PER_MIN)/ENCODER_UNITS_PER_ROUND;
    }

    public void initMoveByRPM(double rpm) {
        shooterWoodComponents.getController().setSetpoint(RPMToEncoderUnitsInDecisecond(rpm));
        shooterWoodComponents.getController().enable();
    }

    public void updateMoveByRPM(double rpm){
        shooterWoodComponents.getController().setSetpoint(RPMToEncoderUnitsInDecisecond(rpm));
    }
}
