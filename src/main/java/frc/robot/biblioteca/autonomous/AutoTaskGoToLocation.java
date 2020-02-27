package frc.robot.biblioteca.autonomous;

import frc.robot.RobotConstants;
import frc.robot.biblioteca.BasicPID;
import frc.robot.biblioteca.HuskyPigeon;
import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToLocation extends AutoTask {
    private Drive m_drive;
    private HuskyPigeon m_pigeon;
    private HuskyVector2D m_currentPosition;
    private HuskyVector2D m_targetPosition;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_rotatePID;
    private BasicPID m_drivePID;
    public AutoTaskGoToLocation(Drive drive, HuskyVector2D targetPosition) {
        m_drive = drive;
        m_targetPosition = targetPosition;
        m_rotatePID = new BasicPID();
        m_rotatePID.setP(RobotConstants.rotateP);
        m_rotatePID.setI(RobotConstants.rotateI);
        m_rotatePID.setD(RobotConstants.rotateD);
        m_rotatePID.setMinOutput(-0.5);
        m_rotatePID.setMaxOutput(0.5);
        m_drivePID = new BasicPID();
        m_drivePID.setP(RobotConstants.driveP);
        m_drivePID.setI(RobotConstants.driveI);
        m_drivePID.setD(RobotConstants.driveD);
        m_drivePID.setMinOutput(-0.5);
        m_drivePID.setMaxOutput(0.5);
    }
    @Override
    public void Init() {
        m_isComplete = false;
    }
    @Override
    public void Run() {
        m_currentPosition = m_drive.getLoc();
        m_currentHeading = m_pigeon.getValue().getX();
        m_targetHeading = Math.atan2(m_targetPosition.getY()-m_currentPosition.getY(), m_targetPosition.getY()-m_currentPosition.getY());

        m_rotatePID.setPosition(m_currentHeading);
        m_rotatePID.setTarget(m_targetHeading);
        m_drivePID.setPosition(0);
        m_drivePID.setTarget(Math.sqrt(
            Math.pow(Math.abs(m_targetPosition.getX()-m_currentPosition.getX()),2)+
            Math.pow(Math.abs(m_targetPosition.getY()-m_currentPosition.getY()),2)));
        
        m_drive.setTwist(m_rotatePID.calculateError());
        if(Math.abs(m_rotatePID.getError()) < RobotConstants.rotateTolerance) {
            m_drive.setForward(m_drivePID.calculateError());
        }
        if(Math.abs(m_drivePID.getError()) < RobotConstants.driveTolerance) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
    }
}
