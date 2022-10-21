package net.demo.oops;

public class Main {
    static class Student {
        String className;
        public Student(String className) {
            this.className = className;
        }
    }
    public static void main(String[] args) {
        Student student = new Student("Bio");
    }
}
