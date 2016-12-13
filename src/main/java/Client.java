import javax.naming.Context;
import javax.naming.NamingException;

public class Client {
    public static void main(String[] args) {
        HelloWorld bean = doLookup(HelloWorldBean.class);
        System.out.println(bean.sayHello());

        HelloWorldStateFull stateFull = doLookupStateFul(HelloWorldStateFullImpl.class);
        System.out.println("Initial Count: " + stateFull.getCount());
        System.out.println(stateFull.sayHello());
        System.out.println("Count: " + stateFull.getCount());
    }

    private static <T> T doLookup(Class<T> tClass) {
        Context context;
        T bean = null;
        try {
            context = ClientUtility.getInitialContext();
            String lookupName = getLookupName(tClass);
            bean = (T) context.lookup(lookupName);

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private static <T> T doLookupStateFul(Class<T> tClass) {
        Context context;
        T bean = null;
        try {
            context = ClientUtility.getInitialContext();
            String lookupName = getLookupNameStateful(tClass);
            bean = (T) context.lookup(lookupName);

        } catch (NamingException e) {
            e.printStackTrace();
        }
        return bean;
    }

    private static <T> String getLookupNameStateful(Class<T> tClass) {
        String appName = "";

        String moduleName = "ejbtutorial-1.0-SNAPSHOT";
        String distinctName = "";

        String beanName = tClass.getSimpleName();

        final String interfaceName = tClass.getInterfaces()[0].getName();

        String name = "ejb:" + appName + "/" + moduleName + "/" +
                distinctName + "/" + beanName + "!" + interfaceName + "?stateful";
        return name;
    }

    private static <T> String getLookupName(Class<T> tClass) {
        String appName = "";

        String moduleName = "ejbtutorial-1.0-SNAPSHOT";
        String distinctName = "";

        String beanName = tClass.getSimpleName();

        final String interfaceName = tClass.getInterfaces()[0].getName();

        String name = "ejb:" + appName + "/" + moduleName + "/" +
                distinctName + "/" + beanName + "!" + interfaceName;
        return name;
    }
}