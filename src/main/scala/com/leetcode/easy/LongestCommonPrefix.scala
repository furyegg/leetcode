package com.leetcode.easy

object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) return ""
    
    val arrs = strs.sortBy(s => s.size).map(s => s.toCharArray)
    val len = arrs(0).size
    var res = Array[Char]()
    
    var i = 0
    while (i < len) {
      val c = arrs(0)(i)
      
      var j = 0
      while (j < arrs.size) {
        val c2 = arrs(j)(i)
        if (c != c2) return res.mkString
        j  = j + 1
      }
      
      res = res :+ c
      i = i + 1
    }
    res.mkString
  }
  
  def main(args: Array[String]): Unit = {
    println(longestCommonPrefix(Array()))
    println(longestCommonPrefix(Array("flower", "flow", "flight")))
    println(longestCommonPrefix(Array("dog", "racecar", "car")))
    println(longestCommonPrefix(Array("", "racecar", "car")))
  }
}
