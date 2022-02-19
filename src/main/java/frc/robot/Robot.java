/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.ballTrigger.BallTriggerComponents;
import frc.robot.conveyor.ballTrigger.BallTriggerComponentsBase;
import frc.robot.conveyor.ballTrigger.BallTriggerShuffleboardCommandTest;
import frc.robot.conveyor.loader.Loader;
import frc.robot.conveyor.loader.LoaderComponents;
import frc.robot.conveyor.loader.LoaderComponentsBase;
import frc.robot.conveyor.loader.LoaderShuffleboardCommandTest;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.drivetrain.DriveTrainComponents;
import frc.robot.drivetrain.DriveTrainComponentsBase;
import frc.robot.intake.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    DriveTrain driveTrain;
    Loader loader;
    BallTrigger ballTrigger;
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
        IntakeComponents intakeComponentsFront;
        IntakeComponents intakeComponentsBack;


        if (Robot.isReal()) {
            driveTrainComponents = new DriveTrainComponentsBase();
            loaderComponents = new LoaderComponentsBase();
            ballTriggerComponents = new BallTriggerComponentsBase();
            intakeComponentsFront = new IntakeFrontComponentsBase();
            intakeComponentsBack = new IntakeBackComponentsBase();


        } else {
            driveTrainComponents = null;
            loaderComponents = null;
            ballTriggerComponents = null;
            intakeComponentsBack = null;
            intakeComponentsFront = null;
        }

        driveTrain = new DriveTrain(driveTrainComponents);
        loader = new Loader(loaderComponents);
        ballTrigger = new BallTrigger(ballTriggerComponents);
        intakeFront = new Intake(intakeComponentsFront);
        intakeBack = new Intake(intakeComponentsBack);



        new DriverOi().withDriveTrain(driveTrain);
        new DeputyOi();

        new DriversShuffleboard();
        new IntakeShuffleboardCommandTest(intakeFront,intakeBack);
        new LoaderShuffleboardCommandTest(loader);
        new BallTriggerShuffleboardCommandTest(ballTrigger);
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
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
//    new Timer().schedule(new TimerTask() {
//      @Override
//      public void run() {
//        if (isDisabled()) driveTrain.setNeutralModeToCoast();
//      }
//    }, 3000);
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command.
     */
    @Override
    public void autonomousInit() {
//    driveTrain.setNeutralModeToBrake();
//    selectedAutonomousCommand = autonomousChooser.getSelected();
//    if (selectedAutonomousCommand != null) {
//      selectedAutonomousCommand.schedule();
//    }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
//    driveTrain.setNeutralModeToBrake();
//    if (selectedAutonomousCommand != null) {
//      selectedAutonomousCommand.cancel();
//    }
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
