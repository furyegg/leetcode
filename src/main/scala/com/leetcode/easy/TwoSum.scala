package com.leetcode.easy

object Solution {
  
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val indexedNums = nums.zipWithIndex.sortBy(t => t._1)
    for (i <- 0 until indexedNums.size) {
      val res = find(nums, i, target)
      if (res.isDefined) return Array(i, res.get)
    }
    Array()
  }
  
  def find(nums: Array[Int], i: Int, target: Int): Option[Int] = {
  
  }
  
  def doFind(nums: Array[Int], start: Int, end: Int, i: Int, target: Int, p: (Int, Int) => Boolean) {
  
  }
  
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 1, 7)
    twoSum(nums, 9)
  }
}