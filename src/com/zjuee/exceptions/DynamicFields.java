package com.zjuee.exceptions;

class DynamicFieldsException extends Exception {}

public class DynamicFields {
    private Object[][] fields;
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] {null, null};
        }
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Object[] obj : fields) {
            res.append(obj[0]);
            res.append(": ");
            res.append(obj[1]);
            res.append("\n");
        }
        return res.toString();
    }
    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if(id.equals(fields[i][0]))
                return i;
        }
        return -1;
    }
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if(fieldNum == -1)
            throw new NoSuchFieldException();
        return fieldNum;
    }
    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if(fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length*2+1][2];
        for (int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[] {null, null};
        }
        fields = tmp;
        return makeField(id);
    }
    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }
    public Object setField(String id, Object val) throws DynamicFieldsException {
        if(val == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            // NPE是原始异常，传递给了新异常DFE
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if(fieldNumber == -1)
            fieldNumber = makeField(id);
        Object res = null;
        try {
            res = getField(id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        fields[fieldNumber][1] = val;
        return res;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println(df);
            df.setField("d", null);
        } catch (DynamicFieldsException e) {
            e.printStackTrace();
        }
    }
}
