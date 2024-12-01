class Solution {
    public boolean checkIfExist(int[] arr) {
        if(arr.length!=1)
        {
            for(int i= 0; i<arr.length; i++)
            {
                int j= i+1;
                while(j<arr.length)
                {
                    if(arr[i]==2*arr[j] || arr[j]==2*arr[i])
                    return true;
                    j++;
                }
            }
        }
        return false;
    }
}
