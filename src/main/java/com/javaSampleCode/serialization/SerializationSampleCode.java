package com.javaSampleCode.serialization;

/*
 * Link : http://marxsoftware.blogspot.in/2014/02/serializing-java-objects-with-non.html
 * Link : http://javapapers.com/core-java/serialversionuid-in-java-serialization/
 * Link : http://www.jusfortechies.com/java/core-java/externalization.php			//For Pros and cons of serialization.	
 * 
 * 
 * ** serialVersionUID is a 64-bit hash of the class name, interface class names, methods and fields. Serialization runtime generates a 
 * 		serialVersionUID if you do not add one in source
 *  
 * 1. Serializable is a marker interface
 * 2. It is mainly used in Hibernate, RMI, JPA, EJB, JMS technologies.
 * 3. The reverse operation of serialization is called deserialization.
 * 4. The String class and all the wrapper classes implements java.io.Serializable interface by default.
 * 5. It is mainly used to travel object's state on the network (known as marshaling).
 * 6. When an object is serialized, the serialVersionUID is serialized along with the other contents.
 * 7. Later when that is deserialized, the serialVersionUID from the deserialized object is extracted and compared with the serialVersionUID of the 
 * 		loaded class. If the numbers do not match then, InvalidClassException is thrown.
 *
 *		Rule(is-a Relationship)
 * 1. If parent class is implementing Serializable interface than all its child becomes serializable automatically.
 * 2. If superclass is not serializable and subclass object is serialized then state of the member variable of subclass will be saved but not the superclass. 
 * 
 * 		Rule(has-a relationship)
 * 1. Make a Reference of a class(Already implementing Serializable Interface) Transient if it need not to serialized.
 * 2. To make a reference variable of a non serialized class, we have to write member variable of that class to ObjectOutputStream Separately.  
 * 
 * 		Compatible Changes
 * 1. Adding new fields
 * 2. Adding writeObject()/readObject() methods - We may add these methods to customize serialization process(Same happening In Comment 1 for 
 * 		serialization and in comment 2 for deserialization).
 * 3. Removing writeObject()/readObject() methods
 * 4. Changing access modifier of a field
 * 5. Changing a field from static to non static OR changing transient filed to non transient field - it’s like addition of fields.
 * 
 * 		InCompatible Changes
 * 1. Deletion of fields.
 * 2. Changing a non-static field to static or non transient field to transient field. - it’s equal to deletion of fields.
 * 3. Modifying the writeObject() / readObject() method
 * 4. If Package of class is changed this is treated as class has been deleted.
 * 
 * 
 * 		Cons/Problems of Serialization and deserialization
 * 1. Serialization is a recursive algorithm. What I mean to say here is, apart from the fields that are required, starting from a single object, 
 * 		until all the objects that can be reached from that object by following instance variables, are also serialized. This includes the super class 
 * 		of the object until it reaches the "Object" class and the same way the super class of the instance variables until it reaches the "Object" 
 * 		class of those variables. Basically all the objects that it can read. This leads to lot of overheads. Say for example, you need only car type 
 * 		and license number but using serialization, you cannot stop there. All the information that includes description of car, its parts, blah blah 
 * 		will be serialized. Obviously this slows down the performance.
 * 2. Both serializing and deserializing require the serialization mechanism to discover information about the instance it is serializing. Using the 
 * 		default serialization mechanism, will use reflection to discover all the field values. Also the information about class description is added 
 * 		to the stream which includes the description of all the serializable superclasses, the description of the class and the instance data associated 
 * 		with the specific instance of the class. Lots of data and metadata and again performance issue.
 * 3. You know that serialization needs serialVersionUID, a unique Id to identify the information persisted. If you don't explicitly set a 
 * 		serialiVersionUID, serialization will compute the serialiVersionUID by going through all the fields and methods. So based on the size of the 
 * 		class, again serialization mechanism takes respective amount of time to calculate the value. A third performance issue.
 * 
 * */

public class SerializationSampleCode {

}
