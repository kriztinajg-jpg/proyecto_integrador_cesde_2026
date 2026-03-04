package co.edu.cesdega.models;

public class Program {
   private Long programId;
   private String code;
   private String name;

    public Program() {
    }

    public Program(String name, String code, Long programId) {
        this.name = name;
        this.code = code;
        this.programId = programId;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
