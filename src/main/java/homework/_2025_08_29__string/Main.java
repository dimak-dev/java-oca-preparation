package homework._2025_08_29__string;

public class Main {
    public static void main(String[] args) {
// ##### Kennen Sie die Konstruktoren?
//     String(), String(String s)

        System.out.println("new String()" +  new String());
        System.out.println("new String(\"from string\"): " + new String("from string"));


// ##### Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendeklarationen an.
        System.out.println("trim() " + "   string   ".trim() );
// 	trim()
	
// ##### Testen Sie folgende Methoden. Sehen Sie sich dabei die Methodendeklarationen an.

// 	concat(String)

// > Kann man concat durch den Konkatenationsoperator (+) ersetzen?
	
// 	charAt(int)
// 	length()
// 	isEmpty()  
	
// 	toUpperCase()
// 	toLowerCase()
	
// 	endsWith(String)
// 	startsWith(String prefix) 
// 	startsWith(String prefix, int toffset) 
	
// 	equals(Object)

// > Kann man die equals durch den Vergleichsoperator (==) ersetzen?
	
// 	equalsIgnoreCase(String)
	
// 	indexOf(int)
// 	indexOf(int ch, int fromIndex)
// 	indexOf(String str) 
// 	indexOf(String str, int fromIndex)  
	
// 	lastIndexOf(int ch)  
// 	lastIndexOf(int ch, int fromIndex)  
// 	lastIndexOf(String str)  
// 	lastIndexOf(String str, int fromIndex) 
	
// 	replace(char oldChar, char newChar) 
// 	replace(CharSequence, CharSequence) 
	
// > Bitte auch die replace testen, die zwei Strings als Argumente akzeptiert 
	
// 	substring(int beginIndex) 
// 	substring(int beginIndex, int endIndex)  

// ##### Testen Sie zwei oder drei aus der folgenden statischen Methoden. Sehen Sie sich bitte die Methodendeklarationen an.

// 	valueOf(boolean b)
// 	valueOf(char c)
// 	valueOf(char[] data)
// 	valueOf(double d)
// 	valueOf(float f)
// 	valueOf(int i)
// 	valueOf(long l)
// 	valueOf(Object obj)

    }
}
