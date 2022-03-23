package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.arc.Arc;
import frc.robot.conveyor.ballTrigger.BallTrigger;
import frc.robot.conveyor.loader.Loader;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;
import frc.robot.intake.Intake;
import frc.robot.providers.AngleProvider;
import frc.robot.providers.DistanceProvider;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;

public class AutonomousShuffleboard {

    private final SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                  BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                  DistanceProvider distanceProvider, AngleProvider angleProvider) {
        autonomousChooser = new SendableChooser<>();

        autonomousChooser.addOption("2 ball from RED close climber point", new RedCloseClimberTwoBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("2 balls from RED far climber start point", new RedFarClimberTwoBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("3 balls from RED far climber start point", new RedFarClimberThreeBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("4 balls RED far climber start point", new RedFarClimberFourBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));

        autonomousChooser.addOption("2 balls from BLUE close climber point", new BlueCloseClimberTwoBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("2 balls BLUE far from climber point", new BlueFarClimberTwoBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("3 balls BLUE far climber point", new BlueFarClimberThreeBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("4 balls BLUE far climber point", new BlueFarClimberFourBalls(driveTrain,
                frontIntake, backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        
        autonomousChooser.setDefaultOption("nothing", new InstantCommand());

        Shuffleboard.getTab("path chooser").add(autonomousChooser);
        Shuffleboard.getTab("path chooser").addNumber("X",
                () -> driveTrain.getPose().getX());
        Shuffleboard.getTab("path chooser").addNumber("Y",
                () -> driveTrain.getPose().getY());
        Shuffleboard.getTab("path chooser").addNumber("heading",
                driveTrain::getHeading);
    }

    public Command getSelectedCommand() {
        return autonomousChooser.getSelected();
    }

    public SendableChooser<Command> getAutonomousChooser() {
        return autonomousChooser;
    }
}
