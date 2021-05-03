package com.zjuee.interfaces.string;

import com.zjuee.interfaces.interfaceprocessor.Apply;
import com.zjuee.interfaces.interfaceprocessor.Processor;

public class StringAdapter implements Processor {
    private StringProcessor processor;

    public StringAdapter(StringProcessor processor) {
        this.processor = processor;
    }


    @Override
    public String name() {
        return processor.name();
    }

    @Override
    public Object process(Object input) {
        return processor.process(new Reverse(), (String)input);
    }

    public static void main(String[] args) {
        Apply.process(new StringAdapter(new StringProcessor()), "hello world.");
    }
}
