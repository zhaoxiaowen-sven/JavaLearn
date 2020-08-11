package chain.demo1;

public class AInterceptor implements Interceptor{
    @Override
    public String intercept(Chain chain) {
        System.out.println("before a");
        chain.proceed();
        System.out.println("after a");
        return "A";
    }
}
