/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2pcom;

/**
 *
 * @author Cmglz
 */
public class Config {
    public static final int sendPort = 8080;
    public static final int receport = 9999;
    public static final int timeOut = 3000; //超时应该在3钞以上
    
    public static final String send_r="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAOArsd8c4jq2fuHU/G+2zPDUcL3dxbip1HXQueqjys9HQGe1LfW8k+h5yF/KyJgj9YgYfJ6BNIKqyXzRpZaI0P4vYiekRD784HSpBvgG178lZYtv900LJ9ZD43Y7D5WtWpijqRdLqMP3BVxsVh9laWwmeRCUATpYA0rFdpU/jJKvAgMBAAECgYAH3gC0D9NwtA7n5g2l7ghrO0lpoGrb/DnUmKqtrWnktF9yRE2EnkWilwONORSpIjnvuMxG08n/+/ZuRv1EtzB+alraggQESaAB/an+nLXAd/ppyqPj/MDyuPE7sJpgc7W5MQGfrIQ7wJf9YWIxcojah0QtPQrLXxNKAmykGmSc4QJBAP6DfD97AmY4sDoJi9zOgMoagHPXbJ0rHweWzLTUTBIrYpiCVMxfvyolWFoUVr2UEMJsC8pTZJnSdjivI43qCmUCQQDhethDjxofv9oQKQXojHOXE6OTwaSy5EmAbDPIVsYI6TYvWIxjPzGs2R4vsFPtefgYEBQ8GKQdncmsiisDB62DAkEA9IpvQis1xfPn1wu/F5xOgGFwVF2DHYwGF2ucKo7kvHx1EmX/hhLlAWC6gGqUYTi31aasuWzg9y8RqisVNVDPRQJBAIzXFs7cTA0Y4TTG6xHe6TSs57gbdKzpO6Aj9hRlXz2hrl7UiJxVlMnKtLhFA6eKUBV3tav0GE8HiDll9Ifn+9ECQQD65eTOIzwNmVTLP8+ZoKIaKSEGuQwzuY9BQwtQGlZ8W4VZ3sq2Mh3f8+r5rqr12K04ue6Y4Ode/TIli4yCvhKt";
    public static final String send_p="MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAtlAnsRHzMc0Wa2DjdBHr" +
"JlFXLoFsYJxXQ4hwre1FPUJS3mjHKDqjpZIgXphR4ado2GLHVzcyLtZ+ehUHTJ9Q" +
"ue6abZe0TZI4S1mOswZ6c8RuNgs1D3IyJlwwomEjOQIF/QxH5nfl3qk/14v20LyU" +
"PuPoUNKFLFs+y3A/gpRRs6rb3H8kDad/1LiVuBXg0M/iwuRgBbc++SEwQ59lgN7Y" +
"ckvjHV/UfJ0h/MHL9XoW7mIZVZ71PPy2yleAvfdS5wfyJfPTjmBmWbHqbiBm/YZi" +
"yRbJcAojWstYLpGKVXgsW1B9PFWivV0ATgwjOzHYP9EJ9dTf3houk652+jGnLJTF" +
"YBtpB8C+zAqLGQA3XGtUi1E8D5SDjvPZ4wFxiroohmHkOGmVNZ1xsUy5RpU9lsJv" +
"OVYbNqAwU2fyPci2giaZjO8fViIyOCMulaY/LFdqN4TApex6PB5YOGe0muuuEWar" +
"149qmLRxiwS69aBYL7PII9+Tv+99nigP4RRCZshK62jHhGoDNXLhAed64etlWHE7" +
"r2cakrrBZhf76BOXY/wxmK35Sp1h/caSslJj3zrVJmy13NcODsNNSm+vLgnVwX4H" +
"2EMrZqawI0wKxhfFJfTTIiRVdL2JgdYdJ2Q8jrhrXPqly2/FQmlxxLq5IXCUr++A" +
"kUa1g8RqQEZYU2iliBqFdt8CAwEAAQ==";
    public static final String rece_r="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" +
"Iekrd+UM1dlLT2wvnfazuBboppuBWqA=";
    public static final String rece_p="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgK7HfHOI6tn7h1Pxvtszw1HC93cW4qdR10Lnqo8rPR0BntS31vJPoechfysiYI/WIGHyegTSCqsl80aWWiND+L2InpEQ+/OB0qQb4Bte/JWWLb/dNCyfWQ+N2Ow+VrVqYo6kXS6jD9wVcbFYfZWlsJnkQlAE6WANKxXaVP4ySrwIDAQAB";
}
