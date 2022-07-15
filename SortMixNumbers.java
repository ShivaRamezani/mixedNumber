import java.util.ArrayList;
import java.util.Collections;
    public class SortMixNumbers {
        public static void main(String[] args) {
            ArrayList list = new ArrayList();
            
            MixedNumber number1 = new MixedNumber(5, 7, 6);
            list.add(number1);

            MixedNumber number2 = new MixedNumber(8, 18, 8);
            list.add(number2);

            MixedNumber number3 = new MixedNumber(4, 9, 2);
            list.add(number3);

            MixedNumber number4 = new MixedNumber(1, 10, 7);
            list.add(number4);

            MixedNumber number5 = new MixedNumber(2, 6, 5);
            list.add(number5);
                           
            System.out.println(list);
            Collections.sort(list);
            System.out.print(list);
            
      }    
 }
      
  
    
              
        
        
        