package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem;

public class OuttakeCommand extends CommandBase {
    // run the intake motor reverse
    // make sure pistons are retracted whie outtaking
    private final IntakeSubsystem intakeSubsystem;
    public OuttakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void initialize() {
        intakeSubsystem.stop();
        intakeSubsystem.retract();
    }
    @Override
    public void execute() {
        intakeSubsystem.outtake();
    }
    @Override
    public void end(boolean Interrupted) {
        intakeSubsystem.stop();
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
