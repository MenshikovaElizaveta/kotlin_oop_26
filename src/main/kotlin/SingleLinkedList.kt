package org.example

class SingleLinkedList : CustomList {

    private val inner = mutableListOf<Int>()

    override val size: Int
        get() = inner.size

    override fun add(element: Int) {
        inner.add(element)
    }

    override operator fun set(index: Int, value: Int) {
        inner[index] = value
    }

    override fun addFirst(element: Int) {
        inner.add(0, element)
    }

    override operator fun get(index: Int): Int {
        return inner[index]
    }


    override fun indexOf(element: Int): Int {
        return inner.indexOf(element)
    }

    override fun remove(element: Int): Boolean {
        return inner.remove(element)
    }

    override fun iterator(): Iterator<Int> {
        return object : Iterator<Int> {
            private var currentIndex = 0

            override fun hasNext(): Boolean {
                return currentIndex < inner.size
            }

            override fun next(): Int {
                if (!hasNext()) throw NoSuchElementException()
                return inner[currentIndex++]
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