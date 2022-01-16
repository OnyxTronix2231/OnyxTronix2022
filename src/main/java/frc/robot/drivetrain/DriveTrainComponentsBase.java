package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import pid.CtreMotionMagicController;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrainComponentsBase implements DriveTrainComponents {

    WPI_TalonFX leftMasterMotor;
    WPI_TalonFX leftSlaveMotor;
    WPI_TalonFX rightMasterMotor;
    WPI_TalonFX rightSlaveMotor;
    DifferentialDrive differentialDrive;

    public DriveTrainComponentsBase() {
        leftMasterMotor = new WPI_TalonFX(0);
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);
        leftMasterMotor.configOpenloopRamp(RAMP_TIME);

        leftSlaveMotor = new WPI_TalonFX(0);
        leftSlaveMotor.follow(leftMasterMotor);
        leftSlaveMotor.configAllSettings(getFalconConfiguration());
        leftSlaveMotor.setNeutralMode(NeutralMode.Brake);
        leftSlaveMotor.follow(leftMasterMotor);
        leftSlaveMotor.configOpenloopRamp(RAMP_TIME);

        rightMasterMotor = new WPI_TalonFX(0);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setInverted(true);
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);
        rightMasterMotor.configOpenloopRamp(RAMP_TIME);

        rightSlaveMotor = new WPI_TalonFX(0);
        rightSlaveMotor.follow(rightMasterMotor);
        rightSlaveMotor.configAllSettings(getFalconConfiguration());
        rightSlaveMotor.setInverted(true);
        rightSlaveMotor.setNeutralMode(NeutralMode.Brake);
        rightSlaveMotor.follow(rightMasterMotor);
        rightSlaveMotor.configOpenloopRamp(RAMP_TIME);


        differentialDrive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
    }

    @Override
    public WPI_TalonFX getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public WPI_TalonFX getLeftSlaveMotor() {
        return leftSlaveMotor;
    }

    @Override
    public WPI_TalonFX getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public WPI_TalonFX getRightSlaveMotor() {
        return rightSlaveMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = MAX_OUTPUT_FORWARD;
        config.peakOutputReverse = MAX_OUTPUT_REVERSE;
        config.supplyCurrLimit.currentLimit = CURRENT_LIMIT;
        config.supplyCurrLimit.triggerThresholdCurrent = TRIGGER_THRESHOLD_CURRENT;
        config.supplyCurrLimit.triggerThresholdTime = TRIGGER_THRESHOLD_TIME;
        config.supplyCurrLimit.enable = false;
        return config;
    }
}
