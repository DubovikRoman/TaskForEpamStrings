package test.dubovik.strings.service;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.impl.CharSymbolRemoveImpl;
import com.dubovik.strings.service.impl.StringSymbolRemoveImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CharSymbolRemoveImplTest {

    @Test
    public void testDeleteAllNonLetterSymbols() throws InvalidDataException {
        CharSymbolRemoveImpl test = new CharSymbolRemoveImpl();
        String string = "Roma --!#%!@#! Masha";
        String expected = "Roma           Masha";
        String actual = test.deleteAllNonLetterSymbols(string);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDeleteByLengthStartsWithСonsonants() throws InvalidDataException {
        CharSymbolRemoveImpl test = new CharSymbolRemoveImpl();
        String string = "Roma Masha";
        String expected = "Roma ";
        String actual = test.deleteByLengthStartsWithСonsonants(string, 5);
        Assert.assertEquals(actual, expected);
    }
}