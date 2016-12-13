import javax.ejb.Remote;

/**
 * Created by agher on 10-12-2016.
 */
@Remote
public interface HelloWorldStateFull {

    String sayHello();

    int getCount();
}
