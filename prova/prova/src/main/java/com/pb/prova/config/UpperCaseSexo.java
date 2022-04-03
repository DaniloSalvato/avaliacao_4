package com.pb.prova.config;

import com.pb.prova.constants.Sexo;
import org.springframework.core.convert.converter.Converter;

public class UpperCaseSexo implements Converter<String,Sexo> {

    @Override
    public Sexo convert(String value){
        return Sexo.valueOf(value.toUpperCase());
    }
}
