package Exceptions;

public class ZeroDivision extends Exception {
    private String msg;

    public ZeroDivision(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "    ZeroDividingError" + '\n' + msg + '\n';
    }

    public void display()
    {
        System.out.println(msg);
    }
}
