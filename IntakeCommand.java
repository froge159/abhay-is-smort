package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase{
    // extend pistons bfore intaking
    // retract piston after intaking
    private final IntakeSubsystem intakeSubsystem;
    public IntakeCommand(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }
    @Override
    public void initialize() {
        intakeSubsystem.stop();
        intakeSubsystem.extend();
    }
    @Override
    public void execute() {
        intakeSubsystem.intake();
    }
    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.stop();
        intakeSubsystem.retract();
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
