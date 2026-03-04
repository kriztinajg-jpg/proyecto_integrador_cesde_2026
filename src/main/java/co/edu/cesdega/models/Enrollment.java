package co.edu.cesdega.models;

public class Enrollment {

        private Long enrollmentId;
        private Student student;
        private Group group;
        private Period period;
        private String status;

        public Enrollment() {
        }

        public Enrollment(Long enrollmentId, Student student, Group group, Period period, String status) {
            this.enrollmentId = enrollmentId;
            this.student = student;
            this.group = group;
            this.period = period;
            this.status = status;
        }

        public Long getEnrollmentId() {
            return enrollmentId;
        }

        public void setEnrollmentId(Long enrollmentId) {
            this.enrollmentId = enrollmentId;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        public Group getGroup() {
            return group;
        }

        public void setGroup(Group group) {
            this.group = group;
        }

        public Period getPeriod() {
            return period;
        }

        public void setPeriod(Period period) {
            this.period = period;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

