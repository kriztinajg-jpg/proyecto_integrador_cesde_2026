package co.edu.cesdega.models;

public class Subject {
    private Long subjectId;
    private String code;
    private String name;
    private int credits;
    private Program program;

    public Subject() {
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Subject(Long subjectId, Program program, int credits, String code, String name) {
        this.subjectId = subjectId;
        this.program = program;
        this.credits = credits;
        this.code = code;
        this.name = name;
    }
}