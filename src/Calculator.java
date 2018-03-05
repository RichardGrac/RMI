import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Calculator extends Remote {

    public Double sum(Double a, Double b) throws RemoteException;
    public Double average(List<Double> list) throws RemoteException;
}
