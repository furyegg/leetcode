package com.leetcode.easy

object MergeTwoSortedLists {
  
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }
  
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null) return l2
    if (l2 == null) return l1
    if (l1.x < l2.x) {
      l1.next = mergeTwoLists(l1.next, l2)
      l1
    } else {
      l2.next = mergeTwoLists(l1, l2.next)
      l2
    }
  }
  
  def mergeTwoLists2(l1: ListNode, l2: ListNode): ListNode = {
    if (l1 == null) return l2
    if (l2 == null) return l1
    
    var list1 = l1
    var list2 = l2
    var merge: ListNode = null
    var result: ListNode = null
    
    while (list1 != null && list2 != null) {
      if (list1.x == list2.x) {
        val node1 = list1
        val node2 = list2
        if (merge == null) {
          list1 = list1.next
          list2 = list2.next
          
          merge = node1
          result = merge
          merge.next = node2
          merge = merge.next
        } else {
          list1 = list1.next
          list2 = list2.next
          
          merge.next = node1
          merge.next.next = node2
          merge = merge.next.next
        }
      } else if (list1.x < list2.x) {
        if (merge == null) {
          merge = list1
          result = merge
          list1 = list1.next
        } else {
          while (list1 != null && list1.x < list2.x) {
            merge.next = list1
            merge = merge.next
            list1 = list1.next
          }
        }
      } else {
        if (merge == null) {
          merge = list2
          result = merge
          list2 = list2.next
        } else {
          while (list2 != null && list2.x < list1.x) {
            merge.next = list2
            merge = merge.next
            list2 = list2.next
          }
        }
      }
    }
    
    if (list1 != null) merge.next = list1
    if (list2 != null) merge.next = list2
    
    result
  }

  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
    test4()
    test5()
    test6()
    test7()
  }
  
  def test1(): Unit = {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(4)
    node1.next = node2
    node2.next = node3
    
    val node4 = new ListNode(1)
    val node5 = new ListNode(3)
    val node6 = new ListNode(4)
    node4.next = node5
    node5.next = node6
    
    val merge = mergeTwoLists(node1, node4)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test2(): Unit = {
    val node1 = new ListNode(2)
    val node2 = new ListNode(1)
    
    val merge = mergeTwoLists(node1, node2)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test3(): Unit = {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    
    val merge = mergeTwoLists(node1, node2)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test4(): Unit = {
    val node1 = new ListNode(1)
    val node2 = new ListNode(2)
    val node3 = new ListNode(4)
    node1.next = node2
    node2.next = node3
    
    val node4 = new ListNode(1)
    val node5 = new ListNode(3)
    val node6 = new ListNode(4)
    val node7 = new ListNode(5)
    node4.next = node5
    node5.next = node6
    node6.next = node7
    
    val merge = mergeTwoLists(node1, node4)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test5(): Unit = {
    val node1 = new ListNode(5)
    
    val node4 = new ListNode(1)
    val node5 = new ListNode(3)
    val node6 = new ListNode(4)
    node4.next = node5
    node5.next = node6
    
    val merge = mergeTwoLists(node1, node4)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test6(): Unit = {
    val node1 = new ListNode(5)
    
    val node4 = new ListNode(1)
    val node5 = new ListNode(3)
    val node6 = new ListNode(4)
    node4.next = node5
    node5.next = node6
    
    val merge = mergeTwoLists(node4, node1)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
  def test7(): Unit = {
    val node1 = new ListNode(-10)
    val node2 = new ListNode(-10)
    val node3 = new ListNode(-9)
    val node4 = new ListNode(-4)
    val node5 = new ListNode(1)
    val node6 = new ListNode(6)
    val node7 = new ListNode(6)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    
    val node10 = new ListNode(-7)
    
    val merge = mergeTwoLists(node1, node10)
    var node = merge
    while (node != null) {
      println(node.x)
      node = node.next
    }
    println
  }
  
}