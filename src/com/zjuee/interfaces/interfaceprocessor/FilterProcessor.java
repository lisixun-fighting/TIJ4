package com.zjuee.interfaces.interfaceprocessor;

import com.zjuee.interfaces.filter.Filter;
import com.zjuee.interfaces.filter.HighPass;
import com.zjuee.interfaces.filter.LowPass;
import com.zjuee.interfaces.filter.Waveform;

class FilterAdapter implements Processor {
    private Filter filter;
    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }
    public String name() {
        return filter.name();
    }
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1)), w);
        Apply.process(new FilterAdapter(new HighPass(0)), w);
    }
}
