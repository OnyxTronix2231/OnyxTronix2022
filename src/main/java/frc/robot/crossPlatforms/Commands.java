package frc.robot.crossPlatforms;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.arc.Arc;
import frc.robot.arc.commands.MoveArcToAngle;
import frc.robot.shooter.Shooter;
import frc.robot.shooter.commands.ShootByRPM;
import java.util.function.DoubleSupplier;

public class Commands extends ParallelCommandGroup {
    public Commands(Arc arc, Shooter shooter, DoubleSupplier rpmSupplier , DoubleSupplier angleSupplier) {
        super(
                new ShootByRPM(shooter, rpmSupplier),
                new MoveArcToAngle(arc, angleSupplier)
        );
    }
}
