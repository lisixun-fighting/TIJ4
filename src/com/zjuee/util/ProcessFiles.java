package com.zjuee.util;

import java.io.*;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }
    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args, String regex) {
        try {
            if(args.length == 0)
                processDirectoryTree(new File("."), regex);
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if(fileArg.isDirectory())
                        processDirectoryTree(fileArg, regex);
                    else
                        if(!arg.endsWith(ext))
                            arg += "." + ext;
                        strategy.process(
                                new File(arg).getCanonicalFile()
                        );
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processDirectoryTree(File root, String regex) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex)) {
            strategy.process(file.getCanonicalFile());
        }
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java").start(args, ".*\\.java");
    }
}
