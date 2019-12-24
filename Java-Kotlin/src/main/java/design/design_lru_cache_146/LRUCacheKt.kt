package design.design_lru_cache_146

class LRUCacheKt(capacity: Int) {



    private var capacity = capacity

    private var size = 0

    private val head = DoubleLinkedNode()

    private val tail = DoubleLinkedNode()

    private val cache = HashMap<Int, DoubleLinkedNode>()

    init {
        head.next = tail
        tail.prev = head
    }


    fun get(key: Int): Int {
        if (cache.containsKey(key)) {
            val node = cache[key]
            moveToHead(node!!)
            return node.value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (cache.containsKey(key)) {
            val node = cache[key]
            node!!.value = value
            moveToHead(node)
        } else {
            val node = DoubleLinkedNode()
            node.key = key
            node.value = value
            cache[key] = node
            addNode(node)
            size++
            if (size > capacity) {
                val last = popTail()
                cache.remove(last.key)
                size--
            }
        }
    }

    private fun addNode(node: DoubleLinkedNode) {
        node.prev = head
        node.next = head.next
        head.next!!.prev = node
        head.next = node

    }

    private fun removeNode(node: DoubleLinkedNode) {
        val prev = node.prev
        val next = node.next
        prev!!.next = next
        next!!.prev = prev

    }

    private fun moveToHead(node: DoubleLinkedNode) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): DoubleLinkedNode {
        val last = tail.prev
        removeNode(last!!)
        return last
    }


    class DoubleLinkedNode {
        var key = 0

        var value = 0

        var prev: DoubleLinkedNode? = null

        var next: DoubleLinkedNode? = null
    }
}