package net.demo.security;

import java.io.*;

class EncryptedPersonInfo implements Serializable {
    String name;
    char[] peselNumber;
    public EncryptedPersonInfo(String name, String peselNumber) {
        this.name = name;
        this.peselNumber = peselNumber.toCharArray();
    }
}
class PersonInfo implements Serializable {
    // option 1 - declare non-serialisable fields as transient
    // option 2 - whitelist - include on the allowed fields
    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("name", String.class)
    };

    private Object writeReplace()  {
        System.err.println("1. inside writeReplace");
        return new EncryptedPersonInfo(this.name, this.peselNumber);
    }

    // if you want to customise the serialization process, implement this method
   /* private void writeObject(ObjectOutputStream oos) throws Exception {
        System.out.println("2. inside writeObject");
        //oos.defaultWriteObject(); // default

        // or whitelisted below
        ObjectOutputStream.PutField putFields = oos.putFields();
        putFields.put("name", ">>"+name+"<<"); // name is encoded with prefix and suffix
        oos.writeFields();
    }*/

    private Object readResolve() throws ObjectStreamException {
        System.err.println("3. inside readResolve");
        PersonInfo newPerson = new PersonInfo();
        return newPerson;
    }

    // if you want to customise the de-serialization process, implement this method
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        System.out.println("4. inside readObject");
        //ois.defaultReadObject(); // default

        ObjectInputStream.GetField getFields = ois.readFields();
        name = (String) getFields.get("name","NOT-ASSIGNED");
        name = name.replace(">>", "__");
        name = name.replace("<<", "--");

        //ois.readObject();
    }

    String name;
    String peselNumber;
}

public class DeserializeDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var out = new ObjectOutputStream(new FileOutputStream("person2"));
        var person = new PersonInfo();
        person.name = "riyaz";
        person.peselNumber = "1234";
        out.writeObject(person);

        var in = new ObjectInputStream(new FileInputStream("person2"));
        EncryptedPersonInfo dePerson = (EncryptedPersonInfo) in.readObject();
        System.out.println(dePerson.name);
        System.out.println(dePerson.peselNumber);
    }
}
