/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import driveTrainJoystickValueProvider.DriveTrainJoystickValueProvider;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
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

import java.util.Timer;
import java.util.TimerTask;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    DriveTrain driveTrain;
    AutonomousShuffleboard autonomousShuffleboard;
    BallTrigger ballTrigger;
    Loader loader;
    Intake intakeFront;
    Intake intakeBack;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        DriveTrainComponents driveTrainComponents;
        LoaderComponents loaderComponents;
        BallTriggerComponents ballTriggerComponents;
        IntakeComponents intakeFrontComponents;
        IntakeComponents intakeBackComponents;
        DriveTrainJoystickValueProvider intakeControl;

        if (Robot.isReal()) {
            driveTrainComponents = new DriveTrainComponentsBase();
            ballTriggerComponents = new BallTriggerComponentsBase();
            loaderComponents = new LoaderComponentsBase();
            intakeFrontComponents = new IntakeFrontComponentsBase();
            intakeBackComponents = new IntakeBackComponentsBase();
        } else {
            driveTrainComponents = null;
            ballTriggerComponents = null;
            loaderComponents = null;
            intakeFrontComponents = null;
            intakeBackComponents = null;
        }

        driveTrain = new DriveTrain(driveTrainComponents);
        ballTrigger = new BallTrigger(ballTriggerComponents);
        loader = new Loader(loaderComponents);
        intakeFront = new Intake(intakeFrontComponents,"Front");
        intakeBack = new Intake(intakeBackComponents,"Back");
        intakeControl = new DriveTrainJoystickValueProvider(driveTrain);

        new DriverOi().withDriveTrain(driveTrain).withIntakeByDriveTrainAndLoadBalls(intakeControl, intakeFront,
                intakeBack, loader, ballTrigger);

        new DeputyOi();

        new DriversShuffleboard();
       autonomousShuffleboard = new AutonomousShuffleboard(driveTrain);
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
//        driveTrain.setNeutralModeToBrake();
//        if (autonomousShuffleboard.getSelectedCommand() != null) {
//            autonomousShuffleboard.getSelectedCommand().cancel();
//        }
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
