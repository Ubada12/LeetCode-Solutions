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
import java.math.BigInteger;
class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int[] arrayList1= reverseList(l1);
        int[] arrayList2= reverseList(l2);
        System.out.println("array1: "+Arrays.toString(arrayList1)+" AND array2: "+Arrays.toString(arrayList2));
        BigInteger list1_Final_Numers= arraysToInt(arrayList1);
        BigInteger list2_Final_Numers= arraysToInt(arrayList2);
        BigInteger finalListNo= list1_Final_Numers.add(list2_Final_Numers);
        System.out.println(list1_Final_Numers+" + "+list2_Final_Numers+" = "+finalListNo);
        String finalList= String.valueOf(finalListNo);
        int[] finalListArray= stringTo_INTarray(finalList);
        finalListArray= reverseTheArray(finalListArray);
        ListNode FinalList= ArrayToList(finalListArray);
        return FinalList;
    }

    public int[] reverseTheArray(int[] array)
    {
        int[] reversedArray= new int[array.length];
        for(int i= array.length-1; i>=0; i--)
        {
            reversedArray[Math.abs(i-(array.length-1))]= array[i];
        }
        return reversedArray;
    }

    public int[] stringTo_INTarray(String str)
    {
        int[] intArray= new int[str.length()];
        for(int i=0; i<str.length(); i++)
        {
            intArray[i]= Character.getNumericValue(str.charAt(i));
        }
        return intArray;
    }

    public ListNode ArrayToList(int[] array)
    {
        ListNode head= new ListNode(array[0]);
        ListNode current= head;
        for(int i=1; i<array.length; i++)
        {
            current.next= new ListNode(array[i]);
            current= current.next;
        }
        return head;
    }

    public BigInteger arraysToInt(int[] array)
    {
        BigInteger number= java.math.BigInteger.ZERO;
        for(int i=0; i<array.length; i++)
        {
            number = number.multiply(BigInteger.TEN).add(BigInteger.valueOf(array[i]));
        }
        return number;
    }

    public int[] reverseList(ListNode list)
    {
        int i= 0;
        int[] array= new int[lengthOfList(list)];
        ListNode current= list;
        while(current!=null)
        {
            array[i]= current.val;
            current= current.next;
            i++;
        }
        array= reverseTheArray(array);
        return array;
    }

    public int lengthOfList(ListNode list)
    {
        int count= 0;
        ListNode current= list;
        while(current!=null)
        {
            count++;
            current= current.next;
        }
        return count;
    }
}