package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.util.sendable.Sendable;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.util.sendable.SendableRegistry;

public class NormalizedPigeonIMU extends PigeonIMU implements Sendable {

    public NormalizedPigeonIMU(int deviceNumber) {
        super(deviceNumber);
        SendableRegistry.addLW(this, "PigeonIMU [" + deviceNumber + "]");
    }

    public NormalizedPigeonIMU(TalonSRX talonSrx) {
        super(talonSrx);
        SendableRegistry.addLW(this, "PigeonIMU [" + talonSrx.getDeviceID() + "]");
    }

    public double getRawYaw() {
        double[] yawPitchRoll = new double[3];
        getYawPitchRoll(yawPitchRoll);
        return Math.IEEEremainder(yawPitchRoll[0], 360);
    }

    public double getRawPitch() {
        double[] yawPitchRoll = new double[3];
        getYawPitchRoll(yawPitchRoll);
        return Math.IEEEremainder(yawPitchRoll[1], 360);
    }

    public double getRawRoll() {
        double[] yawPitchRoll = new double[3];
        getYawPitchRoll(yawPitchRoll);
        return Math.IEEEremainder(yawPitchRoll[2], 360);
    }

    public void reset() {
        this.setYaw(0);
    }

    public void reset(int timeoutMs) {
        this.setYaw(0, timeoutMs);
    }

    public double getNormalizedYaw() {
        final double rawYaw = getRawYaw();
        if (rawYaw > 180) {
            return rawYaw - 360;
        } else if (rawYaw < -180) {
            return rawYaw + 360;
        }
        return rawYaw;
    }

    public double getYawRate() {
        double[] rawPigeon = new double[3];
        this.getRawGyro(rawPigeon);
        return rawPigeon[0];
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("Gyro");
        builder.addDoubleProperty("Value", this::getRawYaw, null);
    }
}
