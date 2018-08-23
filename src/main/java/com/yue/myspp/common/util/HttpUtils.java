package com.yue.myspp.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.util.CollectionUtils;

/**
 * http请求工具类
 */
public class HttpUtils {

    private HttpUtils() {
    }

    private static HttpClient httpClient = HttpClientBuilder.create().build();

    /**
     * http post请求
     *
     * @param url url地址
     * @param headers header参数
     * @param params 表单参数
     */
    public static HttpResponse postRequest(String url, Map<String, String> headers,
        Map<String, String> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        //构建header
        if (!CollectionUtils.isEmpty(headers)) {
            Set<String> keyHeaders = headers.keySet();
            for (String key : keyHeaders) {
                httpPost.setHeader(key, headers.get(key));
            }
        }
        //构建表单参数
        if (!CollectionUtils.isEmpty(params)) {
            List<NameValuePair> paramsEntity = new ArrayList<>();
            Set<String> keyParams = params.keySet();
            for (String key : keyParams) {
                paramsEntity.add(new BasicNameValuePair(key, params.get(key)));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramsEntity);
            httpPost.setEntity(entity);
        }
        return httpClient.execute(httpPost);
    }
}
