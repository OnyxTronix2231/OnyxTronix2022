package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class AutonomousShuffleboard {

    private final SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain) {
        autonomousChooser = new SendableChooser<>();

//        autonomousChooser.setDefaultOption("1 ball from low point", new LowOneBall(driveTrain));
//        autonomousChooser.addOption("5 balls from upper start point", new Upper5Balls(driveTrain));
//        autonomousChooser.addOption("2 balls from upper start point", new UpperTwoBalls(driveTrain));
//        autonomousChooser.addOption("1 ball and 1 enemy ball from upper start", new Upper1BallAnd1EnemyBall(driveTrain));
//        autonomousChooser.addOption("1 ball and 1 enemy ball from low point", new Low1BallAndEnemyBall(driveTrain));
        autonomousChooser.addOption("one meter forward", new MeterForwardTest(driveTrain));

        Shuffleboard.getTab("path chooser").add(autonomousChooser);
    }

    public Command getSelectedCommand() {
        return autonomousChooser.getSelected();
    }

    public SendableChooser<Command> getAutonomousChooser() {
        return autonomousChooser;
    }
}
