package storage

import com.opencsv.{CSVReader, CSVWriter}
import com.opencsv.exceptions.CsvException
import entity.Student

import scala.jdk.CollectionConverters.*
import java.io.{File, FileReader, FileWriter, IOException}

class CsvStorage extends FileStorage {

  private val STUDENT_CSV: String = "students.csv"
  private val file: File = File(STUDENT_CSV)
  
  {
    if !file.exists() then file.createNewFile()
  }

  override def readStudentsFromFile(): Unit = {
    try {
      val reader: CSVReader = CSVReader(FileReader(file))
      students = List()
      val list = reader.readAll()
      list.asScala.toList.foreach(el =>
        students = Student(el.apply(0), el.apply(1), el.apply(2), el.apply(3).toInt) +: students
      )
      reader.close()
    } catch
      case e: CsvException => println("can't read file")
      case e: IOException => println("can't open or find file")
  }

  override def writeStudentsToFile(): Unit = {
    try {
      val writer: CSVWriter = CSVWriter(FileWriter(file))
      var list: List[Array[String]] = List()
      students.foreach(student => {
        val arr = Array(student.id, student.firstName, student.lastName, student.age.toString)
        list = arr +: list
      })
      writer.writeAll(list.asJava)
      writer.close()
    } catch
      case e: CsvException => println("can't read file")
      case e: IOException => println("can't open or find file")
  }
}
