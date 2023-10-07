package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class DriveIntakeCommand extends CommandBase {
    private final DriveSubsystem driveSubsystem;
    private final IntakeSubsystem intakeSubsystem;
    // drive forward while intaking
    public DriveIntakeCommand(IntakeSubsystem intakeSubsystem, DriveSubsystem driverSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.driveSubsystem = driverSubsystem;
        addRequirements(intakeSubsystem, driverSubsystem);
    }
    @Override
    public void initialize() {
        intakeSubsystem.stop();
        driveSubsystem.stop();
    }
    @Override
    public void execute() {
        intakeSubsystem.intake();
        driveSubsystem.drive(1);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean Interrupted) {
        intakeSubsystem.stop();
        driveSubsystem.stop();
    }
}
