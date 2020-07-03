package com.dubovik.strings.service.impl;

import com.dubovik.strings.exception.InvalidDataException;
import com.dubovik.strings.service.SymbolChange;

import java.util.ArrayList;

public class CharSymbolChangeImpl implements SymbolChange {

    public String changeSymbolByIndex(String in_text, int index, String symbol) throws InvalidDataException {
        String final_text;
        if(in_text != null && index >= 0 && symbol != null) {
            String text = " " + in_text + " ";
            char[] all_chars = text.toCharArray();
            int begin_word = 0;
            int end_word = 0;
            char replacement = symbol.toCharArray()[0];
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
                    if(end_word - begin_word >= index){
                        all_chars[begin_word + index] = replacement;
                    }
                    i = end_word;
                }
            }
            char[] final_chars = new char[all_chars.length - 2];
            int j = 0;
            for(int i = 1; i < all_chars.length - 1; i++){
                final_chars[j] = all_chars[i];
                j++;
            }
            final_text = String.valueOf(final_chars);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String changeSymbolAfterAnother(String in_text, String in_first_symbol, String in_incorrect_symbol,
                                           String in_correct_symbol) throws InvalidDataException {
        String final_text;
        if(in_text != null && in_first_symbol != null && in_correct_symbol != null && in_incorrect_symbol != null) {
            char[] all_chars = in_text.toCharArray();
            char first_symbol = in_first_symbol.charAt(0);
            char correct_symbol = in_correct_symbol.charAt(0);
            char incorrect_symbol = in_incorrect_symbol.charAt(0);
            for(int i = 0; i < all_chars.length - 1; i++){
                if(all_chars[i] == first_symbol && all_chars[i + 1] == incorrect_symbol){
                    all_chars[i + 1] = correct_symbol;
                }
            }
            final_text = String.valueOf(all_chars);
        }else{
            throw new InvalidDataException("Invalid data");
        }
        return final_text;
    }

    public String changeWordByLength(String in_text, String sub_string, int length) throws InvalidDataException {
        String final_text = "";
        if(in_text != null && sub_string != null && length > 0) {
            String text = " " + in_text + " ";
            char[] all_chars = text.toCharArray();
            int begin_word = 0;
            int end_word = 0;
            ArrayList<char[]> words_array = new ArrayList<>();
            char[] replacement = sub_string.toCharArray();
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
                    if(end_word - begin_word == length - 1){
                        int length_of_word_with_separator = replacement.length + 1;
                        char[] buffer = new char[length_of_word_with_separator];
                        int index = 0;
                        for(int k = 0; k < replacement.length; k++){
                            buffer[index] = replacement[k];
                            index++;
                        }
                        if(end_word + 1 < all_chars.length){
                            buffer[replacement.length] = all_chars[end_word + 1];
                        }
                        words_array.add(buffer);
                    }else{
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
}
