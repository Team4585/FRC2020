package frc.robot.biblioteca;
import edu.wpi.first.wpilibj.Joystick;
public class HuskyJoystick {
    private int m_port;
    private Joystick m_joystick;
    private double m_deadZone = 0.1;
    public HuskyJoystick(int port) {
        m_port = port;
        m_joystick = new Joystick(port);
    }
    public void setDeadZone(double zone) {
        m_deadZone = zone;
    }
    public boolean getButton(int channel) {
        return(m_joystick.getRawButton(channel));
    }
    public double getAxis(int channel) {
        double val = 0;
        if (m_joystick.getRawAxis(channel) < m_deadZone || m_joystick.getRawAxis(channel) > m_deadZone) {
            val = m_joystick.getRawAxis(channel);
        }
        return(val);
    }
    public int getPort(){
        return m_port;
    }
}