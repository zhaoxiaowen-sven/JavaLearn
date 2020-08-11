package chain.demo1;

import com.sun.javaws.exceptions.ErrorCodeResponseException;

import java.util.ArrayList;
import java.util.List;

public class Chain {

    private List<Interceptor> interceptorList = new ArrayList<>();

    public Chain(List<Interceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    private int index;

    public Chain(List<Interceptor> interceptorList, int index) {
        this.interceptorList = interceptorList;
        this.index = index;
    }

    public String proceed() {
        if (index >= interceptorList.size()){
//            throw new Error("out of size");
            return  "";
        }

        Chain next = new Chain(interceptorList, index + 1);
        Interceptor interceptor = interceptorList.get(index);
        return interceptor.intercept(next);
    }
}
