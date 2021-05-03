package com.zjuee.enumerated;

public enum Ozwitch {
    WEST("×óÇàÁú"),
    EAST("ÓÒ°×»¢"),
    SOUTH("Ç°ÖìÈ¸"),
    NORTH("ºóĞşÎä");
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
