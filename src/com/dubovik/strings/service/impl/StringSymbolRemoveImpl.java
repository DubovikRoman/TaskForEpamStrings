package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolRemove;

public class StringSymbolRemoveImpl implements SymbolRemove {

    public String deleteAllNonLetterSymbols(String in_text) throws InvalidDataException{
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
            String custom_separators = " ";
            StringBuilder text = new StringBuilder(in_text);
            String[] words = in_text.split(custom_separators);
            for(String element : words) {
                String current_word = element;
                if (length == current_word.length()
                        && vowel_letters.indexOf(current_word.charAt(0)) == -1) {
                    int begin_index_word = text.toString().indexOf(current_word);
                    int end_index_word = begin_index_word + length;
                    text.delete(begin_index_word, end_index_word);
                }
            }
            final_text = text.toString();
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }
}
