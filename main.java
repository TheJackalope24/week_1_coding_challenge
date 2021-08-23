import java.util.Scanner;
import java.util.LinkedList;

public class main{

    public static boolean checkCardNumber(String number){
        int length = number.length();
        LinkedList<Integer> numberList = new LinkedList<Integer>();
        
        if(length >= 14 && length <= 17){

            //converts number to linked list
            for(int i=0; i<length; i++){
                numberList.push(Character.getNumericValue(number.charAt(i))); 
            }
            
            //get checknumber
            int checkNumber = numberList.pop();

            //iterate over list backwards
            int j = 1;
            int sum = 0;
            for(int i=numberList.size()-1; i>=0; i--){
                int num = numberList.get(i);
                if(j%2==1){
                    num = num * 2;
                    String numString = Integer.toString(num);
                    if(numString.length() == 1){
                        sum = sum + num;
                    }else{
                        num = Character.getNumericValue(numString.charAt(0)) + Character.getNumericValue(numString.charAt(1));
                        sum = sum + num;
                    }
                }
                else{
                    sum = sum + num;
                }
                j++;
            }

            String sumString = Integer.toString(sum);
            sum = 10 - Character.getNumericValue(sumString.charAt(sumString.length()-1));
            if(sum == checkNumber){
                return true;
            }

        }
        return false;
    }

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Card Number to Check: ");
        String cardNumber = input.next();
        System.out.println(checkCardNumber(cardNumber));
        input.close();

    }
}