package com.zjuee.enumerated;

public enum Ozwitch {
    WEST("������"),
    EAST("�Ұ׻�"),
    SOUTH("ǰ��ȸ"),
    NORTH("������");
    private String description;
    public String getDescription() {
        return description;
    }
    private Ozwitch(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        for (Ozwitch o : Ozwitch.values()) {
            System.out.println(o + o.getDescription());
        }
    }
}
