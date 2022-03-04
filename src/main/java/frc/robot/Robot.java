/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.arc.Arc;
import frc.robot.arc.ArcComponents;
import frc.robot.arc.ArcComponentsBase;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.conveyor.ballTrigger.commands.MoveBallTriggerBySpeed;
import frc.robot.conveyor.commands.LoadBalls;
import frc.robot.conveyor.loader.commands.MoveLoaderBySpeed;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriveTrainComponents;
import frc.robot.drivetrain.DriveTrainComponentsBase;
import frc.robot.intake.commands.MoveIntakeBySpeed;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.ShooterComponents;
import frc.robot.shooter.ShooterComponentsBase;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.BallTriggerComponents;
import frc.robot.conveyor.ballTrigger.BallTriggerComponentsBase;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.LoaderComponents;
import frc.robot.conveyor.loader.LoaderComponentsBase;

import frc.robot.intake.Intake;
import frc.robot.intake.IntakeBackComponentsBase;
import frc.robot.intake.IntakeComponents;
import frc.robot.intake.IntakeFrontComponentsBase;
import frc.robot.shooter.commands.ShootByRPM;
import frc.robot.turret.Turret;
import frc.robot.turret.TurretComponents;
import frc.robot.turret.TurretComponentsBase;
import frc.robot.vision.Vision;

import java.util.Timer;
import java.util.TimerTask;

import static frc.robot.arc.ArcConstants.ArcCalculations.encoderUnitsToAngle;
import static frc.robot.arc.ArcConstants.ComponentsConstants.ARC_MIN_ANGLE;

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
    Turret turret;
    Vision vision;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        DriveTrainComponents driveTrainComponents;
        IntakeComponents intakeFrontComponents;
        IntakeComponents intakeBackComponents;
        LoaderComponents loaderComponents;
        BallTriggerComponents ballTriggerComponents;
        DriveTrainJoystickValueProvider joystickValueProvider;
        TurretComponents turretComponents;
        ArcComponents arcComponents;
        ShooterComponents shooterComponents;

        if (Robot.isReal()) {
            driveTrainComponents = new DriveTrainComponentsBase();
            intakeFrontComponents = new IntakeFrontComponentsBase();
            intakeBackComponents = new IntakeBackComponentsBase();
            loaderComponents = new LoaderComponentsBase();
            ballTriggerComponents = new BallTriggerComponentsBase();
            turretComponents = new TurretComponentsBase();
            arcComponents = new ArcComponentsBase();
            shooterComponents = new ShooterComponentsBase();
            vision = new Vision();
        } else {
            driveTrainComponents = null;
            intakeFrontComponents = null;
            intakeBackComponents = null;
            loaderComponents = null;
            ballTriggerComponents = null;
            turretComponents = null;
            arcComponents = null;
            shooterComponents = null;
            vision = null;
        }

        driveTrain = new DriveTrain(driveTrainComponents);
        intakeFront = new Intake(intakeFrontComponents, "Front");
        intakeBack = new Intake(intakeBackComponents, "Back");
        loader = new Loader(loaderComponents);
        ballTrigger = new BallTrigger(ballTriggerComponents);
        joystickValueProvider = new DriveTrainJoystickValueProvider(driveTrain);
        turret = new Turret(turretComponents);
        arc = new Arc(arcComponents);
        shooter = new Shooter(shooterComponents);

        new DriverOi().withDriveTrain(driveTrain).withIntakeByDriveTrainAndLoadBalls(joystickValueProvider, intakeFront,
                intakeBack, loader, ballTrigger).withShooterArcAndConveyor(loader, ballTrigger, shooter, arc);

        new DeputyOi();

        new DriversShuffleboard();
        autonomousShuffleboard = new AutonomousShuffleboard(driveTrain);

        Shuffleboard.getTab("ShootTesting").add("intake", new MoveIntakeBySpeed(intakeBack,()-> 0.5));
        Shuffleboard.getTab("ShootTesting").add("loader", new MoveLoaderBySpeed(loader,()-> 0.5));
        Shuffleboard.getTab("ShootTesting").add("ballTrigger", new MoveBallTriggerBySpeed(ballTrigger,()-> 0.5));
        Shuffleboard.getTab("ShootTesting").addNumber("current angle",
                () -> encoderUnitsToAngle(arc.getComponents().getCounter().getCount()));
        NetworkTableEntry setAngle = Shuffleboard.getTab("ShootTesting").add("setAngle", ARC_MIN_ANGLE).getEntry();
        Shuffleboard.getTab("ShootTesting").add("MoveArcToAngle", new MoveArcToAngle(arc,
                () -> setAngle.getDouble(ARC_MIN_ANGLE)));
        NetworkTableEntry setRPM = Shuffleboard.getTab("ShootTesting").add("setRPM", 0).getEntry();
        Shuffleboard.getTab("ShootTesting").addNumber("RPM", shooter::getCurrentRPM);
        Shuffleboard.getTab("ShootTesting").add("ShootByRPM", new ShootByRPM(shooter,
                () -> setRPM.getDouble(0)));
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
        driveTrain.setNeutralModeToBrake();
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
        driveTrain.setNeutralModeToBrake();
        if (autonomousShuffleboard.getSelectedCommand() != null) {
            autonomousShuffleboard.getSelectedCommand().cancel();
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
