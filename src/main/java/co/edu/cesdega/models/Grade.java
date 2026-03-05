package co.edu.cesdega.models;

public class Grade {
    private Long gradeId;
    private Long groupSubjectId;
    private Long studentId;
    private Integer finalScore;
    private String observation;

    //constructor vacio
    public Grade(){
    }

    //constructor lleno
    public Grade(Long gradeId, Long groupSubjectId, Long studentId, Integer finalScore, String observation) {
        this.gradeId = gradeId;
        this.groupSubjectId = groupSubjectId;
        this.studentId = studentId;
        this.finalScore = finalScore;
        this.observation = observation;
    }

    public Long getGradeId() { return gradeId; }
    public void setGradeId(Long gradeId) { this.gradeId = gradeId; }

    public Long getGroupSubjectId() { return groupSubjectId; }
    public void setGroupSubjectId(Long groupSubjectId) { this.groupSubjectId = groupSubjectId; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Integer getFinalScore() { return finalScore; }
    public void setFinalScore(Integer finalScore) { this.finalScore = finalScore; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

    @Override
    public String toString() {
        return "gradeId=" + gradeId +
                " groupSubjectId=" + groupSubjectId +
                " studentId=" + studentId +
                " finalScore=" + finalScore +
                " observation=" + observation;
    }
}