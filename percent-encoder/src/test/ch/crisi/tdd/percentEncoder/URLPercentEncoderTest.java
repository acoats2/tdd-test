package ch.crisi.tdd.percentEncoder;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class URLPercentEncoderTest {

    @Test
    public void encodeExclamationMark() {
        String actual = URLPercentEncoder.encode("!");
        assertEquals("%21", actual);
    }

    @Test
    public void encodeNumberSign() {
        String actual = URLPercentEncoder.encode("#");
        assertEquals("%23", actual);
    }

    @Test
    public void encodeDollarSign() {
        String actual = URLPercentEncoder.encode("$");
        assertEquals("%24", actual);
    }

    @Test
    public void encodePercentSign() {
        String actual = URLPercentEncoder.encode("%");
        assertEquals("%25", actual);
    }

    @Test
    public void encodeAmpersand() {
        String actual = URLPercentEncoder.encode("&");
        assertEquals("%26", actual);
    }

    @Test
    public void encodeApostrophe() {
        String actual = URLPercentEncoder.encode("'");
        assertEquals("%27", actual);
    }

    @Test
    public void encodeOpeningBracket() {
        String actual = URLPercentEncoder.encode("(");
        assertEquals("%28", actual);
    }

    @Test
    public void encodeClosingBracket() {
        String actual = URLPercentEncoder.encode(")");
        assertEquals("%29", actual);
    }

    @Test
    public void encodeAsterisk() {
        String actual = URLPercentEncoder.encode("*");
        assertEquals("%2A", actual);
    }

    @Test
    public void encodePlusSign() {
        String actual = URLPercentEncoder.encode("+");
        assertEquals("%2B", actual);
    }

    @Test
    public void encodeComma() {
        String actual = URLPercentEncoder.encode(",");
        assertEquals("%2C", actual);
    }

    @Test
    public void encodeSlash() {
        String actual = URLPercentEncoder.encode("/");
        assertEquals("%2F", actual);
    }

    @Test
    public void encodeColon() {
        String actual = URLPercentEncoder.encode(":");
        assertEquals("%3A", actual);
    }

    @Test
    public void encodeSemicolon() {
        String actual = URLPercentEncoder.encode(";");
        assertEquals("%3B", actual);
    }

    @Test
    public void encodeEqualSign() {
        String actual = URLPercentEncoder.encode("=");
        assertEquals("%3D", actual);
    }

    @Test
    public void encodeQuestionMark() {
        String actual = URLPercentEncoder.encode("?");
        assertEquals("%3F", actual);
    }

    @Test
    public void encodeAt() {
        String actual = URLPercentEncoder.encode("@");
        assertEquals("%40", actual);
    }

    @Test
    public void encodeOpeningSquareBracket() {
        String actual = URLPercentEncoder.encode("[");
        assertEquals("%5B", actual);
    }

    @Test
    public void encodeClosingSquareBracket() {
        String actual = URLPercentEncoder.encode("]");
        assertEquals("%5D", actual);
    }

    @Test
    public void encodeEmptySpace() {
        String actual = URLPercentEncoder.encode(" ");
        assertEquals("%20", actual);
    }

    @Test
    public void encodeMultipleReservedAndUnreservedChars() {
        String actual = URLPercentEncoder.encode("http://www.google.com");
        assertEquals("http%3A%2F%2Fwww.google.com", actual);
    }

    @Test
    public void encodeAllChars() {
        String actual = URLPercentEncoder.encodeAll("http://www.google.com");
        assertEquals("%68%74%74%70%3A%2F%2F%77%77%77%2E%67%6F%6F%67%6C%65%2E%63%6F%6D", actual);
    }

}