import java.util.HashSet;

public class Main {

    public static class Node<T> {
        T val;
        Node<T> next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }

    public static <T> Node<T> findIntersection(Node<T> node1, Node<T> node2) {
        HashSet<Node<T>> nodeSet = new HashSet<>();

        //traverse list 1 and populate the hashset
        Node<T> currentNode1 = node1;
        while(currentNode1 != null) {
            nodeSet.add(currentNode1);
            currentNode1 = currentNode1.next;
        }

        //traverse list 2 and check for intersection
        Node<T> currentNode2 = node2;
        while(currentNode2 != null) {
            if(nodeSet.contains(currentNode2)) {
                return currentNode2;
            }
            currentNode2 = currentNode2.next;
        }

        return null;
    }

    public static void main(String...args) {
        //generate linked list1:
        Node<Integer> head1 = new Node<>(1);
        head1.next = new Node<>(2);
        head1.next.next = new Node<>(3);
        head1.next.next.next = new Node<>(4);
        head1.next.next.next.next = new Node<>(5);

        //generate linked list 2:
        Node<Integer> head2 = new Node<>(6);
        head2.next = new Node<>(7);
        head2.next.next = head1.next.next;  //confluence occurs at the node with value 3

        // Test findIntersection method
        Node<Integer> intersection = findIntersection(head1, head2);
        if(intersection != null) {
            System.out.println("The intersecting node has value: " + intersection.val);
        } else {
            System.out.println("The lists do not intersect.");
        }
    }
}
