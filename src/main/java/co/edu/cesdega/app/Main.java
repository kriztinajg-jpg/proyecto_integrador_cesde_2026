package co.edu.cesdega.app;

import co.edu.cesdega.Service.GradeService;
import co.edu.cesdega.Service.EnrollmentService;
import co.edu.cesdega.Service.TeacherService;
import co.edu.cesdega.Service.GroupService;
import co.edu.cesdega.Service.impl.GradeServiceImpl;
import co.edu.cesdega.Service.impl.EnrollmentServiceImpl;
import co.edu.cesdega.Service.impl.TeacherServiceImpl;
import co.edu.cesdega.Service.impl.GroupServiceImpl;
import co.edu.cesdega.models.Grade;
import co.edu.cesdega.models.Student;
import co.edu.cesdega.models.Group;
import co.edu.cesdega.models.Enrollment;
import co.edu.cesdega.models.Teacher;
import co.edu.cesdega.repository.GradeRepository;
import co.edu.cesdega.repository.EnrollmentRepository;
import co.edu.cesdega.repository.TeacherRepository;
import co.edu.cesdega.repository.GroupRepository; // ¡Importante para que reconozca la interfaz del repositorio!
import co.edu.cesdega.repository.impl.GradeRepositoryinMemory;
import co.edu.cesdega.repository.impl.EnrollmentRepositoryinMemory;
import co.edu.cesdega.repository.impl.TeacherRepositoryinMemory;
import co.edu.cesdega.repository.impl.GroupRepositoryinMemory; // ¡Importante para instanciar el repositorio en memoria!
import co.edu.cesdega.exceptions.ValidationException;
import co.edu.cesdega.exceptions.ResourceNotFoundException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO SISTEMA CESDEGA 2026 ---");

       //instanciamiento
        GradeRepository gradeRepository = new GradeRepositoryinMemory();
        GradeService gradeService = new GradeServiceImpl(gradeRepository);

        EnrollmentRepository enrollmentRepository = new EnrollmentRepositoryinMemory();
        EnrollmentService enrollmentService = new EnrollmentServiceImpl(enrollmentRepository);

        TeacherRepository teacherRepository = new TeacherRepositoryinMemory();
        TeacherService teacherService = new TeacherServiceImpl(teacherRepository);

        GroupRepository groupRepository = new GroupRepositoryinMemory();

        GroupService groupService = new GroupServiceImpl(groupRepository);

        //Datos de prueba
        Student estudianteUno = new Student(10L, "EST-001", "CC", "12345", "Martin", "Giraldo", "ACTIVO", "2015-05-20");

        Group grupoSistemas = new Group();
        grupoSistemas.setGroupId(1L);
        grupoSistemas.setCode("DEV-2026");

       //Pruebas de notas
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

        //prueba de matricula
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

       //prueba de profe
        System.out.println("\n--- PRUEBAS DE CAPA DE PROFESORES ---");

        // Prueba A: Intentar registrar un profesor sin documento (Debería fallar)
        Teacher profeInvalido = new Teacher();
        profeInvalido.setFirstName("Sandra");
        profeInvalido.setLastName("Restrepo");
        profeInvalido.setDocumentNumber(""); // Vacío a propósito

        try {
            System.out.println("[SISTEMA] Intentando registrar profesor sin documento...");
            teacherService.registrarProfesor(profeInvalido);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR PROFESORES] -> " + e.getMessage());
        }

        // Prueba B: Registrar un profesor válido
        Teacher profeValido = new Teacher();
        profeValido.setFirstName("Alejandro");
        profeValido.setLastName("Martínez");
        profeValido.setDocumentNumber("987654321");

        try {
            System.out.println("\n[SISTEMA] Intentando registrar profesor válido...");
            teacherService.registrarProfesor(profeValido);
        } catch (ValidationException e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        // Prueba C: Intentar registrar el MISMO profesor otra vez (Duplicado - Debería fallar)
        try {
            System.out.println("\n[SISTEMA] Intentando registrar el mismo documento otra vez...");
            teacherService.registrarProfesor(profeValido);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR PROFESORES] -> " + e.getMessage());
        }

        // Prueba D: Buscar un profesor que NO existe por ID
        try {
            System.out.println("\n[SISTEMA] Buscando profesor con ID inexistente (999)...");
            teacherService.buscarPorId(999L);
        } catch (ResourceNotFoundException e) {
            System.out.println("[CONTROL DE ERROR BUSQUEDA] -> " + e.getMessage());
        }

       //prueba para grupos
        System.out.println("\n--- PRUEBAS DE CAPA DE GRUPOS ---");

        // Prueba A: Intentar crear un grupo sin código (Debería fallar)
        Group grupoInvalidoCodigo = new Group();
        grupoInvalidoCodigo.setCode(""); // Vacío
        grupoInvalidoCodigo.setShift("Noche");

        try {
            System.out.println("[SISTEMA] Intentando crear grupo sin código...");
            groupService.crearGrupo(grupoInvalidoCodigo);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR GRUPOS] -> " + e.getMessage());
        }

        // Prueba B: Intentar crear un grupo sin jornada (Debería fallar)
        Group grupoInvalidoTurno = new Group();
        grupoInvalidoTurno.setCode("DEV-2026-B");
        grupoInvalidoTurno.setShift(""); // Vacío

        try {
            System.out.println("\n[SISTEMA] Intentando crear grupo sin jornada...");
            groupService.crearGrupo(grupoInvalidoTurno);
        } catch (ValidationException e) {
            System.out.println("[CONTROL DE ERROR GRUPOS] -> " + e.getMessage());
        }

        // Prueba C: Crear un grupo válido
        Group grupoValidoNoche = new Group();
        grupoValidoNoche.setCode("DEV-2026-NOCHE");
        grupoValidoNoche.setShift("Noche");

        try {
            System.out.println("\n[SISTEMA] Intentando crear un grupo correcto...");
            groupService.crearGrupo(grupoValidoNoche);
        } catch (ValidationException e) {
            System.out.println("[ALERTA] " + e.getMessage());
        }

        System.out.println("\n--- SISTEMA FINALIZADO CON ÉXITO ---");
    }
}