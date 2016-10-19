package com.edocti.jintro.other;

class Person {
    private String firstName;
    private String lastName;
    private String cnp;
    private int age;
    private boolean sex;  // true => M, false => F
    
    private static int MAX_AGE = 100;
    
    // constructor
    public Person(String fn, String lastName,
                  int age, boolean sex) {
        this.firstName = fn;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        cnp = "";
    }

    public Person(String firstName, String lastName, boolean sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        age = 0;  // optional: age is anyway initialized to default int value (0)
    }

    public String toString() {  // exists in java.lang.Object
        return this.firstName + ", " + this.lastName + ", age: " + this.age + ", max age: " + this.MAX_AGE;
    }
    
    public static int getMaxAge() {
        return MAX_AGE;
    }
    
}
