import Exceptions.IncorrectInput;
import Exceptions.ZeroDivision;
import MVC1.Polynomial;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestP extends TestCase {
    Polynomial p, q;

    @Test
    public void TestAdd1() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial sum = new Polynomial();
        p.stringToPolynomial("x^3");
        q.stringToPolynomial("x^2");
        sum.stringToPolynomial("x^3 + x^2");
        Assertions.assertEquals(sum, p.plus(q), "Incorrect addition1!");
    }

    @Test
    public void TestAdd2() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial sum = new Polynomial();
        p.stringToPolynomial("x^3 + 1");
        q.stringToPolynomial("x^2 + x^4");
        sum.stringToPolynomial("x^3 + x^2 + 1 + x^4");
        Assertions.assertEquals(sum, p.plus(q), "Incorrect addition2!");
    }

    @Test
    public void TestAdd3() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial sum = new Polynomial();
        p.stringToPolynomial("x^3 + 1 - x^5");
        q.stringToPolynomial("x^2 + x^4 + x^6 - 1");
        sum.stringToPolynomial("x^3 + x^2 + x^4 -x^5 + x^6");
        Assertions.assertEquals(sum, p.plus(q), "Incorrect addition3!");
    }

    @Test
    public void TestAdd4() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial sum = new Polynomial();
        p.stringToPolynomial("x^3 + 2 + x^5");
        q.stringToPolynomial("-x^3 - x^5 - 1");
        sum.stringToPolynomial("1.0");
        Assertions.assertEquals(sum, p.plus(q), "Incorrect addition4!");
    }

    @Test
    public void TestAdd5() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial sum = new Polynomial();
        p.stringToPolynomial("1");
        q.stringToPolynomial("1");
        sum.stringToPolynomial("2");
        Assertions.assertEquals(sum, p.plus(q), "Incorrect addition5!");
    }

    @Test
    public void TestSubstract1() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial subs = new Polynomial();
        p.stringToPolynomial("1");
        q.stringToPolynomial("1");
        subs.stringToPolynomial("0");
        String a = p.minus(q).toString();
        String b = subs.toString();
        Assertions.assertEquals(a, b, "Incorrect substract1!");
    }

    @Test
    public void TestSubstract2() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial subs = new Polynomial();
        p.stringToPolynomial("x^4 + x^3");
        q.stringToPolynomial("x^2");
        subs.stringToPolynomial("x^4 + x^3 - x^2");
        Assertions.assertEquals(subs, p.minus(q), "Incorrect substract2!");
    }

    @Test
    public void TestSubstract3() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial subs = new Polynomial();
        p.stringToPolynomial("x^4 + x^3 + x^2 + 3x^6");
        q.stringToPolynomial("x^2 + 2x^5");
        subs.stringToPolynomial("x^4 + x^3 + 3x^6 - 2x^5");
        Assertions.assertEquals(subs, p.minus(q), "Incorrect substract3!");
    }

    @Test
    public void TestSubstract4() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial subs = new Polynomial();
        p.stringToPolynomial("x^4 + x^3 + x^2 + 3x^6 + 1 + x^7");
        q.stringToPolynomial("x^2 + 2x^5 + 3 + x");
        subs.stringToPolynomial("x^4 + x^3 + 3x^6 - 2x^5 - 2 + x^7 - x");
        Assertions.assertEquals(subs, p.minus(q), "Incorrect substract4!");
    }

    @Test
    public void TestSubstract5() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial subs = new Polynomial();
        p.stringToPolynomial("x^4 + x^3 + x^2");
        q.stringToPolynomial("1 + x + x^5");
        subs.stringToPolynomial("x^4 + x^3 -x - 1 - x^5 + x^2");
        Assertions.assertEquals(subs, p.minus(q), "Incorrect substract5!");
    }

    @Test
    public void TestMultiply1() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x");
        q.stringToPolynomial("x^2 + 2x^5");
        m.stringToPolynomial("x^3 + 2x^6");
        Assertions.assertEquals(m, p.multiply(q), "Incorrect multiply1!");
    }

    @Test
    public void TestMultiply2() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^4");
        q.stringToPolynomial("-x^2 + 2x^5 + 1");
        m.stringToPolynomial("2x^9 -x^6 + x^4");
        Assertions.assertEquals(m, p.multiply(q), "Incorrect multiply2!");
    }

    @Test
    public void TestMultiply3() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
        q.stringToPolynomial("x^5 + 22.6x^4 - x^3 - 41.3x + 4.2");
        m.stringToPolynomial("22.60x^11 + 511.76x^10 - 41.30x^9 - 934.38x^8 - 893.08x^7 + 31.02x^6 + 1706.69x^5 - 268.38x^4 + 45.50x^3 - 4.20x^2 + 173.46x - 17.64");
        Assertions.assertEquals(m.toString(), p.multiply(q).toString(), "Incorrect multiply3!");
    }

    @Test
    public void TestMultiply4() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        q.stringToPolynomial("x + 2");
        m.stringToPolynomial("-1.00x^3 + 6.00x + 4.00");
        Assertions.assertEquals(m.toString(), p.multiply(q).toString(), "Incorrect multiply4!");
    }

    @Test
    public void TestMultiply5() throws IncorrectInput {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        q.stringToPolynomial("0");
        m.stringToPolynomial("0");
        Assertions.assertEquals(m.toString(), p.multiply(q).toString(), "Incorrect multiply5!");
    }

    @Test
    public void TestDivide1() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        q.stringToPolynomial("x");
        m.stringToPolynomial("-x + 2");
        Assertions.assertEquals(m.toString(), p.divide(q).getQ().toString(), "Incorrect divide1!");
    }

    @Test
    public void TestDivide2() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
        q.stringToPolynomial("x^5 + 22.6x^4 - x^3 - 41.3x + 4.2");
        m.stringToPolynomial("22.60x - 509.76");
        Assertions.assertEquals(m.toString(), p.divide(q).getQ().toString(), "Incorrect divide2!");
    }

    @Test
    public void TestDivide3() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        q.stringToPolynomial("x^2 + 2");
        m.stringToPolynomial("-1");
        Assertions.assertEquals(m.toString(), p.divide(q).getQ().toString(), "Incorrect divide3!");
    }

    @Test
    public void TestDivide4() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^4");
        q.stringToPolynomial("x^3");
        m.stringToPolynomial("x");
        Assertions.assertEquals(m.toString(), p.divide(q).getQ().toString(), "Incorrect divide4!");
    }

    @Test
    public void TestDivide5() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^4 + x^6");
        q.stringToPolynomial("1");
        m.stringToPolynomial("x^4 + x^6");
        Assertions.assertEquals(m.toString(), p.divide(q).getQ().toString(), "Incorrect divide5!");
    }

    @Test
    public void TestModulo1() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^4");
        q.stringToPolynomial("x^3");
        m.stringToPolynomial("0");
        Assertions.assertEquals(m.toString(), p.divide(q).getRest().toString(), "Incorrect modulo1!");
    }

    @Test
    public void TestModulo2() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        q.stringToPolynomial("x + 2");
        m.stringToPolynomial("-6.00");
        Assertions.assertEquals(m.toString(), p.divide(q).getRest().toString(), "Incorrect modulo2!");
    }

    @Test
    public void TestModulo3() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
        q.stringToPolynomial("x^5 + 22.6x^4 - x^3 - 41.3x + 4.2");
        m.stringToPolynomial("11501.88x^4 - 509.76x^3 + 932.38x^2 - 21148.01x + 2136.79");
        Assertions.assertEquals(m.toString(), p.divide(q).getRest().toString(), "Incorrect modulo3!");
    }

    @Test
    public void TestModulo4() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 2x^4 + x");
        q.stringToPolynomial("2x^3");
        m.stringToPolynomial("x");
        Assertions.assertEquals(m.toString(), p.divide(q).getRest().toString(), "Incorrect modulo4!");
    }

    @Test
    public void TestModulo5() throws IncorrectInput, ZeroDivision {
        p = new Polynomial();
        q = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 2x^4 + x + x^2 - 5.3x^3");
        q.stringToPolynomial("2x^3 + 1");
        m.stringToPolynomial("0.50x^2 + 2.65");
        Assertions.assertEquals(m.toString(), p.divide(q).getRest().toString(), "Incorrect modulo5!");
    }

    @Test
    public void TestIntegrate1() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 2x^4 + x + x^2 - 5.3x^3");
        m.stringToPolynomial("0.17x^6 + 0.40x^5 - 1.33x^4 + 0.33x^3 + 0.50x^2");
        Assertions.assertEquals(m.toString(), p.integrate().toString(), "Incorrect integrate1!");
    }

    @Test
    public void TestIntegrate2() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
        m.stringToPolynomial("3.23x^7 + 0.17x^6 - 8.26x^5 - 0.33x^3 - 4.20x");
        Assertions.assertEquals(m.toString(), p.integrate().toString(), "Incorrect integrate2!");
    }

    @Test
    public void TestIntegrate3() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        m.stringToPolynomial("-0.33x^3 + 1.00x^2 + 2.00x");
        Assertions.assertEquals(m.toString(), p.integrate().toString(), "Incorrect integrate3!");
    }

    @Test
    public void TestIntegrate4() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x");
        m.stringToPolynomial("0.5x^2");
        Assertions.assertEquals(m.toString(), p.integrate().toString(), "Incorrect integrate4!");
    }

    @Test
    public void TestIntegrate5() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("1");
        m.stringToPolynomial("x");
        Assertions.assertEquals(m.toString(), p.integrate().toString(), "Incorrect integrate5!");
    }

    @Test
    public void TestDerivate1() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("1");
        m.stringToPolynomial("0");
        Assertions.assertEquals(m.toString(), p.derviate().toString(), "Incorrect derivate1!");
    }

    @Test
    public void TestDerivate2() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x");
        m.stringToPolynomial("1");
        Assertions.assertEquals(m.toString(), p.derviate().toString(), "Incorrect derivate2!");
    }

    @Test
    public void TestDerivate3() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("x^5 + 22.6x^6 - x^2 - 41.3x^4 - 4.2");
        m.stringToPolynomial("135.60x^5 + 5.00x^4 - 165.20x^3 - 2.00x");
        Assertions.assertEquals(m.toString(), p.derviate().toString(), "Incorrect derivate3!");
    }

    @Test
    public void TestDerivate4() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("2x^3 + 1");
        m.stringToPolynomial("6x^2");
        Assertions.assertEquals(m.toString(), p.derviate().toString(), "Incorrect derivate4!");
    }

    @Test
    public void TestDerivate5() throws IncorrectInput{
        p = new Polynomial();
        Polynomial m = new Polynomial();
        p.stringToPolynomial("-x^2 + 2x + 2");
        m.stringToPolynomial("-2x + 2");
        Assertions.assertEquals(m.toString(), p.derviate().toString(), "Incorrect derivate5!");
    }
    
}
