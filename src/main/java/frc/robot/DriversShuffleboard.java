package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class DriversShuffleboard {

    Command upperTarmacTo5AllianceBalls;
    Command upperTarmacTo2AllianceBalls;
    Command upperTarmacToAllianceAndEnemyBall;
    Command lowerTarmacToAlliance1Ball;
    Command lowerTarmacToAllianceBallEnemyBalls;
    SendableChooser<Command> autonomousChooser;

    public DriversShuffleboard(DriveTrain driveTrain) {

        autonomousChooser = new SendableChooser<>();
        new UpperTarmacTo2UpperAllianceBalls(driveTrain);
        new UpperTarmacTo5AllianceBalls(driveTrain);
        new UpperTarmacToAllianceAndEnemyBalls(driveTrain);
        new LowerTarmacToAlliance1Ball(driveTrain);
        new LowerTarmacToAllianceBallEnemyBalls(driveTrain);
        SmartDashboard.putData(autonomousChooser);

        autonomousChooser.setDefaultOption("upper tarmac to 5 alliance balls",upperTarmacTo5AllianceBalls);
        autonomousChooser.addOption("upper tarmac to 2 alliance balls",upperTarmacTo2AllianceBalls);
        autonomousChooser.addOption("upper tarmac to alliance and enemy ball",upperTarmacToAllianceAndEnemyBall);
        autonomousChooser.addOption("lower tarmac to one alliance ball",lowerTarmacToAlliance1Ball);
        autonomousChooser.addOption("lower tarmac to alliance ball and enemy ball",lowerTarmacToAllianceBallEnemyBalls);
    }

    public Command getSelectedAutoCommand() {
        return autonomousChooser.getSelected();
    }
}
