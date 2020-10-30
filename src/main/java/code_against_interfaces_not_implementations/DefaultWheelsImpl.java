package code_against_interfaces_not_implementations;

public class DefaultWheelsImpl implements Wheels{
    @Override
    public void roll(){
        System.out.println("Let's roll :/ with defult wheels!!");
    }
}
