package co.edu.cesdega.models;

public class Group {
    private Long groupId;
    private String code;
    private Program program;
    private Period period;
    private String shift;

    public Group() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Group(String shift, Period period, Program program, String code, Long groupId) {
        this.shift = shift;
        this.period = period;
        this.program = program;
        this.code = code;
        this.groupId = groupId;

    }
}
