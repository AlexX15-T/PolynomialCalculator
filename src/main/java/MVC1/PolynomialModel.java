package MVC1;

import Exceptions.ZeroDivision;

public class PolynomialModel {
    Polynomial firstPolynomial;
    Polynomial secondPolynomial;

    public PolynomialModel() {}

    public PolynomialModel(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        this.firstPolynomial = firstPolynomial;
        this.secondPolynomial = secondPolynomial;
    }

    public Polynomial getFirstPolynomial() {
        return firstPolynomial;
    }

    public void setFirstPolynomial(Polynomial firstPolynomial) {
        this.firstPolynomial = firstPolynomial;
    }

    public Polynomial getSecondPolynomial() {
        return secondPolynomial;
    }

    public void setSecondPolynomial(Polynomial secondPolynomial) {
        this.secondPolynomial = secondPolynomial;
    }

    public Polynomial add()
    {
        return firstPolynomial.plus(secondPolynomial);
    }

    public Polynomial substract()
    {
        return firstPolynomial.minus(secondPolynomial);
    }

    public Polynomial multiply()
    {
        return firstPolynomial.multiply(secondPolynomial);
    }

    public DivideResult divide() throws ZeroDivision {
        return firstPolynomial.divide(secondPolynomial);
    }

    public Polynomial derivate()
    {
        return firstPolynomial.derviate();
    }

    public Polynomial integrate()
    {
        return firstPolynomial.integrate();
    }


}
