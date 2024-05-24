package storage

import entity.Student

import java.util.UUID
import scala.annotation.tailrec

trait FileStorage extends Storage {

  protected var students: List[Student] = List()

  override def create(student: Student): Unit = {
    readStudentsFromFile()
    students = Student(generateId(), student.firstName, student.lastName, student.age) +: students
    writeStudentsToFile()
  }

  override def update(student: Student): Unit = {
    readStudentsFromFile()
    students = students.updated(students.indexWhere(s => s.id == student.id), student)
    writeStudentsToFile()
  }

  override def delete(id: String): Unit = {
    readStudentsFromFile()
    students = students.filterNot(s => s.id == id)
    writeStudentsToFile()
  }

  override def findById(id: String): Option[Student] = {
    readStudentsFromFile()
    students.find(s => s.id == id)
  }

  override def findAll(): List[Student] = {
    readStudentsFromFile()
    students
  }
  
  @tailrec
  private def generateId(): String = {
    val id: String = UUID.randomUUID().toString
    if (students.exists(s => s.id == id)) generateId() else id
  }

  def readStudentsFromFile(): Unit
  def writeStudentsToFile(): Unit
}
