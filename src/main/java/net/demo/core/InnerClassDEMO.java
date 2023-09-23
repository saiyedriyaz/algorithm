package net.demo.core;

import net.demo.oops.OuterClasse;

public class InnerClassDEMO {
    public static void main(String[] args) {
        OuterClasse.StaticInnerClass staticInnerClass = new OuterClasse.StaticInnerClass();
        staticInnerClass.logMessage();

        OuterClasse innerClasses = new OuterClasse();
        // PublicInnerClass can be accessed/instantiated from within the InnerClasses or from any other class
        OuterClasse.PublicInnerClass publicInnerClass = innerClasses.new PublicInnerClass();
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
