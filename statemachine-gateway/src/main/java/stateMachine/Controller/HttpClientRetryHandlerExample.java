package stateMachine.Controller;


import org.apache.http.HttpResponse;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.config.RequestConfig;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;


import static java.lang.Thread.sleep;

public class HttpClientRetryHandlerExample {


    public static void main(String... args) throws IOException {



        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(5000).setConnectTimeout(5000).build();
       /* ConnectionConfig connectionConfig = new ConnectionConfig();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultConnectionConfig(requestConfig);*/

        CloseableHttpClient httpClient = HttpClients.custom().build();
        int times = 3;
        int retry = -1;
        //CloseableHttpClient httpClient = getHttpClient();
        try {
            do {
                HttpPost httpget = new HttpPost("http://www.json.cn/");
                httpget.setConfig(requestConfig);
                System.out.println("Executing request " + httpget.getRequestLine());
                CloseableHttpResponse response = httpClient.execute(httpget);
                retry ++;
                times --;
                int code = response.getStatusLine().getStatusCode();
                if (code == HttpStatus.SC_OK) {
                    System.out.println("class=HttpClient,method=postJson,notifyResult=success");
                    break;
                }else {
                    System.out.println("class=HttpClient,method=postJson," +
                            "=failed,retry="+retry);
                }
            }while (times >= 0);
            System.out.println("----------------------------------------");
            System.out.println("Request finished");
        } finally {
            httpClient.close();
        }
    }

    public static CloseableHttpClient getHttpClient() {
        ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy = new ServiceUnavailableRetryStrategy() {
            /**
             * retry逻辑
             */
           @Override
            public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {
                if (executionCount <3 && response.getStatusLine().getStatusCode() != 200) {
                    System.out.println("try request: " + executionCount);
                    return true;
                } else {
                    return false;
                }
            }

            /**
             * retry间隔时间
             */
            @Override
            public long getRetryInterval() {
                return 2000;
            }
        };

        return HttpClients.custom().setServiceUnavailableRetryStrategy(serviceUnavailableRetryStrategy).build();
    }


    private static HttpRequestRetryHandler retryHandler(){
        return (exception, executionCount, context) -> {


            if (executionCount > 3) {
                // Do not retry if over max retry count
                return false;
            }

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("try request: " + executionCount);

/*
            if (exception instanceof InterruptedIOException) {
                // Timeout
                return false;
            }
            if (exception instanceof UnknownHostException) {
                // Unknown host
                return false;
            }
            if (exception instanceof SSLException) {
                // SSL handshake exception
                return false;
            }
            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
            if (idempotent) {
                // Retry if the request is considered idempotent
                return true;
            }*/
            return true;
        };
    }



}
