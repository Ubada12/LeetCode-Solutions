class Solution {
    public Boolean palindrome(long x)
    {
        String s= String.valueOf(x);
        int left= 0;
        int right= s.length()-1;
        while(left<=right)
        {
            if(!(s.charAt(left) == (s.charAt(right))))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public long generateBaseNumbers(int n, int b)
    {
        if(n==0)
        return 0;
        ArrayList<Integer> remainder = new ArrayList<>();
        while(n!=0)
        {
            remainder.add(n%b);
            n= n/b;
        }
        StringBuilder sb= new StringBuilder();
        for(int num= remainder.size()-1; num>= 0; num--)
        {
            sb.append(remainder.get(num));
        }
        String s= sb.toString();
        long result= Long.parseLong(s);
        return result;
    }
    public boolean isStrictlyPalindromic(int n) {
        long baseNum= 0;
        for(int i= 2; i<=n; i++)
        {
            baseNum= generateBaseNumbers(n, i);
            if(!palindrome(baseNum))
                return false;
        }
        return true;
    }
}