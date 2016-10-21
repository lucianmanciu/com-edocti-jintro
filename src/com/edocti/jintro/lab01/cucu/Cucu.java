package com.edocti.jintro.lab01.cucu;

/**
 * Dummy class meant for you to compile from command line and get used
 * to the idea of packages and their location
 * 
 * When we compile, we compile from the root folder:
 * javac com/edocti/jintro/lab01/cucu/*.java
 * 
 * Then we run the application like this:
 * java com.edocti.jintro.lab01.cucu.Cucu
 * 
 * How it works:
 * the default classpath is . (current folder)
 * You are running the application from the root folder => the class loader will 
 * look inside . (current folder) and search for any class named com.edocti.jintro.lab01.cucu.Cucu
 * 
 * It finds it and runs it.
 * 
 * => Note that while compiling you are giving javac the path to the java file, while running 
 * the FQN (full qualified name) of the class has nothing to do with the path
 * 
 * It's just that the FQN ressembles the filesystem path.
 * 
 * @author pianas
 *
 */
public class Cucu {

	public static void main(String[] args) {
		System.out.println("Cucu");
	}
}
