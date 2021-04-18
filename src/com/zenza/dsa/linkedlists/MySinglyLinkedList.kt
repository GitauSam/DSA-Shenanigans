package com.zenza.dsa.linkedlists

class MySinglyLinkedList {

    private class Node(val item: Int) {
        var next: Node? = null
    }

    lateinit var x: Integer

    private var head: Node? = null
    private var tail: Node? = null

    fun addFirst(listItem: Int) {
        val newNode = Node(listItem)
        head
            ?.let {
                newNode.next = head as Node
                head = newNode
            }?: run {
                head = newNode
                tail = newNode
            }
    }

    fun addLast(listItem: Int) {
        val newNode = Node(listItem)
        tail
            ?.let {
                it.next = newNode
                tail = newNode
            }?: run {
                head = newNode
                tail = newNode
            }
    }

    fun removeFirst() {
        head
            ?.let {
                when (listHasOneNode()) {
                    true -> {
                        head = null
                        tail = null
                    }
                    else -> {
                        var second: Node? = it.next
                        head = null
                        head = second
                        second = null
                    }
                }
            }?: run {
                throw NoSuchElementException()
            }
    }

    fun removeLast() {
        tail
            ?.let {
                when (listHasOneNode()) {
                    true -> {
                        head = null
                        tail = null
                    }
                    else -> {
                        val previousNode = getPreviousNode()
                        previousNode
                                ?.let {
                                    tail = null
                                    previousNode.next = null
                                    tail = previousNode
                                }?: run {
                                    throw RuntimeException()
                                }
                    }
                }
            }?: run {
                throw NoSuchElementException()
            }
    }

    fun indexOf(candidate: Int): Int {
        var index = 0
        head
            ?.let {
                var current: Node? = head!!
                current
                    ?.let {
                        while (current?.next != null) {
                            if (current!!.item == candidate) return index
                            current = current!!.next
                            index++
                        }
                }

            }?: run {
                throw NoSuchElementException()
            }

        return -1
    }

    fun contains(candidate: Int): Boolean {
        return indexOf(candidate) != -1
    }

    private fun listHasOneNode(): Boolean {
        head
            ?.let {
                return head == tail
            }?: run {
                throw NoSuchElementException()
            }
    }

    private fun getPreviousNode(): Node? {
        var current = head!!

        while (current.next != null) {
            if (current.next == tail) return current
            current = current.next!!
        }

        return null
    }

}