package ch.crisi.tdd.percentEncoder;

public class URLPercentEncoder {

    private static final char[] RESERVED_CHARS = {' ', '!', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '/', ':', ';', '=', '?', '@', '[', ']'};

    private URLPercentEncoder() {
    }

    public static String encode(String url) {
        StringBuilder percentEncodedURL = new StringBuilder();

        for (int i = 0; i < url.length(); i++) {
            char currentChar = url.charAt(i);
            boolean isReserved = false;

            for (int j = 0; j < RESERVED_CHARS.length; j++) {
                if (currentChar == RESERVED_CHARS[j]) {
                    isReserved = true;
                    break;
                }
            }

            if(isReserved) {
                percentEncodedURL.append(getPercentEncoding(currentChar));
            } else {
                percentEncodedURL.append(currentChar);
            }
        }
        
        return percentEncodedURL.toString();
    }

    public static String encodeAll(String url) {
        StringBuilder percentEncodedURL = new StringBuilder();

        for (int i = 0; i < url.length(); i++) {
            char currentChar = url.charAt(i);
            percentEncodedURL.append(getPercentEncoding(currentChar));
        }

        return percentEncodedURL.toString();
    }

    private static String getPercentEncoding(char c) {
        String encodedChar = "%" + Integer.toHexString((int)c);
        return encodedChar.toUpperCase();
    }
}