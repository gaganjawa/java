package com.java.array;

public class ImplementingTwoStacksUsingOneArray {

	public static void main(String[] args) {
		TwoStacks<Integer> tS = new TwoStacks<Integer>(5);
        tS.push1(11);
        tS.push1(3);
        tS.push1(7);
        tS.push2(1);
        tS.push2(9);

        System.out.println(tS.pop1());
        System.out.println(tS.pop2());
        System.out.println(tS.pop2());
        System.out.println(tS.pop2());
        System.out.println(tS.pop1());
    }  

}
