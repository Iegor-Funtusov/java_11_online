package controller

import dao.{StudentDao, StudentDaoImpl}
import entity.Student

import scala.io.StdIn.{readInt, readLine}

class StudentController {

  private val dao: StudentDao = StudentDaoImpl()
  
  def start(): Unit = {
    println("Welcome to app")
    menu()
    var command = ""
    while (command != "exit") {
      command = readLine()
      operations(command)
      menu()
    }
  }

  private def menu(): Unit = {
    println("If you want create student please enter 1")
    println("If you want find all student please enter 2")
    println("If you want find by id student please enter 3")
    println("If you want update student please enter 4")
    println("If you want delete student please enter 5")
    println("If you want exit please enter exit")
  }
  
  private def operations(command: String): Unit = {
    command match
      case "1" => create()
      case "2" => findAll()
      case "3" => findById()
      case "4" => update()
      case "5" => delete()
  }
  
  private def create(): Unit = {
    println("Please enter the first name of the student")
    val firstName: String = readLine()
    println("Please enter the last name of the student")
    val lastName: String = readLine()
    println("Please enter the age of the student")
    val age: Int = readInt()
    dao.create(Student("", firstName, lastName, age))
  }
  
  private def findAll(): Unit = {
    dao.findAll().foreach(student => println(student))
  }
  
  private def findById(): Unit = {
    println("Please enter the id of the student")
    val id: String = readLine()
    val student: Student = dao.findById(id).get
    println(student)
  }
  
  private def update(): Unit = {
    println("Please enter the id of the student")
    val id: String = readLine()
    println("Please enter the first name of the student")
    val firstName: String = readLine()
    println("Please enter the last name of the student")
    val lastName: String = readLine()
    println("Please enter the age of the student")
    val age: Int = readInt()
    dao.update(Student(id, firstName, lastName, age))
  }
  
  private def delete(): Unit = {
    println("Please enter the id of the student")
    val id: String = readLine()
    dao.delete(id)
  }
}
