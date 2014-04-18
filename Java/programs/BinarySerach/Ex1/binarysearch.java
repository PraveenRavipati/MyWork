    public class BinarySearchDemo {  

     public static void main(String[] args) {  
      
       int[]a = {0,2,4,6,8,10,12,14,16};  
      int finalIndex = 9;  
      
         System.out.println("Integer test array contains...");  
        for (int i = 0; i < a.length; i++)  
              System.out.print(a[i] + " ");  
             System.out.println();  
             System.out.println();  
     
         int result;  
         for (int key = -4; key < 6; key++)  
     {  
            result = BinarySearch.search(a, 0, finalIndex, key);  
               if (result >= 0)  {
                  System.out.println(key + " is at index " + result);
}  
              else  
{ 
            System.out.println(key + " is not in the array.");  
} 
         }  
     
        String[] names = new String[] {"peach", "apple", "fig", "mango", "orange", "blueberry"};  
      
        System.out.println();  
        System.out.println("String test array contains...");  
      
        for (int j = 0; j < names.length; j++) {  
        for (int i = j + 1; i < names.length; i++) {  
            if (names[i].compareTo(names[j]) < 0) {  
              String t = names[j];  
              names[j] = names[i];  
              names[i] = t;  
            }  
          }  
          System.out.print(names[j] + " ");  
        }  
      
        int results;  
        for (int key = -4; key < 6; key++)  
        {  
            results = BinarySearchString.searchString(names, key);  
            if (results >= 0)  
{ 
               System.out.println(key + " is at index " + results);  
} 
           else  
{
                System.out.println(key + " is not in the array.");  
}
        }  
      
       }  
      
      }  
      
      
      
      
    public class BinarySearch {  
      
        public static int search(int[]a, int first, int last, int key)  
        {  
            int result = 0;  
      
            if (first > last)  
                result = -1;  
            else  
            {  
                int mid = (first + last)/2;  
      
                if (key == a [mid])  
                    result = mid;  
                else if (key < a[mid])  
                    result = search(a, first, mid - 1, key);  
                else if (key > a[mid])  
                    result = search(a, mid + 1, last, key);  
            }  
            return result;  
        }  
      
      
    }  
      
      
      
    public class BinarySearchString {  
      
        public static int searchString(String[] names, String key) {  
        int first = 0;  
        int last  = names.length;  
      
        while (first < last) {  
            int mid = (first + last) / 2;  
            if (key.compareTo(names[mid]) < 0) {  
                last = mid;  
            } else if (key.compareTo(names[mid]) > 0) {  
                first = mid + 1;  
            } else {  
                return mid;  
            }  
        }  
        return -(first + 1);  
    }  
      
      
    }  
