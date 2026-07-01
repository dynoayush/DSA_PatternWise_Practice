// Linked List Cycle [LC-142]

public class Q77{

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        boolean cycle = false;

        // Detect the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        // No cycle present
        if (!cycle) {
            return null;
        }

        // Find the starting node of the cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        // Create nodes
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        // Connect nodes
        head.next = second;
        second.next = third;
        third.next = fourth;

        // Create cycle
        fourth.next = second;

        Q77 sol = new Q77();

        ListNode cycleStart = sol.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node: " + cycleStart.val);
        } else {
            System.out.println("No cycle found");
        }
    }
}