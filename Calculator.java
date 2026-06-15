public class Calculator {

  public int Add(int a,int b){
    int result = a+b;
    return result;
  }
  
  // subtract
  public int subtract(int  a,  int b) {
      if(b == 0){
          System.out.println("Wait what");
      }
      return a - b;
  }
  
  public double multiply(double x, double y)
  {
      double z=x*y;
       return z;
  }
  
  public int divide(int a, int b) {
    return a / b;
  }

}
