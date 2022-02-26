package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class AutonomousShuffleboard {

    Command upper5Balls;
    Command upper2Balls;
    Command upperBallAndEnemyBall;
    Command lowOneBall;
    Command low1BallAndEnemyBall;

    public SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain) {
        autonomousChooser = new SendableChooser<>();
        upper2Balls = new UpperTwoBalls(driveTrain);
        upper5Balls = new Upper5Balls(driveTrain);
        upperBallAndEnemyBall = new UpperBallAndEnemyBall(driveTrain);
        lowOneBall = new LowOneBall(driveTrain);
        low1BallAndEnemyBall = new Low1BallAndEnemy1(driveTrain);

        SmartDashboard.putData(autonomousChooser);

        autonomousChooser.setDefaultOption("1 ball from lower start point",lowOneBall);
        autonomousChooser.addOption("5 balls from upper start point",upper5Balls);
        autonomousChooser.addOption("2 balls from upper start point",upper2Balls);
        autonomousChooser.addOption("one ball and enemy ball from upper start point",upperBallAndEnemyBall);
        autonomousChooser.addOption("1 ball and 1 enemy ball from low start point",low1BallAndEnemyBall);
    }

    public Command getSelectedAutoCommand() {
        return autonomousChooser.getSelected();
    }

}
