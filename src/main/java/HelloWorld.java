import javax.ejb.Remote;

@Remote
public interface HelloWorld {
    String sayHello();
}