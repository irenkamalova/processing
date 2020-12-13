/*
 * Copyrights: Asset Control International B.V.
 * All Rights Reserved.
 *
 */
package com.company.processing;

import com.company.processing.exceptions.FatalException;
import com.company.processing.exceptions.NonFatalException;
import com.company.processing.factory.ProcessingFactory;
import com.company.processing.service.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    private static Logger logger = LoggerFactory.getLogger("Main logger");

    public static void main(String[] args) {
        ProcessingFactory processingFactory = ProcessingFactory.build();

        Processor processor = processingFactory.getProcessor();

        try {
            processor.start();
        } catch (FatalException e) {
            logger.error("Fatal exception during stream processing", e);
            processor.stop();
        } catch (Exception e) {
            logger.warn("Exception during stream processing", e);
        } finally {
            logger.info("Service is finished");
        }
    }
}
