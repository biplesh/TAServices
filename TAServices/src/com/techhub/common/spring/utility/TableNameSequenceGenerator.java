package com.techhub.common.spring.utility;

import java.util.Properties;

import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.type.Type;

public class TableNameSequenceGenerator extends SequenceGenerator {

    public static final String GLOBAL_SEQUENCE_NAME = "hibernate_sequence";

    public void configure(Type type, Properties params, Dialect dialect) throws MappingException {
        if(params.getProperty(SEQUENCE) == null || params.getProperty(SEQUENCE).length() == 0) {
            String seqName = GLOBAL_SEQUENCE_NAME;
            params.setProperty(SEQUENCE, seqName);               
        }
        //super.configure(type, params, dialect);
    }

}
