package dao

import entity.Student

trait StudentDao {
  def create(student: Student): Unit
  def update(student: Student): Unit
  def delete(id: String): Unit
  def findById(id: String): Option[Student]
  def findAll(): List[Student]
}
