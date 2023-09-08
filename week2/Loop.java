import java.util.HashSet;

public class Loop{
     static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static Node findLoopBeginning(Node head) {
        HashSet<Node> traversedNodes = new HashSet<>();

        Node currentNode = head;
        while (currentNode != null) {
            if (traversedNodes.contains(currentNode)) {
                return currentNode;
            }
            traversedNodes.add(currentNode);
            currentNode = currentNode.next;
        }

        return null;
    }

    public static void main(String...args) {
        //generate a linked list
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = C;  //generate loop

        //test
        Node loopStart = findLoopBeginning(A);
        if (loopStart != null) {
            System.out.println("Loop starts at node with value: " + loopStart.val);
        } else {
            System.out.println("No loop detected.");
        }
    }
}
