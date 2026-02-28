package co.edu.cesdega.app;
import co.edu.cesdega.models.Person;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Person person=new Person();
        Person person2=new Person();
        Person person3=new Person();
// ejemplo con cosntructor vacio
        person.setFirstName("Jhon");
        person.getFirstName();
        person2.setFirstName("Juan");
        person2.getFirstName();
        person3.setFirstName("Erica");
        person3.getFirstName();
// ejemplo usando constructor lleno
        Person person4 = new Person(1L, "A01", "111", "Cris", "García", true);


    }
}
