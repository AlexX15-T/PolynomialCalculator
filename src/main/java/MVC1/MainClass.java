package MVC1;


public class MainClass {

    public static void main(String[] args) throws Exception {

        PolynomialModel pM = new PolynomialModel();
        PolynomialView pV = new PolynomialView(pM);
        PolynomialController pC = new PolynomialController(pV, pM);
        pV.setVisible(true);

        /*Polynomial p = new Polynomial();
        Polynomial q = new Polynomial();
        Polynomial p1 = new Polynomial();
        Polynomial q1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial q2 = new Polynomial();
*/

      //  p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
      //  q.stringToPolynomial("x^5 + 22.6x^4 - x^3 - 41.3x + 4.2");

        //p1.stringToPolynomial("-x^2 + 2x + 2");
        //q1.stringToPolynomial("x + 2");

        //p2.stringToPolynomial("x^5 + 2x^4 + x + x^2 - 5.3x^3");
       // q2.stringToPolynomial("2x^3 + 1");


       // System.out.println(p1.derviate());

        //System.out.println(p2.divide(q2).getQ());
        //System.out.println(p2.divide(q2).getRest());

        //System.out.println(p1.divide(q1).getRest());

        //MVC.Monomial a = new MVC.Monomial();

        //a.stringToMonomial("- 41.3 * x^5 + 4x^3");

        //System.out.println(p.plus(q).toString());

    }

}

