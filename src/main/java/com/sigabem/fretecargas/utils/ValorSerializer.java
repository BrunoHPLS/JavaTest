package com.sigabem.fretecargas.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ValorSerializer extends JsonSerializer<BigDecimal>{

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        var df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt","BR")));
        gen.writeString("R$ "+df.format(value));
    }
    
}
