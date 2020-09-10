package com.java.array;

public class TwoStacks<V> {

	private int maxSize;
	private int top1, top2;
	private V[] array;
	
	@SuppressWarnings("unchecked")
	public TwoStacks(int max_size) {
		this.maxSize = max_size;
		top1=-1;
		top2 = max_size;
		array = (V[]) new Object[max_size];
	}

	void push1(V value) {
		if (top1 < top2-1) {
			array[++top1] = value;
		}	
	}
	
	void push2(V value) {
		if (top1 < top2-1) {
			array[--top2] = value;
		}
	}
	
	V pop1() {
		if (top1>-1) {
			return array[top1--];
		}
		return null;
	}
	
	V pop2() {
		if (top2<maxSize) {
			return array[top2++];
		}
		return null;
	}
}
