package co.edu.cesdega.app;
import co.edu.cesdega.models.Person;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Teacher;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Person person=new Person();
        Person person2=new Person();
        Person person3=new Person();
        Student student1=new Student();
        //creacion de estudiante con constructor vacio
        student1.setUserId(2L);
        student1.getUserId();
        student1.setFirstName("Ana");
        student1.getFirstName();
        //asi imprimimos por consola el nombre
        System.out.println(student1.getFirstName());
        student1.setLastName("Medina");
        student1.getLastName();
        student1.setDocumentNumber("1036756855");
        student1.getDocumentNumber();
        student1.setStatus(true);
        student1.getStatus();
        student1.setCode("A02");
        student1.getCode();
        student1.setBirthyear("1997");
        student1.getBirthyear();

        // creacion de estudiante 2 con constructor lleno
        Student student2 = new Student(3L, "A03", "103676855", "Andrea", "Goez", true, "1996");
        System.out.println(student2);

        //creacion de teacher con constructor vacio
        Teacher teacher1= new Teacher();
        teacher1.setUserId(3L);
        teacher1.getUserId();
        teacher1.setFirstName("Julian");
        teacher1.getFirstName();
        //asi imprimimos por consola el nombre
        System.out.println(teacher1.getFirstName());
        teacher1.setLastName("Quintero");
        teacher1.getLastName();
        teacher1.setDocumentNumber("1036262897");
        teacher1.getDocumentNumber();
        teacher1.setStatus(true);
        teacher1.getStatus();
        teacher1.setCode("A02");
        teacher1.getCode();

        // creacion de teacher 3 con constructor lleno
        Teacher teacher2 = new Teacher(4L, "A04", "103676857", "Mario", "Mendoza", true);
        System.out.println(teacher2);







// ejemplo con cosntructor vacio
        person.setFirstName("Jhon");
        person.getFirstName();
        person2.setFirstName("Juan");
        person2.getFirstName();
        person3.setFirstName("Erica");
        person3.getFirstName();
// ejemplo usando constructor lleno
        Person person4 = new Person(1L, "A01", "111", "Cris", "García", true);

//llamar override
        System.out.println(person4);
    }
}
