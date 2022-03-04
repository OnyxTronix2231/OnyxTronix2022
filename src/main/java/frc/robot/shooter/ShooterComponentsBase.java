package frc.robot.shooter;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import pid.interfaces.PIDController;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.conveyor.loader.LoaderConstants.ComponentsConstant.*;
import static frc.robot.shooter.ShooterConstants.*;
import static frc.robot.shooter.ShooterConstants.ComponentsConstants.MASTER_MOTOR_ID;
import static frc.robot.shooter.ShooterConstants.ComponentsConstants.SLAVE_MOTOR_ID;
import static frc.robot.shooter.ShooterConstants.ShooterCalculations.RPMToEncUnitsDecisec;

public class ShooterComponentsBase implements ShooterComponents{

    private final WPI_TalonFX masterMotor;
    private final WPI_TalonFX slaveMotor;
    private final TalonEncoder encoder;
    private final CtrePIDController controller;

    public ShooterComponentsBase() {
        masterMotor = new WPI_TalonFX(MASTER_MOTOR_ID);
        masterMotor.configFactoryDefault();
        masterMotor.configAllSettings(getConfiguration());

        slaveMotor = new WPI_TalonFX(SLAVE_MOTOR_ID);
        slaveMotor.configFactoryDefault();
        slaveMotor.configAllSettings(getConfiguration());
        slaveMotor.follow(masterMotor);
        slaveMotor.setInverted(true);

        encoder = new TalonEncoder(masterMotor);

        controller = new CtrePIDController(masterMotor, encoder,
                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
        controller.setPIDFTerms(controller.getPIDFTerms());
    }

    public TalonFXConfiguration getConfiguration(){
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.closedloopRamp = CLOSE_LOOP_RAMP;
        config.slot0.integralZone = RPMToEncUnitsDecisec(INTEGRAL_ZONE);
        config.supplyCurrLimit.currentLimit = SUPPLY_CURRENT_LIMIT;
        config.supplyCurrLimit.triggerThresholdCurrent = SUPPLY_TRIGGER_THRESHOLD_CURRENT;
        config.supplyCurrLimit.triggerThresholdTime = SUPPLY_TRIGGER_THRESHOLD_TIME;
        config.supplyCurrLimit.enable = SUPPLY_CURRENT_LIMIT_ENABLED;
        config.statorCurrLimit.currentLimit = STATOR_CURRENT_LIMIT;
        config.statorCurrLimit.triggerThresholdCurrent = STATOR_TRIGGER_THRESHOLD_CURRENT;
        config.statorCurrLimit.triggerThresholdTime = STATOR_TRIGGER_THRESHOLD_TIME;
        config.statorCurrLimit.enable = STATOR_CURRENT_LIMIT_ENABLED;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }
    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
    }

    @Override
    public Counter getCounter() {
        return encoder;
    }

    @Override
    public PIDController getController() {
        return controller;
    }
}
