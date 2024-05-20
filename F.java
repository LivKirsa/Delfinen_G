import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.Exception;

public class F {
     public static void saveStringArray(String[] myArray, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myArray);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);
        } catch (Exception e) {
            System.out.println("error saving array " + e.toString());
        }
    }

    public static String[] loadStringArray(String filename) {
        String[] myArray = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myArray = (String[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Serialized data loaded from " + filename);
        } catch (Exception e) {
            System.out.println("error loading array " + e.toString());
            return null;
        }
        return myArray;
    }
    
        public static void saveObject(Object myArray, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(myArray);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + filename);
        } catch (Exception e) {
            System.out.println("error saving array " + e.toString());
        }        
    }

    public static Object loadObject(String filename) {
        Object object = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            object = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Serialized data loaded from " + filename);
        } catch (Exception e) {
            System.out.println("error loading object " + e.toString());
            return null;
        }
        return object;
    }
}