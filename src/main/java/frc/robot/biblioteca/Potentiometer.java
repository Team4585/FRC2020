package frc.robot.biblioteca;
import frc.robot.biblioteca.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Potentiometer extends AnalogInput {
    private int m_port;
    private AnalogPotentiometer m_p;
    public Potentiometer(int port) {
        super(-1, 1);
        m_port = port;
        m_p = new AnalogPotentiometer(port);
    }
    @Override
    public void gatherInfo() {
        setValue(m_p.get());
    }
    public int getPort(){
        return m_port;
    }
}
