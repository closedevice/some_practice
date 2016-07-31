package other;


import com.sun.jndi.toolkit.url.Uri;

import java.net.URI;
import java.net.URL;
import java.util.Random;

/**
 * Created by God on 2016/5/12.
 */
public class JSInjectUtil {
    private static String TAG_JS_CREATE = "var %s = document.createElement(\"script\");";
    private static String TAG_JS_CONTENT = "%s.innerHTML=%s;";
    private static String TAG_JS_ATTR = "%s.src=\"%s\";";
    private static String TAG_JS_END = "document.body.appendChild(%s);";

    //public static void remoteInject(WebView wb, String... url) {
    //    execute(wb, createRemoteInfo(url));
    //}

    public static String createRemoteInfo(String... url) {
        StringBuilder jsList = new StringBuilder();
        for (String s : url) {
            String fileName = defaultJSName();
            StringBuilder builder = new StringBuilder(String.format(TAG_JS_CREATE, fileName));
            builder.append(String.format(TAG_JS_ATTR, fileName, s));
            builder.append(String.format(TAG_JS_END,fileName));
            jsList.append(builder);
        }
        return jsList.toString();
    }

    //public static void localInject(WebView wb, String... js) {
    //    execute(wb, createLocalInfo(js));
    //}

    public static String createLocalInfo(String... js) {
        StringBuilder jsList = new StringBuilder();
        for (String s : js) {
            String fileName = defaultJSName();
            StringBuilder builder = new StringBuilder(String.format(TAG_JS_CREATE, fileName));
            builder.append(String.format(TAG_JS_CONTENT, fileName, s));
            builder.append(String.format(TAG_JS_END,fileName));
            jsList.append(builder);
        }

        return jsList.toString();
    }

    //private static void execute(WebView wb, String s) {
    //    wb.loadUrl(s);
    //}

    private static String createJSName(String prefix) {
        return prefix + new Random().nextInt(20);
    }

    private static String defaultJSName() {
        return createJSName("st_");
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com/test.sj";
        String url1 = "http://www.baidu.com/test.sj";
        URI uri = URI.create(url);
        System.out.println(createRemoteInfo(url,url1));

        String jsContent = "alert('!!!');alert('33');function(){alert('dong')}";
        System.out.println(createLocalInfo(jsContent));


    }


}
