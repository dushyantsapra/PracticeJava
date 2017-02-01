//Enum Notes

1. A Java Enum is a special Java type used to define collections of constants. More precisely, a Java enum type is a special kind of Java class
2. Java enum extends java.lang.Enum class implicitly, so your enum type can't extend another class
3. An enum can contain constants, methods etc.
4. We can't have public constructor in used defined enum class.
5. Definition of fields and methods must always come after the list of constants in enum
6. enum improves type safety.
7. For every enum constant 2 values i.e int ordinal & String name is pre-defined by the compiler
8. Ordinal value is the index for the enum constant in the order of definition
9. The name variable value would be the same as the name of the enum constant
10. Enum which is the parent class of every used defined enum class contains single constructor
      protected Enum(String name, int ordinal) {this.name = name; this.ordinal = ordinal;}
11. Enum class override toString() of object class and return value of name variable for the current enum constant.
12. Enum class Methods:
    i) public final String name(){return name;}
    ii) public final int ordinal(){return ordinal;}
    iii) public String toString(){return name;}
    iv) clone of enum is not supported as
        protected final Object clone()throws CloneNotSupportedException{throw new cloneNotSupportedException;}
    v) For Every compiled user defined enum class compiler insert 2 methods
        public static Enum_class_name valueof(String s){return Enum_class_name(Enum.valueof(enum_class_name, s));}
        public static Enum_class_name values(){return (Enum_class_name[])$VALUES.clone();}
13. For Every user defined enum constant compiler converts them to used defined enum class final static objects. For Example:
		enum LEVEL {
			HIGH(1, "High"),
			MEDIUM(2, "Medium"),
			LOW(3, "Low");

			private LEVEL(){}
			private LEVEL(int iValue, String sValue) {
				this.iValue = iValue;
				this.sValue = sValue;
			}
		}

		//The Compiled code would be:
		public final class LEVEL extends Enum {
			private LEVEL(){}
			private LEVEL(Strin s, int i, int iValue, String sValue) {
				super(s, i);
				this.iValue = iValue;
				this.sValue = sValue;
			}
			public static LEVEL[] values() {
			    return (LEVEL[])$VALUES.clone();
			}
			public static LEVEL valueof(String s) {
				return (LEVEL)Enum.valueof(LEVEL, s);
			}

			public static final LEVEL HIGH;
			public static final LEVEL MEDIUM; 
			public static final LEVEL LOW;
			private static final LEVEL $VALUES[];

			static   
			{
				HIGH = new LEVEL("HIGH", 0, 1, "High");
				MEDIUM = new LEVEL("MEDIUM", 1, 2, "Medium");
				LOW = new LEVEL("LOW", 2, 3, "Low");
				$VALUES = (new LEVEL[] {
					HIGH, MEDIUM, LOW
				});
			}
		}
14. If Enum is defined inside of a class then compiled code would be
		public class EnumExample {
			enum LEVEL {
				HIGH(1, "High"),
				MEDIUM(2, "Medium"),
				LOW(3, "Low");

				private LEVEL(){}
				private LEVEL(int iValue, String sValue) {
					this.iValue = iValue;
					this.sValue = sValue;
				}
			}
		}

		//The Compiled code would be:
		public final class EnumExample$LEVEL extends Enum {
			private EnumExample$LEVEL(){}
			private EnumExample$LEVEL(Strin s, int i, int iValue, String sValue) {
				super(s, i);
				this.iValue = iValue;
				this.sValue = sValue;
			}
			public static EnumExample$LEVEL[] values() {
			    return (EnumExample$LEVEL[])$VALUES.clone();
			}
			public static EnumExample$LEVEL valueof(String s) {
				return (EnumExample$LEVEL)Enum.valueof(EnumExample$LEVEL, s);
			}

			public static final EnumExample$LEVEL HIGH;
			public static final EnumExample$LEVEL MEDIUM; 
			public static final EnumExample$LEVEL LOW;
			private static final EnumExample$LEVEL $VALUES[];

			static   
			{
				HIGH = new EnumExample$LEVEL("HIGH", 0, 1, "High");
				MEDIUM = new EnumExample$LEVEL("MEDIUM", 1, 2, "Medium");
				LOW = new EnumExample$LEVEL("LOW", 2, 3, "Low");
				$VALUES = (new EnumExample$LEVEL[] {
					HIGH, MEDIUM, LOW
				});
			}
		}