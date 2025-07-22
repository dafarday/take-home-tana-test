public class Question7_RotateList {
    // Node class for singly linked list
    static class ListNode {
        String val;
        ListNode next;
        ListNode(String val) { this.val = val; }
    }

    // Rotate the list to the right by n positions
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;

        // 1. Compute the length of the list
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        // 2. Make the list circular
        tail.next = head;

        // 3. Find the new head after rotation
        n = n % len;
        int stepsToNewHead = len - n;
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // 4. Break the circle and return the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Helper to create a linked list from an array
    public static ListNode createList(String[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] arr = {"ID_A01","ID_A02","ID_A03","ID_A04","ID_A05","ID_A06"};
        ListNode head = createList(arr);

        System.out.println("Original list:");
        printList(head);

        int rotateBy = 2;
        ListNode rotated = rotateRight(head, rotateBy);

        System.out.println("Rotated list (by " + rotateBy + "):");
        printList(rotated);
    }
}
