import SimpleCalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

class SimpleCalculatorImpl extends SimpleCalculatorPOA {
  private ORB orb;

  public void setORB(ORB orb_val) {
    orb = orb_val;
  }

  public double sumNumbers(double number1, double number2) {
    return number1 + number2;
  }

  public void shutdown() {
    orb.shutdown(false);
  }
}


public class SimpleCalculatorServer {

  public static void main(String args[]) {
    try {
      ORB orb = ORB.init(args, null);
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      SimpleCalculatorImpl simpleCalculatorImpl = new SimpleCalculatorImpl();
      simpleCalculatorImpl.setORB(orb); 

      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(simpleCalculatorImpl);
      SimpleCalculator href = SimpleCalculatorHelper.narrow(ref);

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      String name = "SimpleCalculator";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("SimpleCalculatorServer ready and waiting ...");

      orb.run();
    } catch (Exception e) {
      System.err.println("ERROR: " + e);
      e.printStackTrace(System.out);
    }

    System.out.println("SimpleCalculator Exiting ...");
  }
}
