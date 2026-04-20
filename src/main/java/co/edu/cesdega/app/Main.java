package co.edu.cesdega.app;

import co.edu.cesdega.Service.GradeService;
import co.edu.cesdega.Service.impl.GradeServiceImpl;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Teacher;
import co.edu.cesdega.repository.GradeRepository;
import co.edu.cesdega.repository.impl.GradeRepositoryinMemory;

import java.util.List;


public class Main {public static void main(String[] args) {
    System.out.println("--- INICIANDO SISTEMA CESDEGA 2026 ---");

    // 1. Instanciamos el repositorio y el servicio (Inyección de Dependencias)
    GradeRepository gradeRepository = new GradeRepositoryinMemory();
    GradeService gradeService = new GradeServiceImpl(gradeRepository);

    // 2. Creamos un estudiante de prueba
    // Usamos el constructor que creamos en Person/Student
    // Agregamos "2015-05-20" al final
    Student estudianteUno = new Student(10L, "EST-001", "CC", "12345", "Martin", "Giraldo", "ACTIVO", "2015-05-20");
    // 3. Vamos a registrar una nota para Martin
    Grade notaFinal = new Grade();
    notaFinal.setStudentId(estudianteUno.getUserId()); // Relacionamos la nota con Martin
    notaFinal.setFinalScore(4.8);

    System.out.println("Intentando registrar nota...");
    gradeService.registrarNota(notaFinal);

    // 4. Vamos a probar la validación: Intentemos poner un 6.0 (Debe fallar)
    Grade notaErronea = new Grade();
    notaErronea.setStudentId(estudianteUno.getUserId());
    notaErronea.setFinalScore(6.0);

    System.out.println("\nProbando validación de nota máxima...");
    gradeService.registrarNota(notaErronea);

    // 5. Consultamos el boletín para ver si se guardó la de 4.8
    System.out.println("\n--- BOLETÍN DE " + estudianteUno.getFirstName() + " ---");
    List<Grade> notasDeMartin = gradeService.consultarBoletin(estudianteUno.getUserId());

    for (Grade g : notasDeMartin) {
        System.out.println("Nota: " + g.getFinalScore());
    }
}
}