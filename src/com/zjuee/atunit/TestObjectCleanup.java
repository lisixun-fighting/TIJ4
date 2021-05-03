//: net/mindview/com.zjuee.atunit/TestObjectCleanup.java
// The @Unit @TestObjectCleanup tag.
package com.zjuee.atunit;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCleanup {} ///:~
