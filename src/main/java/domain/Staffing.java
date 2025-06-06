package domain;

import java.time.LocalDateTime;

public class Staffing {
    //id(int)), registerDate(LocalDateTime), employeeId(int), employeeName(String),
    //jobPosition(String), supervisor(String), assignmentType(String)
    //b. Métodos: getters, setters, toString
    private int id;
    private LocalDateTime registerDate;
    private int employeeId;
    private String employeeName;
    private String jobPosition;
    private String supervisor;
    private String assignmentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    @Override
    public String toString() {
        return "Staffing{" +
                "id=" + id +
                ", registerDate=" + registerDate +
                ", employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", assignmentType='" + assignmentType + '\'' +
                '}';
    }
}
