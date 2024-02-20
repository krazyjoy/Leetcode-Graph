import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class removeDuplicatesFromLinkedList {
    public static void main(String[] args) {
        int[] ex1 = new int[]{1,1,2};
        ListNode list1 = deleteDuplicates(createList(ex1));
        printList(list1);


        int[] ex2 = new int[]{1,1,2,3,3};
        ListNode list2 = deleteDuplicates(createList(ex2));
        printList(list2);
    }
    public static ListNode createList(int[] example1){
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for(int num: example1){
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
    public static void printList(ListNode head){
        ListNode cur = head;
        String list="";
        while(cur != null){
            list += "-> ";
            list += cur.val;
            cur = cur.next;
        }
        System.out.println(list);
    }
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast != null){
            if(slow.val != fast.val){
                /*
                    skip the repeated nodes in between slow and fast pointers
                    by connecting slow to fast
                 */
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null; // cut off the remaining nodes
        return head;
    }
}
