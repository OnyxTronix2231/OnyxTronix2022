package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class AutonomousShuffleboard {

    Command Upper5Balls;
    Command UpperTwoBalls;
    Command Upper1BallAnd1EnemyBall;
    Command LowOneBall;
    Command Low1BallAndEnemyBall;

    private SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain) {
        autonomousChooser = new SendableChooser<Command>();
        UpperTwoBalls = new UpperTwoBalls(driveTrain);
        Upper5Balls = new Upper5Balls(driveTrain);
        Upper1BallAnd1EnemyBall = new Upper1BallAnd1EnemyBall(driveTrain);
        LowOneBall = new LowOneBall(driveTrain);
        Low1BallAndEnemyBall = new Low1BallAndEnemyBall(driveTrain);

        autonomousChooser.setDefaultOption("1 ball from low point",LowOneBall);
        autonomousChooser.addOption("5 balls from upper start point",Upper5Balls);
        autonomousChooser.addOption("2 balls from upper start point",UpperTwoBalls);
        autonomousChooser.addOption("1 ball and 1 enemy ball from upper start",Upper1BallAnd1EnemyBall);
        autonomousChooser.addOption("1 ball and 1 enemy ball from low point",Low1BallAndEnemyBall);

        SmartDashboard.putData(autonomousChooser);
    }

    public Command getSelectedAutoCommand() {
        return autonomousChooser.getSelected();
    }

    public SendableChooser<Command> getAutonomousChooser() {
        return autonomousChooser;
    }
}
