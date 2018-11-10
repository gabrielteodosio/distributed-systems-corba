import SimpleCalculatorApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class SimpleCalculatorClient
{
  static SimpleCalculator simpleCalculatorImpl;

  public static void main(String args[]) {
    try{
      ORB orb = ORB.init(args, null);

      org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      String name = "SimpleCalculator";
      simpleCalculatorImpl = SimpleCalculatorHelper.narrow(ncRef.resolve_str(name));

      System.out.println("Obtained a handle on server object: " + simpleCalculatorImpl);
      
      double sum = simpleCalculatorImpl.sumNumbers(
        Double.parseDouble(args[0]),
        Double.parseDouble(args[1])
      );

      StringBuilder builder = new StringBuilder();
      builder.append("A soma de ").append(args[0]);
      builder.append(" com ").append(args[1]);
      builder.append(" é igual a ").append(sum);

      System.out.println(builder.toString());
      simpleCalculatorImpl.shutdown();
    } catch (Exception e) {
      System.out.println("ERROR : " + e) ;
      e.printStackTrace(System.out);
	  }
  }
}
