import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){ 
        this.val = val; 
    }
    ListNode(int val, ListNode next){ 
        this.val = val; this.next = next; 
    }
}

public class MergeSorted {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            current.next = minNode;
            current = current.next;
            
            if (minNode.next != null) {
                minHeap.offer(minNode.next);
            }
        }
        
        return dummyHead.next;
    }
    public static void main(String[] args) {
        // Initialize list 1: 1, 4, 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        // Initialize list 2: 1, 3, 4
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Initialize list 3: 2, 6
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        // Array of lists
        ListNode[] lists = {l1, l2, l3};

        // Merge and output
        ListNode merged = mergeKLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " -> ");
            merged = merged.next;
        }
        System.out.println("null");
    }
}
