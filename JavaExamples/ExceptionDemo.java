import java.io.IOException;

public class ExceptionDemo {

    // Fails and throws an IOException, which we must declare since it's checked
    private static Object failOne() throws IOException {
        System.out.println("Entered method failOne.");
        if(true) { // fool the compiler to think that the last line is reachable
            throw new IOException("testing");
        }
        System.out.println("Execution does not get here.");
        return new IOException("testing");
    }

    // Calls failOne but does not handle the exception that it can throw.
    // Therefore this method must also declare that it may throw IOExceptions.
    private static void failTwo() throws IOException {
        try {
            System.out.println("Calling method failOne from failTwo.");
            failOne(); // fails
            System.out.println("Execution does not get here.");
        }
        finally { // this code will be executed no matter what
            System.out.println("But the execution does get here.");
        }
    }
    
    // The demo method catches and handles the exception that was thrown
    // from two levels below it in the method stack.
    public static void demo() {
        try {
            failTwo(); // fails by calling something that fails
        } catch(IOException e) {
            System.out.println("Caught an exception " + e);
            System.out.println("Printing the stack trace: ");
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : trace) {
                System.out.print(stackTraceElement.getClassName() + " ");
                System.out.print(stackTraceElement.getMethodName() + " ");
                System.out.println(stackTraceElement.getLineNumber() + " ");
            }
        }
        finally {
            System.out.println("And we are finally done!");
        }
    }
    
    // Will this method return 0 or 1 when called? What do you think?
    public static int returnDemo() {
        try {
            return 0;
        }
        finally {
            return 1;
        }
    }
    
    // Does this method terminate, or is it an infinite loop? Who will win
    // this game of tug-of-war between these two opposing forces?
    public static void whileDemo() {
        while(true) {
            try {
                break;
            }
            finally {
                continue;
            }
        }
    }
}