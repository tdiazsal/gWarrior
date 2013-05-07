package com.commons;

public abstract class gameObject {
	public int id;
	public abstract void move(float tvelocity);
	public abstract void attack();
	public abstract void get();
	public abstract void set();
	public abstract void rotate(int tdegree);
}
