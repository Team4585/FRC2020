/*----------------------------------------------------------------------------*/
/* Copym_right (c) 2017-2018 FIRST. All m_rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.biblioteca.HuskyJoystick;
import frc.robot.biblioteca.HuskyPigeon;
import frc.robot.biblioteca.HuskyTalon;
import frc.robot.biblioteca.LimeLightCamera;
import frc.robot.biblioteca.RoboBaseClass;
import frc.robot.biblioteca.autonomous.AutoController;
import frc.robot.biblioteca.autonomous.AutoTaskLimeLightRotate;
//import frc.robot.biblioteca.basesubsystem.MecanumDrive;
import frc.robot.subsystem.ControlPanel;
import frc.robot.subsystem.Intake;
import frc.robot.subsystem.Output;
import java.util.*;
import java.io.*;

//Testing

public class Robot extends TimedRobot {
  // MecanumDrive m_driveTrain;
  Output m_shooter;
  Intake m_intake;
  ControlPanel m_colorWheel;

  HuskyTalon front_left;
  HuskyTalon back_left;
  HuskyTalon front_right;
  HuskyTalon back_right;

  HuskyPigeon gyro;
  HuskyTalon ball_forward;
  HuskyTalon ver_shooter;

  HuskyJoystick m_driveControl;
  HuskyJoystick m_weaponsControl;

  LimeLightCamera m_limeLight;
  AutoController m_autoController;
  AutoTaskLimeLightRotate m_autoRotate;
  CameraServer cam;

  double speedSum;
  double speedCount;
  int waitTime;
  boolean m_doIntake;
  boolean m_doHelix;

  chassis m_theChassis;
  NewJoystick m_theJoystick;

  @Override
  public void robotInit() {
    
    front_left = new HuskyTalon(1);
    back_left = new HuskyTalon(3);
    front_right = new HuskyTalon(2);
    back_right = new HuskyTalon(4);
    //m_driveTrain = new MecanumDrive(front_left, front_right, back_left, back_right);
    //m_driveTrain = new Laika();
    // m_shooter = new Deathstar();
    //m_intake = new TractorBeam();
    // m_colorWheel = new ControlPanelWrapper();
    //ver_shooter = new HuskyTalon(0);
    gyro = new HuskyPigeon(0);
    m_driveControl = new HuskyJoystick(0);
    m_weaponsControl = new HuskyJoystick(1);
    m_driveControl.setDeadZone(RobotConstants.joystickDeadZone);
    //m_limeLight = new LimeLightCamera();
    cam = CameraServer.getInstance();
    cam.startAutomaticCapture();


    //m_autoController = new AutoController();
    //m_autoRotate = new AutoTaskLimeLightRotate(m_driveTrain, m_shooter, m_limeLight);
    SmartDashboard.putNumber("Forward Axis", 1);
    SmartDashboard.putNumber("TwistAxis", 2);
    SmartDashboard.putNumber("StrafeAxis", 0);
    SmartDashboard.putNumber("AimAxis", 2);
    SmartDashboard.putNumber("Aim Override Button", 1);
    SmartDashboard.putNumber("Shoot Button", 1);
    SmartDashboard.putNumber("Intake Button", 2);
    SmartDashboard.putNumber("Helix Button", 3);
    SmartDashboard.putNumber("Joystick Deadzones", 0.25);

    m_theChassis = new chassis();
    m_theJoystick = new NewJoystick();
  }
  @Override
  public void robotPeriodic() {
  }
  @Override
  public void autonomousInit() {
    //m_autoController.Init(m_driveTrain, m_limeLight);
    //m_autoController.setActive(true);
  }
  @Override
  public void autonomousPeriodic() {
    //Cry
    RoboBaseClass.gatherInfoAll();
    RoboBaseClass.doActionsAll();
  }
  @Override
  public void teleopInit() {
    RobotConstants.forwardAxis = (int) SmartDashboard.getNumber("Forward Axis", 1);
    RobotConstants.twistAxis = (int) SmartDashboard.getNumber("Twist Axis", 2);
    RobotConstants.strafeAxis = (int) SmartDashboard.getNumber("Strafe Axis", 0);
    RobotConstants.aimAxis = (int) SmartDashboard.getNumber("Aim Axis", 1);
    RobotConstants.aimOverrideButton = (int) SmartDashboard.getNumber("Aim Override Button", 1);
    RobotConstants.shootButton = (int) SmartDashboard.getNumber("Shoot Button", 1);
    RobotConstants.intakeButton = (int) SmartDashboard.getNumber("Intake Button", 2);
    RobotConstants.helixButton = (int) SmartDashboard.getNumber("Helix Button", 3);
    RobotConstants.joystickDeadZone = (int) SmartDashboard.getNumber("Joystick Deadzones", 0.25);
    //m_autoRotate.Init();
  }
  @Override
  public void teleopPeriodic() {
    //ver_shooter.set(m_driveControl.getAxis(1));
    //System.out.println((m_driveControl.getButton(11)));
    RoboBaseClass.gatherInfoAll();
    double[] stuff = {gyro.getHeading().getX(), gyro.getHeading().getY(), gyro.getHeading().getZ()};
    System.out.println("Gyro Heading:" + Arrays.toString(stuff) );
    if(m_driveControl.getButton(RobotConstants.aimOverrideButton)) {
      m_autoRotate.Run();
    } else {
      m_theChassis.setVals(m_driveControl.getAxis(RobotConstants.forwardAxis), m_driveControl.getAxis(RobotConstants.twistAxis), m_driveControl.getAxis(RobotConstants.strafeAxis));
      m_theChassis.chassisDoActions();
    //  m_driveTrain.setForward(m_driveControl.getAxis(RobotConstants.forwardAxis));
    //  m_driveTrain.setTwist(m_driveControl.getAxis(RobotConstants.twistAxis));
    //  m_driveTrain.setStrafe(m_driveControl.getAxis(RobotConstants.strafeAxis));
      // m_driveTrain.setForward(0);
      // m_driveTrain.setTwist(0);
      // m_driveTrain.setStrafe(0);
      double speed = m_weaponsControl.getAxis(3);
    }
    //m_shooter.rotateY(m_weaponsControl.getAxis(RobotConstants.aimAxis));
    //m_shooter.setShoot(m_weaponsControl.getButton(RobotConstants.shootButton)?RobotConstants.shootSpeed:0);
    
    // if(m_weaponsControl.getButtonPressed(RobotConstants.intakeButton)) {
    //   m_doIntake = !m_doIntake;
    // }
    // if(m_weaponsControl.getButtonPressed(RobotConstants.helixButton)) {
    //   m_doHelix = !m_doHelix;
    // }
    // m_doIntake = false;
    // m_doHelix = m_weaponsControl.getButtonPressed(RobotConstants.helixButton);
    // m_intake.intake(m_doIntake?RobotConstants.intakeSpeed:0, m_doHelix?RobotConstants.helixSpeed:0);

    // if(m_weaponsControl.getButton(9)) {
    //   m_colorWheel.goToColor(RobotConstants.colorBlue);
    // } else if(m_weaponsControl.getButton(10)) {
    //   m_colorWheel.goToColor(RobotConstants.colorGreen);
    // } else if(m_weaponsControl.getButton(11)) {
    //   m_colorWheel.goToColor(RobotConstants.colorRed);
    // } else if(m_weaponsControl.getButton(12)) {
    //   m_colorWheel.goToColor(RobotConstants.colorYellow);
    // } else {
    //   m_colorWheel.setMotorController(m_weaponsControl.getButton(8)?RobotConstants.colorSpinnerSpeed:0);
    // }

    RoboBaseClass.doActionsAll();
  }
  @Override
  public void testPeriodic() {
    //RoboBaseClass.gatherInfoAll();
    // m_doIntake = false;
    // m_doHelix = m_weaponsControl.getButton(RobotConstants.helixButton);
    // m_intake.intake(m_doIntake?RobotConstants.intakeSpeed:0, m_doHelix?RobotConstants.helixSpeed:0);
    //m_shooter.shoot(0.2);
    //RoboBaseClass.doActionsAll();
  }
}
// woo code