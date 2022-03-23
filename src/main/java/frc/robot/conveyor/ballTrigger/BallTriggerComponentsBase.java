package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.ComponentsConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonFX motor;
    public final TriangulatingRangefinder analogSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonFX(MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(true);

        analogSensor = new TriangulatingRangefinder(ANALOG_ID);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public TriangulatingRangefinder getAnalogSensor() {
        return analogSensor;
    }

    private TalonFXConfiguration getTalonConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.supplyCurrLimit.currentLimit = SUPPLY_CURRENT_LIMIT;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED;
        config.openloopRamp = OPEN_LOOP_RAMP;
        config.closedloopRamp = CLOSE_LOOP_RAMP;
        return config;
    }
}
