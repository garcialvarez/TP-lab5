package org.example;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;
import org.example.repository.GradeUsingFileRepositoryImpl;
import org.example.service.AcademicRecordService;
import org.example.service.AcademicRecordServiceImpl;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;


public class ApplicationRunner {

  static void printGrades(List<Grade> gradesList){
    gradesList.forEach(System.out::println);
  }
  public static void main(String[] args) {

    AcademicRecordService academicRecordService =
        new AcademicRecordServiceImpl(new GradeUsingFileRepositoryImpl());

    System.out.println("Notas iniciales:");
    printGrades(academicRecordService.listAllGrades());

    academicRecordService.addGrade(new Grade("PARCIAL", 4.5D, LocalDate.now()));

    System.out.println("Notas despues de adicionar una nueva:");
    printGrades(academicRecordService.listAllGrades());

    System.out.println(
            MessageFormat.format(
                    "Suma de número calificaciones: {0}", academicRecordService.sumNumberOfGrades()));

    System.out.println(
            MessageFormat.format("Promedio: {0}", academicRecordService.calculateAverage()));

    System.out.println("Consulta una nota de un proyecto que no existe");//El siguiente codigo debe generar una excepcion con el mensaje de "No se encontro"
    String nombreProyecto = "Unidad 10";
    try {
      System.out.println(academicRecordService.getGrade( nombreProyecto ));
    }
    catch (GradeNotFoundException e) {
      System.out.println(MessageFormat.format("No se encontró una nota para la unidad {0} ", nombreProyecto));
    }

  }
}
