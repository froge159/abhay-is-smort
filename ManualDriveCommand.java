package frc.robot.commands;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ManualDriveCommand extends CommandBase{
    private final DriveSubsystem driveSubsystem;
    private final OI oi;

    public ManualDriveCommand(DriveSubsystem driveSubsystem, OI oi) {
        this.driveSubsystem = driveSubsystem;
        this.oi = oi;
        addRequirements(driveSubsystem);
    }
    @Override
    public void initialize() {
        driveSubsystem.stop();
    }

    @Override
    public void execute() {
        double speed = oi.getAxis(0, OI.Axes.LEFT_STICK_Y);
        double rotation = oi.getAxis(0, OI.Axes.RIGHT_STICK_X);
        driveSubsystem.arcadeDrive(speed, rotation);
    }
    @Override
    public void end(boolean Interrupted) {
        driveSubsystem.stop();
    }
    @Override
    public boolean isFinished() {
        return false;
    }

}
