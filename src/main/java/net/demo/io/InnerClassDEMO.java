package net.demo.io;

import net.demo.oops.InnerClasses;

public class InnerClassDEMO {
    public static void main(String[] args) {
        InnerClasses.StaticInnerClass staticInnerClass = new InnerClasses.StaticInnerClass();
        staticInnerClass.logMessage();

        InnerClasses innerClasses = new InnerClasses();
        // PublicInnerClass can be accessed/instantiated from within the InnerClasses or from any other class
        InnerClasses.PublicInnerClass publicInnerClass = innerClasses.new PublicInnerClass();
        //InnerClasses.PublicInnerClass publicInnerClass = new InnerClasses.PublicInnerClass(); // error
        //PublicInnerClass publicInnerClass = new PublicInnerClass(); // error
        publicInnerClass.logMessage();

        // PrivateInnerClass can be accessed/instantiated only from within the InnerClasses
        //InnerClasses.PrivateInnerClass privateInnerClass = innerClasses.new PrivateInnerClass();
        //privateInnerClass.logMessage();

        // PrivateInnerClass can be accessed/instantiated only from within the InnerClasses
        //InnerClasses.DefaultInnerClass defaultInnerClass = innerClasses.new DefaultInnerClass();
        //defaultInnerClass.logMessage();
    }
}
