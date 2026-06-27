// Remove Nth node from end [LC - 19]

public class Q74 {

    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Remove the first node
        if (n == size) {
            return head.next;
        }

        int indexToFind = size - n;

        ListNode prev = head;

        for (int i = 1; i < indexToFind; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Q74 sol = new Q74();

        ListNode ans = sol.removeNthFromEnd(head, 2);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}