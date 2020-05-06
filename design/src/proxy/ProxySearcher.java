package proxy;

public class ProxySearcher {

    private RealSearcher realSearcher = new RealSearcher();
    private AccessValidator validator = new AccessValidator();
    private Logger logger = new Logger();

    public void doSearch(String userId, String keyWord){
        if (validator.validate(userId)){
            realSearcher.doSearch(userId, keyWord);
            logger.log(userId, true);
        } else {
            logger.log(userId, false);
        }


    }


}
