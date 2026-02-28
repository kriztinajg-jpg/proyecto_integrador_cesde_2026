package co.edu.cesdega.models;
//creo un extend porque estas clases heredan lo mismo de persona
//Cuando es igual con los mismos atributos, de la clase que heredamos no se deben crear nuevos getter y setters
public class Teacher  extends Person{

    public Teacher() {
    }
    public Teacher(Long userId, String code, String documentNumber, String firstName, String lastName, Boolean status) {
        super(userId, code, documentNumber, firstName, lastName, status);
    }
        @Override
                public String toString() {
            return "student" + super.toString();
        }


}
