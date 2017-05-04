package ch1.extra;

import ch1.s3.QueueLinkedList;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QueueClient {

    private QueueLinkedList<String> queue = new QueueLinkedList<>();

    public static void main(String[] args) {

        QueueClient client = new QueueClient();

        while (!StdIn.isEmpty()) {

            String item = StdIn.readString();
            if (!item.equals("-")) {
                client.queue.enqueue(item);
            }
            else if ( !client.queue.isEmpty() ) {
                StdOut.println("Processing: " + client.queue.dequeue());
            }
        }

        StdOut.println("Remaining Items in Queue:");
        for (String s : client.queue) {
            StdOut.println(s);
        }
    }

}
