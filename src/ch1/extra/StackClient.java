package ch1.extra;

import ch1.s3.QueueLinkedList;
import ch1.s3.ResizingArrayStack;
import ch1.s3.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {

    private enum impls {
        RESIZINGARRAYSTACK
    }

    public Stack<String> getStack(String name) {
        switch(impls.valueOf(name.toUpperCase())) {
            case RESIZINGARRAYSTACK:
                return new ResizingArrayStack<String>();
        }
        return new ResizingArrayStack<String>();
    }

    public static void main(String[] args) {

        StackClient client = new StackClient();

        Stack<String> stack = client.getStack(args[0]);

        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();
            if (!item.equals("-")) {
                stack.push(item);
            }
            else if ( !stack.isEmpty() ) {
                StdOut.println("Processing: " + stack.pop());
            }
        }

        StdOut.println("Remaining Items in Queue:");
        for (String s : stack) {
            StdOut.println(s);
        }
    }

}
