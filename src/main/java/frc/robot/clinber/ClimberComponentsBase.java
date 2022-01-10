package frc.robot.clinber;

import static frc.robot.clinber.ClimberConstants.ClimberConstantsA.BACKWARD_CHANNEL;
import static frc.robot.clinber.ClimberConstants.ClimberConstantsA.FORWARD_CHANNEL;

import com.ctre.phoenix.motorcontrol.IMotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class ClimberComponentsBase implements ClimberComponents {

    private WPI_TalonFX motor;
    private DoubleSolenoid solenoid;

    public ClimberComponentsBase() {
        motor = new WPI_TalonFX(0);
        motor.configFactoryDefault();

        solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, FORWARD_CHANNEL, BACKWARD_CHANNEL);
    }

    @Override
    public IMotorController motor() {
        return motor;
    }

    @Override
    public DoubleSolenoid solenoid() {
        return solenoid;
    }

}
