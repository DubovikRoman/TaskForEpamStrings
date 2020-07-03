package test.dubovik.strings.service;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.impl.CharSymbolChangeImpl;
import com.dubovik.strings.service.impl.StringSymbolChangeImpl;
import com.dubovik.strings.service.impl.StringSymbolRemoveImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharSymbolChangeImplTest {

    @Test
    public void testChangeSymbolByIndex() throws InvalidDataException {
        CharSymbolChangeImpl test = new CharSymbolChangeImpl();
        String string = "Жыве  Беларусь!!!";
        String actual = test.changeSymbolByIndex(string, 1, "и");
        String expected = "Живе  Биларусь!!!";
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testChangeSymbolAfterAnother() throws InvalidDataException {
        CharSymbolChangeImpl test = new CharSymbolChangeImpl();
        String string = "Жыве  - Беларусь!!!";
        String actual = test.changeSymbolAfterAnother(string, "е", "л", "п");
        String expected = "Жыве  - Бепарусь!!!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testChangeWordByLength() throws InvalidDataException {
        CharSymbolChangeImpl test = new CharSymbolChangeImpl();
        String string = "Жыве Беларусь";
        String actual = test.changeWordByLength(string, "Мы", 4);
        String expected = "Мы Беларусь ";
        Assert.assertEquals(actual, expected);
    }
}