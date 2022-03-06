package frc.robot.conveyor.ballTrigger;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.Rev2mDistanceSensor;
import edu.wpi.first.wpilibj.I2C;
import sensors.triangulatingRangefinder.TriangulatingRangefinder;

import static frc.robot.conveyor.ballTrigger.BallTriggerConstants.ComponentsConstants.*;

public class BallTriggerComponentsBase implements BallTriggerComponents {

    private final WPI_TalonSRX motor;
    //public final ColorSensorV3 colorSensor;
    public final TriangulatingRangefinder analogSensor;

    public BallTriggerComponentsBase() {
        motor = new WPI_TalonSRX(MOTOR_ID);
        motor.configFactoryDefault();
        motor.configAllSettings(getTalonConfiguration());
        motor.setNeutralMode(NeutralMode.Coast);
        motor.setInverted(false);
        motor.enableCurrentLimit(SUPPLY_CURRENT_LIMIT_ENABLED);

        //colorSensor = new ColorSensorV3(I2C.Port.kOnboard);
        analogSensor = new TriangulatingRangefinder(ANALOG_ID);
    }

    @Override
    public WPI_TalonSRX getMotor() {
        return motor;
    }

//    @Override
//    public ColorSensorV3 getColorSensor() {
//        return colorSensor;
//    }

    @Override
    public TriangulatingRangefinder getAnalogSensor() {
        return analogSensor;
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
