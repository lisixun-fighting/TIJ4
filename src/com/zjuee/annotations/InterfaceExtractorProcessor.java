package com.zjuee.annotations;
// {Exec: apt -factory
// com.zjuee.chapter20_annotations.InterfaceExtractorProcessorFactory
// Multiplier.java -s ../com.zjuee.chapter20_annotations}
import java.util.*;
import java.io.*;

import com.sun.mirror.apt.*;
import com.sun.mirror.declaration.*;

public class InterfaceExtractorProcessor implements AnnotationProcessor {
    private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<>();
    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment env) { this.env = env; }
    public void process() {
        for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
            ExtractInterface anno = typeDecl.getAnnotation(ExtractInterface.class);
            if(anno == null)
                break;
            for (MethodDeclaration m : typeDecl.getMethods())
                if(m.getModifiers().contains(Modifier.PUBLIC) &&
                        !(m.getModifiers().contains(Modifier.STATIC)))
                    interfaceMethods.add(m);
            if(interfaceMethods.size() > 0) {
                try {
                    PrintWriter writer = env.getFiler().createSourceFile("anno.value()");
                    writer.println("package " + typeDecl.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + anno.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print("   public   ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration param : m.getParameters()) {
                            writer.print(param.getType() + " " + param.getSimpleName());
                            if(++i < m.getParameters().size())
                                writer.print(", ");
                        }
                        writer.print(");");
                        writer.close();
                    }
                    writer.print("}");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
