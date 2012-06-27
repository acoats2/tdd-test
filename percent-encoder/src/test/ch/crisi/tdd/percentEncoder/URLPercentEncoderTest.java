package ch.crisi.tdd.percentEncoder;

import org.junit.Test;

import static ch.crisi.tdd.percentEncoder.URLPercentEncoder.encode;
import static ch.crisi.tdd.percentEncoder.URLPercentEncoder.encodeAll;
import static junit.framework.Assert.assertEquals;

public class URLPercentEncoderTest {

    @Test
    public void encodeExclamationMark() {
        assertEquals("%21", encode("!"));
    }

    @Test
    public void encodeNumberSign() {
        assertEquals("%23", encode("#"));
    }

    @Test
    public void encodeDollarSign() {
        assertEquals("%24", encode("$"));
    }

    @Test
    public void encodePercentSign() {
        assertEquals("%25", encode("%"));
    }

    @Test
    public void encodeAmpersand() {
        assertEquals("%26", encode("&"));
    }

    @Test
    public void encodeApostrophe() {
        assertEquals("%27", encode("'"));
    }

    @Test
    public void encodeOpeningBracket() {
        assertEquals("%28", encode("("));
    }

    @Test
    public void encodeClosingBracket() {
        assertEquals("%29", encode(")"));
    }

    @Test
    public void encodeAsterisk() {
        assertEquals("%2A", encode("*"));
    }

    @Test
    public void encodePlusSign() {
        assertEquals("%2B", encode("+"));
    }

    @Test
    public void encodeComma() {
        assertEquals("%2C", encode(","));
    }

    @Test
    public void encodeSlash() {
        assertEquals("%2F", encode("/"));
    }

    @Test
    public void encodeColon() {
        assertEquals("%3A", encode(":"));
    }

    @Test
    public void encodeSemicolon() {
        assertEquals("%3B", encode(";"));
    }

    @Test
    public void encodeEqualSign() {
        assertEquals("%3D", encode("="));
    }

    @Test
    public void encodeQuestionMark() {
        assertEquals("%3F", encode("?"));
    }

    @Test
    public void encodeAt() {
        assertEquals("%40", encode("@"));
    }

    @Test
    public void encodeOpeningSquareBracket() {
        assertEquals("%5B", encode("["));
    }

    @Test
    public void encodeClosingSquareBracket() {
        assertEquals("%5D", encode("]"));
    }

    @Test
    public void encodeEmptySpace() {
        assertEquals("%20", encode(" "));
    }

    @Test
    public void encodeMultipleReservedAndUnreservedChars() {
        assertEquals("http%3A%2F%2Fwww.google.com", encode("http://www.google.com"));
    }

    @Test
    public void encodeAllChars() {
        assertEquals("%68%74%74%70%3A%2F%2F%77%77%77%2E%67%6F%6F%67%6C%65%2E%63%6F%6D", encodeAll("http://www.google.com"));
    }

}