// Reverse Linked List [LC-206]

public class Q73 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode preNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next;

            currNode.next = preNode;

            preNode = currNode;
            currNode = nextNode;
        }

        return preNode;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Q73 sol = new Q73();

        ListNode reversed = sol.reverseList(head);

        System.out.println("Reversed Linked List:");

        while (reversed != null) {
            System.out.print(reversed.val);

            if (reversed.next != null) {
                System.out.print(" -> ");
            }

            reversed = reversed.next;
        }

        System.out.println();
    }
}