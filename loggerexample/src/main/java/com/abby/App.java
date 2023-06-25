package com.abby;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static final Logger log = LoggerFactory.getLogger("controlador_de_app");

    public static void main(String[] args) {
        internetCheck(false);
    }

    public static void internetCheck(boolean internet) {
        log.trace("checking internet...");
        if (internet) {
            log.info("El sistema esta conectado a internet");
        } else {
            log.warn("El sistema no esta conectado a internet");
        }
    }
}
