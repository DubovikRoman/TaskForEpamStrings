package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolRemove;

import java.util.ArrayList;

public class CharSymbolRemoveImpl implements SymbolRemove {

    public String deleteAllNonLetterSymbols(String in_text) throws InvalidDataException {
        String final_text;
        if(in_text != null) {
            char[] all_chars = in_text.toCharArray();
            for(int i = 0; i < all_chars.length - 1; i++){
                if(!Character.isLetterOrDigit(all_chars[i]) && !Character.isSpaceChar(all_chars[i])){
                    all_chars[i] = ' ';
                }
            }
            final_text = String.valueOf(all_chars);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String deleteByLengthStartsWithСonsonants(String in_text, int length) throws InvalidDataException {
        String final_text = "";
        if(in_text != null && length > 0) {
            String text = " " + in_text + " ";
            char[] all_chars = text.toCharArray();
            int begin_word = 0;
            int end_word = 0;
            ArrayList<char[]> words_array = new ArrayList<>();
            for(int i = 0; i < all_chars.length - 1; i++){
                if((all_chars[i] == ' ' || all_chars[i] == ',' || all_chars[i] == '.') &&
                        (all_chars[i + 1] != ' ' || all_chars[i + 1] != ',' || all_chars[i + 1] != '.')){
                    begin_word = i + 1;
                    for(int j = begin_word; j < all_chars.length; j++){
                        if(all_chars[j] == ' ' || all_chars[j] == ',' || all_chars[j] == '.'){
                            end_word = j - 1;
                            break;
                        }
                    }
                    if(!isWordCorrect(begin_word, end_word, all_chars, length)){
                        int length_of_word_with_separator = end_word - begin_word + 2;
                        char[] buffer = new char[length_of_word_with_separator];
                        int index = 0;
                        for(int k = begin_word; k < end_word + 1; k++){
                            buffer[index] = all_chars[k];
                            index++;
                        }
                        if(end_word + 1 < all_chars.length){
                            buffer[index] = all_chars[end_word + 1];
                        }
                        words_array.add(buffer);
                    }

                    i = end_word;
                }
            }
            for(char[] word : words_array){
                final_text += String.valueOf(word);
            }
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public boolean isWordCorrect(int begin_word, int end_word, char[] all_chars, int length){
        boolean is_correct = true;
        String vowel_letters = "eyuioaEYUIOAуеыаоэяиюУЕЫАОЭЯИЮ";
        if(end_word - begin_word != length - 1){
            is_correct = false;
        }else if(vowel_letters.indexOf(all_chars[begin_word]) != -1){
            is_correct = false;
        }
        return is_correct;
    }
}
