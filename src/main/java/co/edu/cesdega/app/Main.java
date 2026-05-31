package co.edu.cesdega.app;

import co.edu.cesdega.Service.GradeService;
import co.edu.cesdega.Service.EnrollmentService;
import co.edu.cesdega.Service.impl.GradeServiceImpl;
import co.edu.cesdega.Service.impl.EnrollmentServiceImpl;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Group;
import co.edu.cesdega.models.Enrollment;
import co.edu.cesdega.repository.GradeRepository;
import co.edu.cesdega.repository.EnrollmentRepository;
import co.edu.cesdega.repository.impl.GradeRepositoryinMemory;
import co.edu.cesdega.repository.impl.EnrollmentRepositoryinMemory; // Asegúrate de que se llame así tu repo en memoria
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA CESDEGA 2026 ---");

        // ==========================================
        // 1. INSTANCIAS DE SERVICIOS
        // ==========================================
        GradeRepository gradeRepository = new GradeRepositoryinMemory();
        GradeService gradeService = new GradeServiceImpl(gradeRepository);

        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryinMemory();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(enrollmentRepository);

        // ==========================================
        // 2. CREACIÓN DE DATOS DE PRUEBA
        // ==========================================
        Student estudianteUno = new Student(10L, "EST-001", "CC", "12345", "Martin", "Giraldo", "ACTIVO", "2015-05-20");

        Group grupoSistemas = new Group();
        grupoSistemas.setGroupId(1L);
        grupoSistemas.setCode("DEV-2026");

        // ==========================================
        // 3. PRUEBAS DEL SERVICIO DE NOTAS (Ya funcionando)
        // ==========================================
        System.out.println("\n--- PRUEBAS DE CAPA DE NOTAS ---");
        Grade notaFinal = new Grade();
        notaFinal.setStudentId(estudianteUno.getStudentId());
        notaFinal.setFinalScore(4.8);

        try {
            gradeService.registrarNota(notaFinal);
        } catch (ValidationException e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        // Probar nota errónea de 6.0
        Grade notaErronea = new Grade();
        notaErronea.setStudentId(estudianteUno.getStudentId());
        notaErronea.setFinalScore(6.0);

        try {
            gradeService.registrarNota(notaErronea);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR NOTAS] -> " + e.getMessage());
        }

        // ==========================================
        // 4. PRUEBAS DEL SERVICIO DE MATRÍCULAS (¡Lo nuevo!)
        // ==========================================
        System.out.println("\n--- PRUEBAS DE CAPA DE MATRÍCULAS ---");

        // Prueba A: Matrícula Inválida (Sin grupo a propósito)
        Enrollment matriculaMalita = new Enrollment();
        matriculaMalita.setStudent(estudianteUno);
        matriculaMalita.setGroup(null); // Provocará la excepción

        try {
            System.out.println("[SISTEMA] Intentando matricular estudiante sin grupo...");
            enrollmentService.matricularEstudiante(matriculaMalita);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR MATRÍCULAS] -> " + e.getMessage());
        }

        // Prueba B: Matrícula Válida
        Enrollment matriculaValida = new Enrollment();
        matriculaValida.setStudent(estudianteUno);
        matriculaValida.setGroup(grupoSistemas);

        try {
            System.out.println("\n[SISTEMA] Intentando matricular correctamente...");
            enrollmentService.matricularEstudiante(matriculaValida);
        } catch (ValidationException e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        System.out.println("\n--- SISTEMA FINALIZADO CON ÉXITO ---");
    }
}