package frc.robot.shooter;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface ShooterIO {
    /** Contains all of the input data received from hardware. */
    public static class ShooterIOInputs implements LoggableInputs {
        public double positionRad = 0.0;
        public double velocityRadPerSec = 0.0;
        public double appliedVolts = 0.0;
        public double[] currentAmps = new double[] {};
        public double[] tempCelcius = new double[] {};

        public void toLog(LogTable table) {
            table.put("PositionRad", positionRad);
            table.put("VelocityRadPerSec", velocityRadPerSec);
            table.put("AppliedVolts", appliedVolts);
            table.put("CurrentAmps", currentAmps);
            table.put("TempCelcius", tempCelcius);
        }

        public void fromLog(LogTable table) {
            positionRad = table.getDouble("PositionRad", positionRad);
            velocityRadPerSec =
                    table.getDouble("VelocityRadPerSec", velocityRadPerSec);
            appliedVolts = table.getDouble("AppliedVolts", appliedVolts);
            currentAmps = table.getDoubleArray("CurrentAmps", currentAmps);
            tempCelcius = table.getDoubleArray("TempCelcius", tempCelcius);
        }
    }

    /** Updates the set of loggable inputs. */
    public default void updateInputs(ShooterIOInputs inputs) {}

    /** Run open loop at the specified voltage. */
    public default void setVoltage(double volts) {}

    /** Enable or disable brake mode. */
    public default void setBrakeMode(boolean enable) {}
}