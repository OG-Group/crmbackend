package com.argroupcrm.crm.generic.crud.model.specification.enums;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

/**
 * @author ogbozoyan
 * @date 01.03.2023
 */

@Slf4j
/**
 *  Define enum of field type which is can be used to parse into data type.
 */
public enum FieldType {

    BOOLEAN {
        public Object parse(String value) {
            return Boolean.valueOf(value);
        }
    },

    CHAR {
        public Object parse(String value) {
            return value.charAt(0);
        }
    },

    DATE {
        public Object parse(String value) {
            Object date = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                Date parsedDate = (Date) formatter.parse(value);
                date = new Timestamp(parsedDate.getTime());
            } catch (Exception e) {
                log.info("Failed parse field type DATE {}", e.getMessage());
            }

            return date;
        }
    },

    DOUBLE {
        public Object parse(String value) {
            return Double.valueOf(value);
        }
    },

    INTEGER {
        public Object parse(String value) {
            return Integer.valueOf(value);
        }
    },

    LONG {
        public Object parse(String value) {
            return Long.valueOf(value);
        }
    },

    STRING {
        public Object parse(String value) {
            return value;
        }
    },
    OBJECT {
        @Override
        public Object parse(String value) {
            return value;
        }
    };

    public abstract Object parse(String value);

}