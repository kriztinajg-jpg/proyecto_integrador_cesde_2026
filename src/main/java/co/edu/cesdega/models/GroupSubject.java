package co.edu.cesdega.models;

public class GroupSubject {
    private Long groupSubjectId;
    private Group group;
    private Subject subject;
    private Teacher teacher;

    public GroupSubject() {
    }

    public GroupSubject(Long groupSubjectId, Group group, Subject subject, Teacher teacher) {
        this.groupSubjectId = groupSubjectId;
        this.group = group;
        this.subject = subject;
        this.teacher = teacher;
    }

    public Long getGroupSubjectId() {
        return groupSubjectId;
    }

    public void setGroupSubjectId(Long groupSubjectId) {
        this.groupSubjectId = groupSubjectId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

