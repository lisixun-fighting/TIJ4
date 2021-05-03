package com.zjuee.annotations;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;

import java.util.*;


public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory {
    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("com.zjuee.chapter20_annotations.ExtractInterface");
    }

    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment env) {
        return new InterfaceExtractorProcessor(env);
    }
}
