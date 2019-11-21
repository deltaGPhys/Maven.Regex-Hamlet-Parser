import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHoratioToTariq() {
        String data = "Hamlet and eggs and Horatios and begs Horatio";
        String actual = hamletParser.horatioReplacer(data);
        String expected = "Hamlet and eggs and Tariqs and begs Tariq";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeon() {
        String data = "Hamlet and eggs and Hamlets and begs";
        String actual = hamletParser.hamletReplacer(data);
        String expected = "Leon and eggs and Leons and begs";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void replacementTestHamlet() {
        String data = hamletText;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        Assert.assertTrue(matcher.find());

        data = hamletParser.parseHamlet();
        pattern = Pattern.compile("Hamlet");
        matcher = pattern.matcher(data);
        Assert.assertFalse(matcher.find());
    }

    @Test
    public void replacementTestHoratio() {
        String data = hamletText;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        Assert.assertTrue(matcher.find());

        data = hamletParser.parseHamlet();
        pattern = Pattern.compile("Horatio");
        matcher = pattern.matcher(data);
        Assert.assertFalse(matcher.find());
    }
}