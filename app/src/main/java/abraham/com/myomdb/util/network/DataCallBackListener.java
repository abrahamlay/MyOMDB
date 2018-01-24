package abraham.com.myomdb.util.network;

/**
 * Created by Abraham on 24/01/2018.
 */

public interface DataCallBackListener {
    void onLoadingSucceed(Object data);

    void onLoadingEmpty(Object data);

    void onLoadingFailed(Object data);
}
