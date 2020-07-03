package com.dubovik.strings.service;

import com.dubovik.strings.exception.InvalidDataException;

public interface SymbolChange {

     String changeSymbolByIndex(String text, int index, String symbol) throws InvalidDataException;
     String changeSymbolAfterAnother(String text,
                                     String first_symbol,
                                     String incorrect_symbol, String correct_symbol) throws InvalidDataException;
     String changeWordByLength(String in_text, String sub_string, int length) throws InvalidDataException;
}
