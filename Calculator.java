import java.util.Stack;
/**
 * Write a description of class Calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator
{
    // instance variables - replace the example below with your own
    private Stack<Integer> list;

    /**
     * Constructor for objects of class Calculator
     */
    public Calculator()
    {
        list = new Stack<Integer>();
    }

    /**
     * evaluatePostfix will return the result of the postfix expression. There must be 2 or more
     * values before an operator in order for that operator to be used.
     * 
     * @param  String expression - The postfix expression that will be evaluated.
     * @return The result of the postfix expression. If at any time a number is divided by 0,
     *         -1 will be returned.
     */
    public int evaluatePostfix(String expression)
    {
        int answer = 0;
        String operations = "+-*/";
        for (int i = 0; i < expression.length(); i++)
        {
            Character c1 = expression.charAt(i);
            int num1 = 10;
            int num2 = 10;
            if(Character.isDigit(c1))   // Character is a number.
            {
                list.push(Character.getNumericValue(c1));
            }
            else
            {
                if(list.empty() != true)
                {
                    num1 = list.pop();
                }
                if(list.empty() != true)
                {
                    num2 = list.pop();
                }
                
                if (c1.equals(operations.charAt(0)))   // Character is +
                {
                    if(num1 != 10 && num2 != 10)
                    {
                        answer = num1 + num2;
                    }
                }
                else if (c1.equals(operations.charAt(1)))   // Character is -
                {
                    if(num1 != 10 && num2 != 10)
                    {
                        answer = num1 - num2;
                    }
                }
                else if (c1.equals(operations.charAt(2)))   // Character is *
                {
                    if(num1 != 10 && num2 != 10)
                    {
                        answer = num1 * num2;
                    }
                }
                else if (c1.equals(operations.charAt(3)))   // Character is /
                {
                    if(num1 != 10 && num2 != 10)
                    {
                        if(num2 == 0)
                        {
                            System.out.println("Error: Divided by 0");
                            return -1;
                        }
                        else
                        {
                            answer = num1 / num2;
                        }
                    }
                }
                list.push(answer);
            }
        }
        
        while(list.empty() != true)
        {
            list.pop();
        }
        
        return answer;
    }
}
