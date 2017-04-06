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
    /**
     * Solution1: Length alignment, Beat 43%
     * 1. count the length of two list, find the last node, compare
     * 2. if not equal return null, else next step
     * 3. move the pointer in the longer list to align with the shorter
     * */
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB, lastA = null, lastB = null;
        
        while(pA != null){
            lastA = pA;
            pA = pA.next;
            lenA ++;
        }
        while(pB != null){
            lastB = pB;
            pB = pB.next;
            lenB ++;
        }
        
        if (lastA != lastB)
            return null;
            
        int gap = lenA - lenB;
        pA = headA;
        pB = headB;
        
        if(gap > 0){
            while(gap > 0){
                pA = pA.next;
                gap --;
            }
        }else{
            while(gap < 0){
                pB = pB.next;
                gap ++;
            }
        }
        
        while(pA != pB){
            pA = pA.next;
            pB = pB.next;
        }
        
        return pA;
    }*/
    
    /**
     * [WRONG ANSWER Caused by the modification of linked structure]
     * Solution2: Create Cycle after 1st iteration
     * 1. move until the shorter reach the tail, connect to the head
     * 2. cycle detection
     **/
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        ListNode pA = headA, pB = headB, lastA = null, lastB = null;
        
        while(pA != null){
            lastA = pA;
            pA = pA.next;
        }
        while(pB != null){
            lastB = pB;
            pB = pB.next;
        }
        
        if (lastA != lastB)
            return null;
            
        //create cycle
        lastA.next = headA;
        ListNode fast =headB, slow = headB;
        while(fast != slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        //reset fast, the same speed with the slow
        fast = headB;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }*/
    
    /**
     * Solution 3: lenA != lenB but lenA + lenB is the same
     * once reach the tail, redirect to the other linked list
     * The meeting point is the entry for intersection
     * 
     * */
     /*public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
        
        ListNode pA = headA, pB = headB, lastA = null, lastB = null;
        
        while(pA != null){
            lastA = pA;
            pA = pA.next;
        }
        while(pB != null){
            lastB = pB;
            pB = pB.next;
        }
        
        if (lastA != lastB)
            return null;
        
        //restart after the validation of existence of intersection
        pA = headA;
        pB = headB;
        while(pA != pB){
            pA = pA.next;
            if(pA == null)
                pA = headB;
                
            pB = pB.next;
            if(pB == null)
                pB = headA;
        }
        
        return pA;
     }*/
     
     
     //solution 4: HashSet
     //O(n) space, O(n) time
     /*public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
     
        Set<ListNode> hashSet = new HashSet<ListNode>();
        while(headA != null){
            hashSet.add(headA);
            headA = headA.next;
        }
         
        while(headB!=null && !hashSet.contains(headB))
            headB = headB.next;
        return headB;
     }*/
     
     //Concise one of solution1 
     //Length diff. Time O(m+n+m-n+delta)
     /*public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)
            return null;
            
        ListNode pA = headA, pB = headB;
        int lenA = 0, lenB = 0;
        while(pA != null){
            lenA++;
            pA = pA.next;
        }
        while(pB != null){
            lenB++;
            pB = pB.next;
        }
        
        pA = headA;
        pB = headB;
        if(lenA > lenB){
            while(lenA > lenB){
                pA = pA.next;
                lenA --;
            }
        }else{
            while(lenB > lenA){
                pB = pB.next;
                lenB --;
            }
        }
        
        while(pA != pB){
            pA = pA.next;
            pB = pB.next;
        }
        
        return pA;
     }*/
     
     //concise solution 2
     //2 iteration, Time: O(lenA + lenB), Space O(1)
     public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null)  return null;
     
        ListNode pA = headA, pB = headB;
        while(pA != pB){
             pA = (pA == null) ? headB : pA.next;
             pB = (pB == null) ? headA : pB.next;
        }
         
        return pA;
     }
}
