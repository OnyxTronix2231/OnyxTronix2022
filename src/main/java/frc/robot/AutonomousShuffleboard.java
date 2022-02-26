package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class AutonomousShuffleboard {

    Command upperTarmacTo5AllianceBalls;
    Command upperTarmacTo2AllianceBalls;
    Command upperTarmacToAllianceAndEnemyBall;
    Command lowerTarmacToAlliance1Ball;
    Command lowerTarmacToAllianceBallEnemyBalls;

    public SendableChooser<Command> autonomousChooser;

    public AutonomousShuffleboard(DriveTrain driveTrain) {
        autonomousChooser = new SendableChooser<>();
        upperTarmacTo2AllianceBalls = new UpperTarmacTo2UpperAllianceBalls(driveTrain);
        upperTarmacTo5AllianceBalls = new UpperTarmacTo5AllianceBalls(driveTrain);
        upperTarmacToAllianceAndEnemyBall = new UpperTarmacToAllianceAndEnemyBalls(driveTrain);
        lowerTarmacToAlliance1Ball = new LowerTarmacToAlliance1Ball(driveTrain);
        lowerTarmacToAllianceBallEnemyBalls = new LowerTarmacToAllianceBallEnemyBalls(driveTrain);

        SmartDashboard.putData(autonomousChooser);

        autonomousChooser.setDefaultOption("upper tarmac to 5 alliance balls",upperTarmacTo5AllianceBalls);
        autonomousChooser.addOption("upper tarmac to 2 alliance balls",upperTarmacTo2AllianceBalls);

        autonomousChooser.addOption("lower tarmac to one alliance ball",lowerTarmacToAlliance1Ball);
        autonomousChooser.addOption("lower tarmac to alliance ball and enemy ball",lowerTarmacToAllianceBallEnemyBalls);
    }

    public Command getSelectedAutoCommand() {
        return autonomousChooser.getSelected();
    }

}
