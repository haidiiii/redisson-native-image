package com.example.demo;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

/**
 *  * @author fht
 *   * @since 2024-08-06 13:14
 *    */
public class DemoRuntimeHints implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.resources().registerType(DistributeJobTask.class);
    }
}

