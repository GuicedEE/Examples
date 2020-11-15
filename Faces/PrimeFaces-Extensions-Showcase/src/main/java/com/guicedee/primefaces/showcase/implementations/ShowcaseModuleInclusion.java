package com.guicedee.primefaces.showcase.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ShowcaseModuleInclusion implements IGuiceScanModuleInclusions<ShowcaseModuleInclusion> {
    @Override
    public @NotNull Set<String> includeModules() {
        Set<String> moduleScanningAllowed = new HashSet<>();
        moduleScanningAllowed.add("com.guicedee.examples.faces.primefaces.extensions.showcase");
        return moduleScanningAllowed;
    }
}
