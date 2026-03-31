package org.example

class SingleLinkedList : CustomList {

    private data class Node(var value: Int, var next: Node? = null)

    private var head: Node? = null
    private var _size: Int = 0

    override val size: Int
        get() = _size

    override fun add(element: Int) {
        if (head == null) {
            head = Node(element)
        } else {
            var current = head
            while (current!!.next != null) {
                current = current.next
            }
            current.next = Node(element)
        }
        _size++
    }

    override operator fun set(index: Int, value: Int) {
        if (index < 0 || index >= _size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $_size")
        }
        var current = head
        for (i in 0 until index) {
            current = current!!.next
        }
        current!!.value = value
    }

    override fun addFirst(element: Int) {
        head = Node(element, head)
        _size++
    }

    override operator fun get(index: Int): Int {
        if (index < 0 || index >= _size) {
            throw IndexOutOfBoundsException("Index: $index, Size: $_size")
        }
        var current = head
        for (i in 0 until index) {
            current = current!!.next
        }
        return current!!.value
    }


    override fun indexOf(element: Int): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (current.value == element) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    override fun remove(element: Int): Boolean {
        if (head == null) return false

        if (head!!.value == element) {
            head = head!!.next
            _size--
            return true
        }

        var current = head
        while (current!!.next != null) {
            if (current.next!!.value == element) {
                current.next = current.next!!.next
                _size--
                return true
            }
            current = current.next
        }
        return false
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var current = head

            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                val value = current!!.value
                current = current!!.next
                return value
            }
        }
    }

    companion object {
        fun singleLinkedListOf(vararg items: Int) =
            items.fold(SingleLinkedList()) { list, item ->
                list.also{ it.add(item) }
            }
    }
}