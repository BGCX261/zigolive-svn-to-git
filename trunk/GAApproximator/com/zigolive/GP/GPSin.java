package com.zigolive.GP;

import java.lang.reflect.Constructor;

public class GPSin {
	private static double[] sample;
	private static Genome[] pop;
	protected static final Class[] classes = new Class[]{Plus.class,												Plus.class,
													Minus.class,
													Multi.class,
													Divide.class,
													Mod.class,};

	
	public GPSin() {
		sample = new double[100];
		
		for(int i = 0 ; i < 100; i++){
			sample[i] = Math.sin(i/10);
		}
		
		
		pop = new Genome[2];
		Terminal t = new Terminal(0);
		for(int i=0;i<pop.length;i++){
			pop[i] = new Genome(t,10);
		}
		execPop();
	}
	
	public void execPop(){
		for(int i=0;i<pop.length;i++){
			Genome g = pop[i];
			System.out.println(g.execute(5));
		}
	}
	
	public abstract class Node{
		
		public abstract double getValue();
	}
	
	public class Terminal extends Node{
		
		private double value;
		
		public Terminal(double value){
			this.value = value;
		}
		public void setValue(double v){
			value = v;
		}
		public double getValue(){
			return value;
		}
		
	}
	
	public abstract class BinaryNode extends Node{
		
		protected Node left;
		protected Node right;
		private String op;
		public BinaryNode(Node left, Node right,String oop) {
			this.left = left;
			this.right= right;
			op = oop;
		}
		public String toString(){
			return left.toString() + op + right.toString();
		}
	}
	
	public class Plus extends BinaryNode{
		
		public Plus(Node left, Node right) {
			super(left,right,"+");
		}
		@Override
		public double getValue() {
			// TODO Auto-generated method stub
			return left.getValue() + right.getValue();
		}
	}
	
	public class Minus extends BinaryNode{
		
		public Minus(Node left, Node right) {
			super(left,right,"-");
		}
		@Override
		public double getValue() {
			// TODO Auto-generated method stub
			return left.getValue() - right.getValue();
		}
	}
	
	public class Multi extends BinaryNode{
		
		public Multi(Node left, Node right) {
			super(left,right,"*");
		}
		@Override
		public double getValue() {
			// TODO Auto-generated method stub
			return left.getValue() * right.getValue();
		}
	}
	
	
	public class Divide extends BinaryNode{
		
		public Divide(Node left, Node right) {
			super(left,right,"/");
		}
		@Override
		public double getValue() {
			// TODO Auto-generated method stub
			return left.getValue() / right.getValue();
		}
	}
			
	public class Mod extends BinaryNode{
		
		public Mod(Node left, Node right) {
			super(left,right,"%");
		}
		@Override
		public double getValue() {
			// TODO Auto-generated method stub
			return left.getValue() % right.getValue();
		}
	}
	
	public class Genome
	{
		private Terminal arg;
		private BinaryNode head;
		private int size;
		private boolean argSet = false;
		
		public Genome(Terminal a, int size) {
			arg = a;
			this.size = size;
			int start = (int)Math.random()*classes.length;
			try{
				Class headClass = classes[start];
				Constructor<Node> cons = headClass.getConstructor(new Class[]{Node.class,Node.class});
				//new Plus(null,null);
				Node left = construct();
				Node right = construct();
				head = (BinaryNode)cons.newInstance(new Object[]{left,right});
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		private Node construct(){
			try{
				if(size>0){
					size--;
					int start = (int)Math.random()*classes.length;
					Class headClass = classes[start];
					Constructor<Node> cons = headClass.getConstructor(new Class[]{Node.class,Node.class});
					if(Math.random()<0.5){
						Node left = construct();
						Node right = construct();
						return (BinaryNode)cons.newInstance(new Object[]{left,right});
					}
					else{
						Node left = construct();
						Node right = construct();
						return (BinaryNode)cons.newInstance(new Object[]{left,right});
					}
				}else{
					Node n;
					if(Math.random()<0.05 || !argSet){
						n = arg;
						argSet = !argSet;
					}else{
						n = new Terminal(Math.random()*10);
					}
					return n;
				}
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		public double execute(double argVal){
			arg.setValue(argVal);
			return head.getValue();
		}
	}
	
	public static void main(String[] args) {
		new GPSin();
	}
}
