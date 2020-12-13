/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.company.processing.factory;

import com.company.processing.service.Processor;

public class ProcessingFactory {
    private ProcessingFactory() {}

    public static ProcessingFactory build() { return new ProcessingFactory(); }

    public Processor getProcessor() { return new Processor(); }
}
