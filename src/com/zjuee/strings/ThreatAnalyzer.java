package com.zjuee.strings;

import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {
    static String threatData =
            "58.27.82.131@02/10/2021\n" +
            "58.27.82.131@02/10/2021\n" +
            "58.27.82.131@02/10/2021\n" +
            "58.27.82.131@02/10/2021\n" +
            "58.27.82.131@02/10/2021\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@(\\d+/\\d+/\\d+)";
        Formatter formatter = new Formatter(System.out);
        while (scanner.hasNext(pattern)) {
            scanner.next(pattern);
            MatchResult match = scanner.match();
            formatter.format("Threat on %s, Threat from %s\n", match.group(2), match.group(1));
        }
    }
}
