package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolChange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExSymbolChangeImpl implements SymbolChange {

    public String changeSymbolByIndex(String in_text, int index, String symbol) throws InvalidDataException {
        String final_text;
        if(in_text != null && index >= 0 && symbol != null) {
            String letter_on_index = "(\\b\\S{" + (index - 1) +"})(\\S)(\\S*\\b)";
            Pattern pattern = Pattern.compile(letter_on_index);
            Matcher matcher = pattern.matcher(in_text);
            final_text = matcher.replaceAll(symbol);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String changeSymbolAfterAnother(String in_text, String first_symbol, String incorrect_symbol,
                                           String correct_symbol) throws InvalidDataException {
        String final_text;
        if(in_text != null && first_symbol != null && correct_symbol != null && incorrect_symbol != null) {
            final_text = in_text;
            String change_from = first_symbol + incorrect_symbol;
            String change_to = first_symbol + correct_symbol;
            final_text = final_text.replaceAll(change_from, change_to);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String changeWordByLength(String in_text, String sub_string, int length) throws InvalidDataException {
        String final_text;
        if(in_text != null && sub_string != null && length > 0) {
            String word_by_length = "\\b\\p{L}{" + length + "}\\b";
            Pattern pattern = Pattern.compile(word_by_length);
            Matcher matcher = pattern.matcher(in_text);
            final_text = matcher.replaceAll(sub_string);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }
}
