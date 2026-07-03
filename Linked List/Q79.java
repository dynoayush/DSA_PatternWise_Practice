// Remove Duplicates from Sorted List [LC-83]

public class Q79 {
    
    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode current = head;

        while (current.next != null) {

            if (current.val == current.next.val) {

                current.next = current.next.next;

            } else {

                current = current.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        // Create Linked List: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        Q79 sol = new Q79();

        ListNode result = sol.deleteDuplicates(head);

        System.out.print("Updated List: ");

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

