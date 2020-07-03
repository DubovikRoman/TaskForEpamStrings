package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolChange;

public class StringSymbolChangeImpl implements SymbolChange {

    public String changeSymbolByIndex(String in_text, int index, String symbol) throws InvalidDataException {
        String final_text;
        if(in_text != null && index >= 0 && symbol != null) {
            String custom_separators = " ";
            StringBuilder text = new StringBuilder(in_text);
            String[] words = in_text.split(custom_separators);
            for(String element : words) {
                String current_word = element;
                if (index < current_word.length()) {
                    int index_of_word = text.toString().indexOf(current_word);
                    text.setCharAt(index_of_word + index, symbol.charAt(0));
                }
            }
            final_text = text.toString();
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String changeSymbolAfterAnother(String in_text,
                                           String first_symbol,
                                           String incorrect_symbol,
                                           String correct_symbol) throws InvalidDataException  {
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
            String custom_separators = " ";
            StringBuilder text = new StringBuilder(in_text);
            String[] words = in_text.split(custom_separators);
            for(String element : words) {
                String current_word = element;
                if (length == current_word.length()) {
                    int begin_index_word = text.toString().indexOf(current_word);
                    int end_index_word = begin_index_word + length;
                    text.replace(begin_index_word, end_index_word, sub_string);
                }
            }
            final_text = text.toString();
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }
}
