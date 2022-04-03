package com.pb.prova.config;


import com.pb.prova.constants.Ideologia;
import org.springframework.core.convert.converter.Converter;

public class UpperCaseIdeologia implements Converter<String, Ideologia> {

    @Override
    public Ideologia convert(String value){
        return Ideologia.valueOf(value.toUpperCase());
    }
}
