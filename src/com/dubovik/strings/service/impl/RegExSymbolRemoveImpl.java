package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolRemove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSymbolRemoveImpl implements SymbolRemove {

    public String deleteAllNonLetterSymbols(String in_text) throws InvalidDataException {
        String final_text;
        if(in_text != null) {
            String wrong_symbols = "\\p{Punct}|(\\d)";
            final_text = in_text.replaceAll(wrong_symbols, " ");
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String deleteByLengthStartsWithСonsonants(String in_text, int length) throws InvalidDataException {
        String final_text;
        if(in_text != null && length > 0) {
            String vowel_letters = "eyuioaEYUIOAуеыаоэяиюУЕЫАОЭЯИЮ";
            String correct_words = "\\b[\\p{L}&&[^\\dауоыиэяюёАУОЫИЭЯЮЁеaeiouAEIOU]][\\S]{" + (length - 1) +"}\\b";
            Pattern pattern = Pattern.compile(correct_words);
            Matcher matcher = pattern.matcher(in_text);
            final_text = matcher.replaceAll("");
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }
}
