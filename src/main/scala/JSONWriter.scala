package com.emirates.fcsr.ssimparser.util


object JSONWriter {
  def main(args: Array[String]): Unit = {
    val path = "c:/path/file.txt"
    println(path.substring(0, path.lastIndexOf("/"))+"path")
  }

  def anyRefToJsonString(scalaValue: AnyRef): String = {
    import com.google.gson.Gson

    val gson = new Gson
    val jsonString = gson.toJson(scalaValue)
    jsonString
  }
}