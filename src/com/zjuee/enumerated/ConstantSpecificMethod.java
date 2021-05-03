package com.zjuee.enumerated;

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("ClASSPATH");
        }
    },
    VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : ConstantSpecificMethod.values()) {
            System.out.println(csm.getInfo());
        }
    }
}
