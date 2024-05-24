package dao

import entity.Student
import storage.{
  CsvStorage, 
  Storage
}

class StudentDaoImpl extends StudentDao {
  
  private val storage: Storage = CsvStorage()

  override def create(student: Student): Unit = storage.create(student)

  override def update(student: Student): Unit = storage.update(student)

  override def delete(id: String): Unit = storage.delete(id)

  override def findById(id: String): Option[Student] = storage.findById(id)

  override def findAll(): List[Student] = storage.findAll()
}
