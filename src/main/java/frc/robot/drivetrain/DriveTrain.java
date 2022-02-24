package frc.robot.drivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;

import static frc.robot.drivetrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    Command upperTarmacTo5AllianceBalls;
    Command upperTarmacTo2AllianceBalls;
    Command upperTarmacToAllianceAndEnemyBall;
    Command lowerTarmacToAlliance1Ball;
    Command lowerTarmacToAllianceBallEnemyBalls;
    SendableChooser<Command> autonomousChooser;

    private final DriveTrainComponents driveTrainComponents;
    public double forwardJoystickValue;

    public DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
        resetOdometryToPose(StartPoses.S1);
    }

    public void resetEncoders() {
        driveTrainComponents.getLeftEncoder().reset();
        driveTrainComponents.getRightEncoder().reset();
        driveTrainComponents.getNormelizedPigeonIMU().reset();
    }

    public void shuffleBoard(DriveTrain driveTrain) {
        autonomousChooser = new SendableChooser<>();
        new UpperTarmacTo2UpperAllianceBalls(driveTrain);
        new UpperTarmacTo5AllianceBalls(driveTrain);
        new UpperTarmacToAllianceAndEnemyBalls(driveTrain);
        new LowerTarmacToAlliance1Ball(driveTrain);
        new LowerTarmacToAllianceBallEnemyBalls(driveTrain);
        SmartDashboard.putData(autonomousChooser);

        autonomousChooser.setDefaultOption("upper tarmac to 5 alliance balls",upperTarmacTo5AllianceBalls);
        autonomousChooser.addOption("upper tarmac to 2 alliance balls",upperTarmacTo2AllianceBalls);

        autonomousChooser.addOption("lower tarmac to one alliance ball",lowerTarmacToAlliance1Ball);
        autonomousChooser.addOption("lower tarmac to alliance ball and enemy ball",lowerTarmacToAllianceBallEnemyBalls);
    }

    public Command getSelectedAutoCommand() {
        return autonomousChooser.getSelected();
    }

    @Override
    public void periodic() {
        driveTrainComponents.getOdometry().update(
                Rotation2d.fromDegrees(getHeading()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getLeftMasterMotor().getSelectedSensorPosition()),
                Calculations.encoderUnitsToMeters(driveTrainComponents.getRightMasterMotor().getSelectedSensorPosition()));
        driveTrainComponents.getField().setRobotPose(driveTrainComponents.getOdometry().getPoseMeters());
        SmartDashboard.updateValues();
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive().arcadeDrive(speed * SPEED_SENSITIVITY, rotation * ROTATION_SENSITIVITY);
        forwardJoystickValue = speed * SPEED_SENSITIVITY;
    }

    public void stop() {
        driveTrainComponents.getDifferentialDrive().stopMotor();
    }

    public Pose2d getPose() {
        return driveTrainComponents.getOdometry().getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(Calculations.encoderUnitsDeciSecToMetersSec(
                        driveTrainComponents.getLeftMasterMotor().getSelectedSensorVelocity()),
                        Calculations.encoderUnitsDeciSecToMetersSec(driveTrainComponents.getRightMasterMotor().getSelectedSensorVelocity()));
    }

    public double getRobotSpeedMPS() {
        return ((getWheelSpeeds().leftMetersPerSecond + getWheelSpeeds().rightMetersPerSecond) / 2);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        driveTrainComponents.getLeftMasterMotor().set(leftVolts / VOLTS);
        driveTrainComponents.getRightMasterMotor().set(rightVolts / VOLTS);
        driveTrainComponents.getDifferentialDrive().feed();
    }

    public double getHeading() {
        return driveTrainComponents.getNormelizedPigeonIMU().getRawYaw();
    }

    public void resetOdometryToPose(Translation2d translation) {
        resetOdometryToPose(new Pose2d(translation, this.getPose().getRotation()));
    }

    public void setNeutralModeToCoast() {
        driveTrainComponents.setNeutralMode(NeutralMode.Coast);
    }

    public void setNeutralModeToBrake() {
        driveTrainComponents.setNeutralMode(NeutralMode.Brake);
    }

    public void resetOdometryToPose(Pose2d pose) {
        resetEncoders();
        driveTrainComponents.getOdometry().resetPosition(pose, pose.getRotation());
        driveTrainComponents.getNormelizedPigeonIMU().setYaw(pose.getRotation().getDegrees());
    }

    public double getForwardJoystickValue() {
        return forwardJoystickValue;
    }
}
