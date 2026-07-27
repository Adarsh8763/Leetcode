/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while(lenA > lenB){
            lenA--;
            curr1 = curr1.next;
        }

        while(lenA < lenB){
            curr2 = curr2.next;
            lenB--;
        }

        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }

    private int getLength(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }
        return len;
    }
}