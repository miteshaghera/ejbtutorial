import javax.ejb.Stateful;

/**
 * Created by agher on 10-12-2016.
 */
@Stateful
public class HelloWorldStateFullImpl implements HelloWorldStateFull {

    private static volatile int count = 0;

    @Override
    public String sayHello() {
        count++;
        return "Hello World!!!";
    }

    @Override
    public int getCount() {
        return count;
    }
}
