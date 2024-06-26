package com.fdmgroup.DesignPatternExercises;

import java.util.ArrayList;
import java.util.List;

public class SingletonConnectionPool {
	/* 2. Create a class which stores a list of connection objects.
	 *  In this exercise we are not concerned with the details of the connection objects. 
	 *  We want a list of prebuilt connection objects. In addition to this we only want one instance of the class to be created.
	 *  Write this class to ensure this is the case. */
	public static SingletonConnectionPool singletonConnectionPool;
	private List<Connection> connections;
	private SingletonConnectionPool() {
		connections = new ArrayList<>();
		connections.add(new Connection());
		connections.add(new Connection());
		connections.add(new Connection());
		connections.add(new Connection());
	}
	public SingletonConnectionPool getInstance() {
		if (singletonConnectionPool == null) {
			singletonConnectionPool =  new SingletonConnectionPool();
		}
		return singletonConnectionPool;
	}
	public List<Connection> getConnections() {
		return connections;
	}

}
