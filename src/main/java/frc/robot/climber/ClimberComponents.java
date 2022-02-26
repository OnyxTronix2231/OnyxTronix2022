package frc.robot.climber;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import sensors.counter.TalonEncoder;

public interface ClimberComponents {

    WPI_TalonFX getRightMotor();

    WPI_TalonFX getLeftMotor();

    DoubleSolenoid getDoubleSolenoid();
}
