package chain.demo1;

public class BInterceptor implements Interceptor{
    @Override
    public String intercept(Chain chain) {

        for (int i = 0; i<1 ; i++)  {
            System.out.println("before b");
            chain.proceed();

            System.out.println("after b");
        }

        return "b";
    }
}
