public class Main {
    public static void main(String[] args)
    {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result!=null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int x = 0;
        int y = 0;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while (l1!=null || l2!=null)
        {
            if(l1!=null)
                x = l1.val;
            else
                x = 0;
            if(l2!=null)
                y = l2.val;
            else
                y = 0;
            int sum = x+y+carry;
            carry = sum/10;
            dummy.next = new ListNode(sum%10);
            dummy = dummy.next;
            if(l1!=null && l1.next!=null)
                l1 = l1.next;
            else
                l1 = null;
            if(l2!=null && l2.next!=null)
                l2 = l2.next;
            else
                l2 = null;
        }

        if(carry!=0)
            dummy.next = new ListNode(carry);
        return result.next;
    }
}
