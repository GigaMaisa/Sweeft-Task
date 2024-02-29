class CustomDataStructure<T> {
    private val data = mutableMapOf<T, Node<T>>()
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    inner class Node<T>(val value: T) {
        var next: Node<T>? = null
        var previous: Node<T>? = null
    }

    fun remove(element: T) {
        val nodeToRemove = data[element]

        if (nodeToRemove != null) {
            if (nodeToRemove == head) head = nodeToRemove.next
            if (nodeToRemove == tail) tail = nodeToRemove.previous

            nodeToRemove.previous?.next = nodeToRemove.next
            nodeToRemove.next?.previous = nodeToRemove.previous

            data.remove(element)
        }
    }

    fun add(element: T) {
        if (data.containsKey(element)) return

        val newNode = Node(element)
        data[element] = newNode

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            newNode.previous = tail
            tail = newNode
        }
    }

    fun getItems(): List<T> {
        val result = mutableListOf<T>()
        var current = head

        while (current != null) {
            result.add(current.value)
            current = current.next
        }

        return result
    }
}