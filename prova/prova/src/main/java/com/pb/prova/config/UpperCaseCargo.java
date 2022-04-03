package com.pb.prova.config;

import com.pb.prova.constants.Cargo;
import org.springframework.core.convert.converter.Converter;

public class UpperCaseCargo  implements Converter<String, Cargo> {

    @Override
    public Cargo convert(String value){
        return Cargo.valueOf(value.toUpperCase());
    }

}
