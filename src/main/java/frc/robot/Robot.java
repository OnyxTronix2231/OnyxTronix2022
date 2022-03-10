/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcComponents;
import frc.robot.arc.ArcComponentsBase;
import frc.robot.arc.commands.CalibrateArc;
import frc.robot.climber.Climber;
import frc.robot.climber.ClimberComponents;
import frc.robot.climber.ClimberComponentsBase;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.BallTriggerComponents;
import frc.robot.conveyor.ballTrigger.BallTriggerComponentsBase;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.LoaderComponents;
import frc.robot.conveyor.loader.LoaderComponentsBase;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriveTrainComponents;
import frc.robot.drivetrain.DriveTrainComponentsBase;
import frc.robot.intake.Intake;
import frc.robot.intake.IntakeBackComponentsBase;
import frc.robot.intake.IntakeComponents;
import frc.robot.intake.IntakeFrontComponentsBase;
import frc.robot.providers.*;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.ShooterComponents;
import frc.robot.shooter.ShooterComponentsBase;
import frc.robot.turret.TurretComponents;
import frc.robot.turret.TurretComponentsBase;
import frc.robot.vision.Vision;
import frc.robot.yawControl.YawControl;

import java.util.Timer;
import java.util.TimerTask;

import static frc.robot.Constants.ARC_CALIBRATION_SPEED;
import static frc.robot.Constants.VISION_PIPELINE;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    DriveTrain driveTrain;
    Arc arc;
    Shooter shooter;
    AutonomousShuffleboard autonomousShuffleboard;
    BallTrigger ballTrigger;
    Loader loader;
    Intake intakeFront;
    Intake intakeBack;
    YawControl turret;
    Vision vision;
    Climber climber;
    boolean firstEnable = false;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        HttpCamera limeLightFeed = new HttpCamera("limelight", "http://10.22.31.10:5800");

        DriveTrainComponents driveTrainComponents;
        IntakeComponents intakeBackComponents;
        IntakeComponents intakeFrontComponents;
        LoaderComponents loaderComponents;
        BallTriggerComponents ballTriggerComponents;
        TurretComponents turretComponents;
        ArcComponents arcComponents;
        ShooterComponents shooterComponents;
        ClimberComponents climberComponents;

        LiveWindow.disableAllTelemetry();

        driveTrainComponents = new DriveTrainComponentsBase();
        intakeFrontComponents = new IntakeFrontComponentsBase();
        intakeBackComponents = new IntakeBackComponentsBase();
        loaderComponents = new LoaderComponentsBase();
        ballTriggerComponents = new BallTriggerComponentsBase();
        turretComponents = new TurretComponentsBase();
        arcComponents = new ArcComponentsBase();
        shooterComponents = new ShooterComponentsBase();
        climberComponents = new ClimberComponentsBase();

        vision = new Vision();
        vision.setPipeline(VISION_PIPELINE);

        driveTrain = new DriveTrain(driveTrainComponents);
        intakeFront = new Intake(intakeFrontComponents, "Front");
        intakeBack = new Intake(intakeBackComponents, "Back");
        loader = new Loader(loaderComponents);
        ballTrigger = new BallTrigger(ballTriggerComponents);
        turret = new YawControl(turretComponents, driveTrain);
        arc = new Arc(arcComponents);
        shooter = new Shooter(shooterComponents);
        climber = new Climber(climberComponents);

        var distanceProviderByVision = new DistanceProviderByVision(vision);
        var distanceProviderByOdometry = new DistanceProviderByOdemetry(driveTrain);
        var distanceProviderByVisionAndOdometry = new DistanceProviderByVisionAndOdemetry
                (vision, distanceProviderByVision, distanceProviderByOdometry);


        var angleProviderByVision = new AngleProviderByVision(vision);
        var angleProviderByOdometry = new AngleProviderByOdemetry(turret);
        var angleProviderByVisionAndOdometry = new AngleProviderByVisionAndOdemetry
                (vision, angleProviderByVision, angleProviderByOdometry);

        var shootBallsConditions = new ShootBallConditionsProvider(shooter, turret, arc);

        new DriverOi()
                .withDriveTrain(driveTrain)
                .withIntakeBackAndLoadBallsPlanB(intakeBack, loader, ballTrigger)
                .withIntakeFrontAndLoadBallsPlanB(intakeFront, loader, ballTrigger)
                .withArcCalibration(arc)
                .withGetReadyToClime(turret, arc, intakeFront).
                withShootBalls(vision, shooter, arc, turret, ballTrigger, loader, distanceProviderByVisionAndOdometry,
                        angleProviderByVisionAndOdometry, shootBallsConditions)
        ;

        new DeputyOi()
                .withGetReadyToShoot(shooter, arc, turret, distanceProviderByVisionAndOdometry,
                        angleProviderByVisionAndOdometry)
                .withArcCalibration(arc)
                .withLoader(loader)
                .withBallTrigger(ballTrigger)
                .withClimber(climber)
                .withShooter(shooter, arc, loader, ballTrigger, turret, vision);
        ;

        new DriversShuffleboard(vision, shooter, arc, turret, limeLightFeed);

        autonomousShuffleboard = new AutonomousShuffleboard(driveTrain, intakeFront,
                intakeBack, loader, ballTrigger, turret, shooter, arc, distanceProviderByVisionAndOdometry,
                angleProviderByVisionAndOdometry);

        firstEnable = true;
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
        SmartDashboard.updateValues();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
        if (vision != null) {
            vision.ledsOff();
        }

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (isDisabled()) driveTrain.setNeutralModeToCoast();
            }
        }, 3000);
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command.
     */
    @Override
    public void autonomousInit() {
        if (driveTrain != null) {
            driveTrain.setNeutralModeToBrake();
        }
        if (vision != null) {
            vision.ledsOn();
        }
        if (autonomousShuffleboard.getSelectedCommand() != null) {
            autonomousShuffleboard.getSelectedCommand().schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        if (driveTrain != null) {
            driveTrain.setNeutralModeToBrake();
        }

        if (vision != null) {
            vision.ledsOn();
        }

        if (autonomousShuffleboard.getSelectedCommand() != null) {
            autonomousShuffleboard.getSelectedCommand().cancel();
        }
        if (firstEnable && arc != null) {
            CommandScheduler.getInstance().schedule(new CalibrateArc(arc, () -> ARC_CALIBRATION_SPEED));
            firstEnable = false;
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
