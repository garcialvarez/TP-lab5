package org.example.service;

import java.util.List;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;

public interface AcademicRecordService {
  Double calculateAverage();

  Integer sumNumberOfGrades();

  void printGrades(List<Grade> gradeList);


  Grade getGrade(String proyecto) throws GradeNotFoundException;

    List<Grade> listAllGrades();

	Grade addGrade(Grade newGrade);
}
