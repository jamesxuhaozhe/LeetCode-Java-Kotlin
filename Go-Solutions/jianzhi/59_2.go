package jianzhi

import "math"

type MaxQueue struct {
	queue []int
	monotonicQueue monotonicQueue
}

type monotonicQueue struct {
	arr []int
}

func (mono *monotonicQueue) push(value int) {
	for len(mono.arr) > 0 && mono.arr[len(mono.arr) - 1] < value {
		mono.arr = mono.arr[:len(mono.arr) - 1]
	}
	mono.arr = append(mono.arr, value)
}

func (mono *monotonicQueue) len() int {
	return len(mono.arr)
}

func (mono *monotonicQueue) maxValue() int {
	if mono.len() > 0 {
		return mono.arr[0]
	}
	return math.MinInt64
}

func (mono *monotonicQueue) popMax() int {
	if mono.len() > 0 {
		max := mono.arr[0]
		mono.arr = mono.arr[1:]
		return max
	}
	return math.MinInt64
}

func Constructor_59_2() MaxQueue {
	return MaxQueue{
		queue:          make([]int, 0),
		monotonicQueue: monotonicQueue{arr:make([]int, 0)},
	}
}


func (this *MaxQueue) Max_value() int {
	if this.monotonicQueue.len() > 0 {
		return this.monotonicQueue.maxValue()
	}
	return -1
}


func (this *MaxQueue) Push_back(value int)  {
	this.monotonicQueue.push(value)
	this.queue = append(this.queue, value)
}


func (this *MaxQueue) Pop_front() int {
	if len(this.queue) == 0 {
		return -1
	}
	ans := this.queue[0]
	this.queue = this.queue[1:]
	if this.monotonicQueue.len() > 0 && ans == this.monotonicQueue.maxValue() {
		this.monotonicQueue.popMax()
	}
	return ans
}
//
//func main() {
//	arr := []int{1}
//	//first := arr[0]
//	arr = arr[1:]
//}
