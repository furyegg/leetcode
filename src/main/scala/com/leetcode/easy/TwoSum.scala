package com.leetcode.easy

object TwoSum {
  import scala.collection.mutable.Map
  
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map: Map[Int, Int] = Map.empty
    for (i <- 0 until nums.size) {
      val num = nums(i)
      val diff = target - num
      if (map.contains(diff)) return Array(map.get(diff).get, i)
      else map.put(num, i)
    }
    Array()
  }
  
  val threshold = 10
  
  def twoSum2(nums: Array[Int], target: Int): Array[Int] = {
    val indexedNums = nums.zipWithIndex.sortBy(t => t._1)
    for (i <- 0 until indexedNums.size) {
      val num = indexedNums(i)
      val diff = target - num._1
      val res = find(indexedNums, i, indexedNums.size - 1, diff)
      if (res >= 0) return Array(num._2, res).sorted
    }
    
    Array()
  }
  
  def find(indexedNums: Array[(Int, Int)], start: Int, end: Int, n: Int): Int = {
    if (end - start <= threshold) {
      for (i <- start + 1 to end)
        if (indexedNums(i)._1 == n) return indexedNums(i)._2
      -1
    } else {
      val m = (start + end) / 2
      val middleNum = indexedNums(m)
      if (middleNum._1 == n)
        middleNum._2
      else {
        val startIndex = if (middleNum._1 <= n) m else start
        val endIndex = if (middleNum._1 <= n) end else m - 1
        find(indexedNums, startIndex, endIndex, n)
      }
    }
  }
  
  def main(args: Array[String]): Unit = {
    val nums7 = Array(230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789)
    println(twoSum(nums7, 542).toList)
    
    val nums6 = Array(0, 3, -3, 4, -1)
    println(twoSum(nums6, -1).toList)
    
    val nums5 = Array(0, 4, 3, 0)
    println(twoSum(nums5, 0).toList)
    
    val nums4 = Array(3, 3)
    println(twoSum(nums4, 6).toList)
    
    val nums1 = Array(2, 1, 7, 4, 10, 3)
    println(twoSum(nums1, 9).toList)
    
    val nums2 = Array(12, 576, 0, 731, 47, 2, 1, 7, 4, 10, 3, 26)
    println(twoSum(nums2, 9).toList)
    
    val nums3 = Array(5, 1, 7, 12, 10, 9, 3)
    println(twoSum(nums3, 9).toList)
  }
}