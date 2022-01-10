package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrainComponentsBase implements DriveTrainComponents {

    WPI_TalonFX leftMasterMotor;
    WPI_TalonFX leftSlaveMotor;
    WPI_TalonFX rightMasterMotor;
    WPI_TalonFX rightSlaveMotor;

    public DriveTrainComponentsBase() {
        leftMasterMotor = new WPI_TalonFX(0);
        leftMasterMotor.configFactoryDefault();
        leftSlaveMotor = new WPI_TalonFX(0);
        leftSlaveMotor.follow(leftMasterMotor);
        rightMasterMotor = new WPI_TalonFX(0);
        rightMasterMotor.configFactoryDefault();
        rightSlaveMotor = new WPI_TalonFX(0);
        rightSlaveMotor.follow(rightMasterMotor);
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
}
