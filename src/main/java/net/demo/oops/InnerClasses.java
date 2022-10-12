package net.demo.oops;

public class InnerClasses {
    private int innerClassVariable = 1;

    private static int staticVariable = 1;

    public void logMessage() {
        int logMessageVariable = 2; // this is effectively final because we are not modifying it.
        //logMessageVariable++; // this will result error in method getLocalVariable()
        class LocalClass {
            //static boolean canNOTDefineStatic = flase; // error
            boolean canDefineNotStatic = true;
            public int getLocalVariable() {
                return innerClassVariable + logMessageVariable + staticVariable;
            }
        }
    }
    private class PrivateInnerClass {
        public void logMessage() {
            System.out.println("inside PrivateInnerClass" + innerClassVariable);
        }
    }

    public class PublicInnerClass {
        public void logMessage() {
            System.out.println("inside PublicInnerClass" + innerClassVariable);
        }
    }

    class DefaultInnerClass {
        public void logMessage() {
            System.out.println("inside DefaultInnerClass" + innerClassVariable);
        }
    }

    public static class StaticInnerClass {
        public void logMessage() {
            System.out.println("inside StaticInnerClass" + staticVariable);// can not access non-static variable
        }
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.logMessage();

        InnerClasses innerClasses = new InnerClasses();
        // PublicInnerClass can be accessed/instantiated from within the InnerClasses or from any other class
        InnerClasses.PublicInnerClass publicInnerClass = innerClasses.new PublicInnerClass();
        //InnerClasses.PublicInnerClass publicInnerClass = new InnerClasses.PublicInnerClass(); // error
        //PublicInnerClass publicInnerClass = new PublicInnerClass(); // error
        publicInnerClass.logMessage();

        // PrivateInnerClass can be accessed/instantiated only from within the InnerClasses
        InnerClasses.PrivateInnerClass privateInnerClass = innerClasses.new PrivateInnerClass();
        privateInnerClass.logMessage();

        // DefaultInnerClass can be accessed/instantiated only from within the same package
        InnerClasses.DefaultInnerClass defaultInnerClass = innerClasses.new DefaultInnerClass();
        defaultInnerClass.logMessage();
    }
}
