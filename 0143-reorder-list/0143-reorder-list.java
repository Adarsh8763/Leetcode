/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        prev.next = null;  //for seperating the first half
        slow = reverseList(slow);

        boolean isGrp1 = true; 
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        //Here first half will always be smaller or equal to the second half
        while(fast != null && slow != null){
            // ListNode next1 = fast.next;
            // ListNode next2 = slow.next;

            // fast.next = slow;
            // fast = next1;
            // if(fast != null){       //handles the case where the first half finishes before the second half.
            //     slow.next = fast;   
            // }
            // slow = next2;

            

            if(isGrp1 == true){
                curr.next = fast;
                curr = curr.next;
                fast = fast.next;
                isGrp1 = false;
            }
            else{
                curr.next = slow;
                curr = curr.next;
                slow = slow.next;
                isGrp1 = true;
            }
        }
        curr.next = slow;
    }
    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}