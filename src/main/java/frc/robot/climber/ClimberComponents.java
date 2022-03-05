package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import sensors.counter.TalonEncoder;

public interface ClimberComponents {

    WPI_TalonFX getRightMotor();

    WPI_TalonFX getLeftMotor();

    //DoubleSolenoid getLeftDoubleSolenoid();

    DoubleSolenoid getRightDoubleSolenoid();

    TalonEncoder getLeftEncoder();

    TalonEncoder getRightEncoder();
}
