package com.dubovik.strings.service;

import com.dubovik.strings.exception.InvalidDataException;

public interface SymbolRemove {

    String deleteAllNonLetterSymbols(String text) throws InvalidDataException;
    String deleteByLengthStartsWithСonsonants(String text, int length) throws InvalidDataException;
}
