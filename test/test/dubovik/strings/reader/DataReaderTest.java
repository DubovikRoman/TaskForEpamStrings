package test.dubovik.strings.reader;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.reader.DataReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataReaderTest {

    @Test
    public void testReadDataFile() throws InvalidDataException {
        DataReader reader = new DataReader();
        String actual = reader.readDataFile("input/input.txt");
        String expected = "Hi!!! What's up?";
        Assert.assertEquals(actual, expected);
    }
}