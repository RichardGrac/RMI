import java.rmi.Naming;
import java.util.*;
public class Client {
    public static void main(String[] args) throws Exception {
//        CalculatorImpl c = new CalculatorImpl();
        Calculator c = getCalculator();
        Double[] addends = {1.123, 1.321};
        System.out.println("Sum of = " + Arrays.toString(addends) + " is " + c.sum(addends[0], addends[1]));

        Double[] a = {1.0, 2.0, 3.1415, 5.0};
        List<Double> l = Arrays.asList(a);
        System.out.println("Average of " + Arrays.toString(a) + " is " + c.average(l));
    }

    public static Calculator getCalculator() throws  Exception{
        return (Calculator)Naming.lookup("//localhost:1099/" + Server.RMI_OBJ_REGISTRY_NAME);
    }
}