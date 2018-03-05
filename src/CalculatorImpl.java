import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public Double sum(Double a, Double b) throws RemoteException {
        return a+b;
    }

    @Override
    public Double average(List<Double> list) throws RemoteException {
        double sum = 0.0;
        for(double d : list) sum += d;
        return sum/(double)list.size();
    }
}
