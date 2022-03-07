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
import frc.robot.providers.DistanceProviderByVisionAndOdemetry;
import frc.robot.shooter.Shooter;
import frc.robot.turret.Turret;
import frc.robot.vision.Vision;

public class AutonomousShuffleboard {

    private final SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain, Intake frontIntake, Intake backIntake, Loader loader,
                                  BallTrigger ballTrigger, Turret turret, Shooter shooter, Arc arc,
                                  DistanceProvider distanceProvider, AngleProvider angleProvider) {
        autonomousChooser = new SendableChooser<>();

        autonomousChooser.setDefaultOption("1 ball from RED point", new LowOneBall(driveTrain, frontIntake,
                backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
//        autonomousChooser.addOption("5 balls from upper start point", new Upper5Balls(driveTrain));
        autonomousChooser.addOption("2 balls from RED start point", new UpperTwoBalls(driveTrain, frontIntake,
                backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
        autonomousChooser.addOption("3 balls from RED start point", new UpperThreeBalls(driveTrain, frontIntake,
                backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));
//        autonomousChooser.addOption("1 ball and 1 enemy ball from upper start", new Upper1BallAnd1EnemyBall(driveTrain));
//        autonomousChooser.addOption("1 ball and 1 enemy ball from low point", new Low1BallAndEnemyBall(driveTrain));
        autonomousChooser.addOption("one meter forward", new MeterForwardTest(driveTrain));

        autonomousChooser.addOption("nothing", new InstantCommand());

        autonomousChooser.addOption("BLUE three balls", new DownThreeBalls(driveTrain, frontIntake,
                backIntake, loader, ballTrigger, turret, shooter, arc, distanceProvider, angleProvider));


        Shuffleboard.getTab("path chooser").add(autonomousChooser);
        Shuffleboard.getTab("path chooser").addNumber("X",
                () -> driveTrain.getPose().getX());
        Shuffleboard.getTab("path chooser").addNumber("Y",
                () -> driveTrain.getPose().getY());
        Shuffleboard.getTab("path chooser").addNumber("heading",
                () -> driveTrain.getHeading());
    }

    public Command getSelectedCommand() {
        return autonomousChooser.getSelected();
    }

    public SendableChooser<Command> getAutonomousChooser() {
        return autonomousChooser;
    }
}
