package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import sensors.counter.TalonEncoder;

import static frc.robot.drivetrain.DriveTrainConstants.*;
import static frc.robot.drivetrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsBase implements DriveTrainComponents {

    private WPI_TalonFX leftMasterMotor;
    private WPI_TalonFX leftSlaveMotor;
    private WPI_TalonFX rightMasterMotor;
    private WPI_TalonFX rightSlaveMotor;
    private DifferentialDrive differentialDrive;
    private DifferentialDriveOdometry odometry;
    private NormalizedPigeonIMU pigeonIMU;
    private TalonEncoder leftEncoder;
    private TalonEncoder rightEncoder;

    public DriveTrainComponentsBase() {
        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);
        leftMasterMotor.configOpenloopRamp(RAMP_TIME);

        leftSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_PORT);
        leftSlaveMotor.follow(leftMasterMotor);
        leftSlaveMotor.configAllSettings(getFalconConfiguration());
        leftSlaveMotor.setNeutralMode(NeutralMode.Brake);
        leftSlaveMotor.follow(leftMasterMotor);
        leftSlaveMotor.configOpenloopRamp(RAMP_TIME);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setInverted(true);
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);
        rightMasterMotor.configOpenloopRamp(RAMP_TIME);

        rightSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_PORT);
        rightSlaveMotor.follow(rightMasterMotor);
        rightSlaveMotor.configAllSettings(getFalconConfiguration());
        rightSlaveMotor.setInverted(true);
        rightSlaveMotor.setNeutralMode(NeutralMode.Brake);
        rightSlaveMotor.follow(rightMasterMotor);
        rightSlaveMotor.configOpenloopRamp(RAMP_TIME);

        leftEncoder = new TalonEncoder(leftMasterMotor);
        rightEncoder = new TalonEncoder(rightMasterMotor);

        odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(0));
        odometry.resetPosition(new Pose2d(), new Rotation2d());

        pigeonIMU = new NormalizedPigeonIMU(PIGEON_PORT);

        differentialDrive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
        differentialDrive.setSafetyEnabled(false);
    }

    @Override
    public void setNeutralMode(NeutralMode mode) {
        leftMasterMotor.setNeutralMode(mode);
        leftSlaveMotor.setNeutralMode(mode);
        rightMasterMotor.setNeutralMode(mode);
        rightSlaveMotor.setNeutralMode(mode);
    }

    @Override
    public WPI_TalonFX getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public WPI_TalonFX getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }

    @Override
    public DifferentialDriveOdometry getOdometry() {
        return odometry;
    }

    @Override
    public NormalizedPigeonIMU getNormalizedPigeonIMU() {
        return pigeonIMU;
    }

    @Override
    public TalonEncoder getLeftEncoder() {
        return leftEncoder;
    }

    @Override
    public TalonEncoder getRightEncoder() {
        return rightEncoder;
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
