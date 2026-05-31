package co.edu.cesdega.models;

public abstract class Person {

    protected Long userId;
    protected String code;
    protected String documentType;
    protected String documentNumber;
    protected String firstName;
    protected String lastName;
    protected String status;

    public Person() {}

    // 2. Ajustamos el constructor para que reciba y guarde el userId
    public Person(Long userId, String code, String documentType, String documentNumber,
                  String firstName, String lastName, String status) {
        this.userId = userId;
        this.code = code;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
    }

    // CORREGIDO: Ahora este constructor no está vacío, invoca al de arriba pasándole null al userId
    public Person(String code, String documentType, String documentNumber, String firstName, String lastName, String status) {
        this(null, code, documentType, documentNumber, firstName, lastName, status);
    }

    // --- GETTERS Y SETTERS ---

    // 3. Agregamos el Getter y Setter para el ID
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDocumentType() { return documentType; }
    public void setDocumentType(String documentType) { this.documentType = documentType; }

    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}