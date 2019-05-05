package design.flyweight;

import java.util.Hashtable;

public class IgoChessmanFactory {
    private static Hashtable<String, IgoChessman> ht;

    private IgoChessmanFactory() {
        ht = new Hashtable<>();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        ht.put("b", black);
        white = new WhiteIgoChessman();
        ht.put("w", white);
    }

    public static IgoChessmanFactory getInstance() {
        return HolderClass.mInstance;
    }

    private static class HolderClass {
        private static final IgoChessmanFactory mInstance = new IgoChessmanFactory();
    }

    public IgoChessman getIgoChessman(String key) {
        return ht.get(key);
    }

}
