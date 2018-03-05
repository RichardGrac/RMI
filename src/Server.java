import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
    The rmiregistry command creates and starts a remote object registry on the specified port
    on the current host. If port is omitted, the registry is started on port 1099.
    The rmiregistry command produces no output and is typically run in the background

    Bibliography: http://slideplayer.es/slide/3613340/
 */
public class Server {

    /**
     * The constant RMI_OBJ_REGISTRY_NAME.
     */
    public static final String RMI_OBJ_REGISTRY_NAME = "calculatorUniqueName";

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws RemoteException the remote exception
     */
    public static void main(String[] args) throws RemoteException{
        assertRmiRegistryIsRunning();
        CalculatorImpl rmiObj = new CalculatorImpl();
        String registryURL = "//localhost:1099/" + RMI_OBJ_REGISTRY_NAME;
        try {
            Naming.rebind(registryURL, rmiObj);
            System.out.println("Listening...");
        }catch (MalformedURLException e){
            System.out.println("Exception: " + e.getMessage());
        }
    }

    /**
     * Assert rmi registry is running.
     *
     * @throws RemoteException the remote exception
     */
    public static void assertRmiRegistryIsRunning() throws RemoteException {
        try {
            Registry r = LocateRegistry.getRegistry(1099);
            r.list();
        }catch (Exception e){
            //No hay rmiregistry en ese puerto, lo lanzamos
            LocateRegistry.createRegistry(1099);
        }
    }
}
