package frc.robot.crossPlatforms;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;
import java.util.function.DoubleSupplier;

public class ArcAndShooterCommands extends ParallelCommandGroup {

    public ArcAndShooterCommands(Arc arc, Shooter shooter, DoubleSupplier rpmSupplier , DoubleSupplier angleSupplier) {
        super(
                new MoveArcToAngle(arc, angleSupplier),
                new ShootByRPM(shooter, rpmSupplier)
        );
    }
}
