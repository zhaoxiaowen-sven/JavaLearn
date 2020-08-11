package chain.demo1;

public class CInterceptor implements Interceptor{
    @Override
    public String intercept(Chain chain) {

        System.out.println("before c");
//        chain.proceed();
//        if (true) {
//            throw new Error("aaaaa");
//        }
        System.out.println("after c");
        return "b";
    }
}
