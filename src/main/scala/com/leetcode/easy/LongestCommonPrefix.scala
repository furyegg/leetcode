package com.leetcode.easy

object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    val arrs = strs.sortBy(s => s.size).map(s => s.toCharArray)
    val len = arrs(0).size
    
    var i = 0
    while (i < len) {
      
      
      i = i + 1
    }
    val s = ""
  }
  
  def main(args: Array[String]): Unit = {
    println(longestCommonPrefix(Array("flower", "flow", "flight")))
    println(longestCommonPrefix(Array("dog", "racecar", "car")))
  }
}
