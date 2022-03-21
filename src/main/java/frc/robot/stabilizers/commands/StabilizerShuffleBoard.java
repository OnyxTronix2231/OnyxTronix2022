package frc.robot.stabilizers.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.stabilizers.Stabilizers;

public class StabilizerShuffleBoard {
    private final Stabilizers stabilizer;
    private NetworkTableEntry setSpeed;
    private NetworkTableEntry setSpeedLeft;
    private NetworkTableEntry setSpeedRight;

    public StabilizerShuffleBoard(Stabilizers stabilizer) {
        this.stabilizer = stabilizer;
    }

    public void init() {
        Shuffleboard.getTab("Climber").addNumber("Stabilizer encoder units", stabilizer::getEncoderUnits);
    }
}
