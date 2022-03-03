package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.Rev2mDistanceSensor;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.ComponentsConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonSRX motor;
    private final Rev2mDistanceSensor distanceSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(false);
        motor.enableCurrentLimit(SUPPLY_CURRENT_LIMIT_ENABLED);
        distanceSensor = new Rev2mDistanceSensor(Rev2mDistanceSensor.Port.kOnboard,
                Rev2mDistanceSensor.Unit.kMillimeters, Rev2mDistanceSensor.RangeProfile.kHighAccuracy);
        distanceSensor.setAutomaticMode(true);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

    @Override
    public Rev2mDistanceSensor getDistanceSensorUp() {
        return distanceSensor;
    }

    private TalonSRXConfiguration getTalonConfiguration() {
        final TalonSRXConfiguration config = new TalonSRXConfiguration();
        config.continuousCurrentLimit = SUPPLY_CURRENT_LIMIT;
        config.peakCurrentLimit = SUPPLY_TRIGGER_THRESHOLD_CURRENT;
        config.peakCurrentDuration = SUPPLY_TRIGGER_THRESHOLD_TIME;
        config.openloopRamp = OPEN_LOOP_RAMP;
        config.closedloopRamp = CLOSE_LOOP_RAMP;
        return config;
    }
}
