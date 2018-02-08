package cn.cisdom.base.interceptor;

import cn.cisdom.base.utils.ConfigConstant;
import cn.cisdom.base.utils.ParamsUtils;
import okhttp3.*;
import okio.Buffer;
import java.io.IOException;

/**
 * Created by zhenglee on 2017/8/30.
 */
public class EncryptInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response;
        if (ConfigConstant.IS_DEBUG) {
            final Buffer buffer = new Buffer();
            final Request copy = request.newBuilder().build();
            copy.body().writeTo(buffer);
            final String[] params = buffer.readUtf8().split("&");
            final StringBuilder sb = new StringBuilder();
            for (String param : params) {
                sb.append(param + "&");
            }
            CharSequence sub = sb.subSequence(0, sb.length() - 1);
            System.out.println("before code: " + sub);
            String encode = null;
            try {
                encode = ParamsUtils.encrypt(sub.toString(), ConfigConstant.API_SALT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("after code: " + encode);
            RequestBody body = RequestBody.create(request.body().contentType(), encode);
            Request newReq = request.newBuilder().url(request.url()).post(body).build();
            response = chain.proceed(newReq);
        } else {
            response = chain.proceed(request);
        }

        return response;
    }

}
