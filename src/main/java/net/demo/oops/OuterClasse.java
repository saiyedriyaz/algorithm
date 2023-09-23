package net.demo.oops;

public class OuterClasse {
    private int innerClassVariable = 1;

    private static int staticVariable = 1;

    public PrivateInnerClass privateInnerClass = new PrivateInnerClass();

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
        private int privateIc = 999;
        public void logMessage() {
            System.out.println("inside PrivateInnerClass" + innerClassVariable);
        }
    }

    public class PublicInnerClass {
        private int publicIc = 2;
        public void logMessage() {
            System.out.println("inside PublicInnerClass" + innerClassVariable);
        }
    }

    class DefaultInnerClass {
        private int defaultIc = 3;
        public void logMessage() {
            System.out.println("inside DefaultInnerClass" + staticVariable);
        }
    }

    public static class StaticInnerClass {
        private int staticIc = 4;
        public void logMessage() {
            System.out.println("inside StaticInnerClass" + staticVariable);// can not access non-static variable
        }
    }

    static OuterClasse outerClass = new OuterClasse();

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        staticInnerClass.logMessage();

        // PublicInnerClass can be accessed/instantiated from within the InnerClasses or from any other class
        OuterClasse.PublicInnerClass publicInnerClass = outerClass.new PublicInnerClass();
        //InnerClasses.PublicInnerClass publicInnerClass = new InnerClasses.PublicInnerClass(); // error
        //PublicInnerClass publicInnerClass = new PublicInnerClass(); // error
        publicInnerClass.logMessage();

        // PrivateInnerClass can be accessed/instantiated only from within the InnerClasses
        OuterClasse.PrivateInnerClass privateInnerClass = outerClass.new PrivateInnerClass();
        privateInnerClass.logMessage();

        // DefaultInnerClass can be accessed/instantiated only from within the same package
        var defaultInnerClass = outerClass.new DefaultInnerClass();
        defaultInnerClass.logMessage();

        System.out.println("direct access="+ outerClass.privateInnerClass.privateIc);
    }
}
