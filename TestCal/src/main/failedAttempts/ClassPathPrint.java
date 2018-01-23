package main.failedAttempts;

public class ClassPathPrint {

    public static void main(String[] args) {
       System.out.println(System.getProperty("os.version") + "\n");
       String cp = System.getProperty("java.class.path");
       String sep = System.getProperty("path.separator");
       int index = 0;
       int endIn = 0;
       endIn = cp.indexOf(sep, index);
       System.out.println(cp);
       System.out.println();
       while (cp.length() - index >= 10) {
          if (cp.indexOf("(jar:", index) < cp.indexOf(sep, index))
             endIn = cp.indexOf(sep, endIn + 1); 
          System.out.println(cp.substring(index, endIn));
          index = cp.indexOf(sep, index) + 1;
          endIn = cp.indexOf(sep, index);
       } 
    }

}
