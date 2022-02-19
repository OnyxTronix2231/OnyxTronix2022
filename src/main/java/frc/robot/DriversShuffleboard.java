package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.crossPlatform.autonomousCommands.pathCommands.*;
import frc.robot.drivetrain.DriveTrain;

public class DriversShuffleboard {

    SendableChooser<Command> autonomousChooser;


    public DriversShuffleboard(DriveTrain driveTrain){

        autonomousChooser = new SendableChooser<>();
        new UpperTarmacTo2UpperAllianceBalls(driveTrain);
        new UpperTarmacTo5AllianceBalls(driveTrain);
        new UpperTarmacToAllianceAndEnemyBalls(driveTrain);
        new LowerTarmacToAlliance1Ball(driveTrain);
        new LowerTarmacToAllianceBallEnemyBalls(driveTrain);
        SmartDashboard.putData(autonomousChooser);
    }

    public Command getSelectedAutoCommand(){
        return autonomousChooser.getSelected();
    }
}
