package frc.robot.biblioteca.autonomous;
import frc.robot.biblioteca.RoboBaseClass;
public class AutoController extends RoboBaseClass {
    private AutoTask[] m_taskList;
    private AutoTask m_currentTask;
    private boolean m_active;
    private int m_taskNumber;
    public AutoController() {
        super();
    }
    public void Init() {
        System.out.println("Init!");
        m_taskNumber = 0;
        m_taskList = new AutoTask[] {new AutoTaskOutput("Test1"), new AutoTaskOutput("Test2"), new AutoTaskOutput("Test3")};
        m_currentTask = m_taskList[0];
    }
    public void gatherInfo() {
        if(m_active) {
            if(m_currentTask.IsComplete()) {
                m_currentTask.OnComplete();
                m_taskNumber ++;
                if(m_taskNumber < m_taskList.length) {
                    m_currentTask = m_taskList[m_taskNumber];
                    m_currentTask.Init();
                } else {
                    m_active = false;
                }
            }
        }
    }
    public void doActions() {
        if(m_active) {
            m_currentTask.Run();
        }
    }
    public void setActive(boolean active) {
        m_active = active;
    }
}