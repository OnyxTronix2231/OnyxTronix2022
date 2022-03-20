package frc.robot.stabilizers.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.stabilizers.Stabilizer;

public class StabilizerShuffleBoard {
    private final Stabilizer stabilizer;
    private NetworkTableEntry setSpeed;
    private NetworkTableEntry setSpeedLeft;
    private NetworkTableEntry setSpeedRight;

    public StabilizerShuffleBoard(Stabilizer stabilizer) {
        this.stabilizer = stabilizer;
    }

    public void init() {
        Shuffleboard.getTab("Climber").addNumber("Stabilizer encoder units", stabilizer::getEncoderUnits);
    }
}
