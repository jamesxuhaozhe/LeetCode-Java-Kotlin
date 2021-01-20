package nowcoder

import "fmt"

func driver() {
	s1 := []int{1, 1, 1}
	s2 := []int{1, 2, 2}
	s3 := []int{1, 3, 2}
	s4 := []int{2, 1}
	s5 := []int{1, 4, 4}
	s6 := []int{2, 2}
	ops := make([][]int, 0)
	ops = append(ops, s1)
	ops = append(ops, s2)
	ops = append(ops, s3)
	ops = append(ops, s4)
	ops = append(ops, s5)
	ops = append(ops, s6)

	fmt.Println(LRU(ops, 3))
}

func LRU(operators [][]int, k int) []int {
	// write code here
	cache := NewLRUCache(k)
	res := make([]int, 0)
	for _, v := range operators {
		if len(v) == 2 {
			res = append(res, cache.Get(v[1]))
		} else if len(v) == 3 {
			cache.Set(v[1], v[2])
		}
		//cache.printContent()
	}
	return res
}

type DListNode struct {
	key  int
	val  int
	next *DListNode
	prev *DListNode
}

type LRUCache interface {
	Set(key, value int)
	Get(key int) int
}

type DefaultLRUCache struct {
	mapping map[int]*DListNode
	size    int
	head    *DListNode
	tail    *DListNode
}

func NewLRUCache(size int) *DefaultLRUCache {
	head := &DListNode{key: 0, val: 0, next: nil, prev: nil,}
	tail := &DListNode{key: 0, val: 0, next: nil, prev: head,}
	head.next = tail
	return &DefaultLRUCache{
		mapping: make(map[int]*DListNode, 0),
		size:    size,
		head:    head,
		tail:    tail,
	}
}

func (cache *DefaultLRUCache) Set(key, value int) {
	if n, ok := cache.mapping[key]; ok {
		n.val = value
		cache.moveToFirst(n)
	} else {
		if len(cache.mapping) < cache.size {
			node := &DListNode{key: key, val: value, next: nil, prev: nil,}
			cache.mapping[key] = node
			cache.addToFirst(node)
		} else {
			node := &DListNode{key: key, val: value, next: nil, prev: nil,}
			cache.mapping[key] = node
			cache.addToFirst(node)
			cache.removeLast()
		}
	}
}

func (cache *DefaultLRUCache) Get(key int) int {
	if n, ok := cache.mapping[key]; !ok {
		return -1
	} else {
		cache.moveToFirst(n)
		return n.val
	}
}

func (cache *DefaultLRUCache) addToFirst(node *DListNode) {
	nodeAfterHead := cache.head.next

	cache.head.next = node
	node.prev = cache.head

	node.next = nodeAfterHead
	nodeAfterHead.prev = node
}

func (cache *DefaultLRUCache) moveToFirst(node *DListNode) {
	nodeBefore := node.prev
	nodeAfter := node.next
	nodeBefore.next = nodeAfter
	nodeAfter.prev = nodeBefore

	nodeAfterHead := cache.head.next
	cache.head.next = node
	node.prev = cache.head
	nodeAfterHead.prev = node
	node.next = nodeAfterHead
}

func (cache *DefaultLRUCache) removeLast() {
	lastNode := cache.tail.prev
	if lastNode == cache.head {
		return
	}
	delete(cache.mapping, lastNode.key)
	oneBeforeLast := cache.tail.prev.prev
	oneBeforeLast.next = cache.tail
	cache.tail.prev = oneBeforeLast
}

func (cache *DefaultLRUCache) printContent() {
	runner := cache.head
	for runner != nil {
		fmt.Print(runner.val)
		runner = runner.next
	}
	fmt.Println()
}