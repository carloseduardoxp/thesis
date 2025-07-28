
public class Teste {

    public static void main(String[] args) {
        webView = (WebView) rootView.findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("my url");
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                try {

                    // do whatever you want to do on a web link click
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }

        });

        webView.loadUrl("url to open first webpage on a webview");
    }

}

public class MyWebClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        Log.e("URL", url);
        return true;
    }
}
