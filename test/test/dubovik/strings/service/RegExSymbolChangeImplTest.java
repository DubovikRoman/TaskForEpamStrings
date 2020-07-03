package test.dubovik.strings.service;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.impl.RegExSymbolChangeImpl;
import com.dubovik.strings.service.impl.StringSymbolChangeImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RegExSymbolChangeImplTest {

    @Test
    public void testChangeSymbolByIndex() throws InvalidDataException {
        RegExSymbolChangeImpl test = new RegExSymbolChangeImpl();
        String string = "Жыве  - Беларусь!!!";
        String actual = test.changeSymbolByIndex(string, 1, "и");
        String expected = "Живе  - Биларусь!!!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChangeSymbolAfterAnother() throws InvalidDataException {
        RegExSymbolChangeImpl test = new RegExSymbolChangeImpl();
        String string = "Жыве  - Беларусь!!!";
        String actual = test.changeSymbolAfterAnother(string, "е", "л", "п");
        String expected = "Жыве  - Бепарусь!!!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChangeWordByLength() throws InvalidDataException {
        RegExSymbolChangeImpl test = new RegExSymbolChangeImpl();
        String string = "Жыве Беларусь";
        String actual = test.changeWordByLength(string, "Мы", 4);
        String expected = "Мы Беларусь";
        Assert.assertEquals(actual, expected);
    }
}