package chain.demo1;

import java.util.ArrayList;
import java.util.List;

public class ChainTest {

    public static void testChain() {
        List<Interceptor>  interceptors = new ArrayList<>();
        AInterceptor aInterceptor = new AInterceptor();
        BInterceptor bInterceptor = new BInterceptor();
        CInterceptor CInterceptor = new CInterceptor();
        interceptors.add(aInterceptor);
        interceptors.add(bInterceptor);
        interceptors.add(CInterceptor);

        Chain chain = new Chain(interceptors, 0);
        System.out.println(chain.proceed());
    }
}
