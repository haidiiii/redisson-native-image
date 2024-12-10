package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author fht
 * @since 2024-08-06 12:47
 */
@Slf4j
public class DistributeJobTask implements Serializable, Runnable {
    @Serial
    private static final long serialVersionUID = -4208893675224972920L;

    @Override
    public void run() {
        log.info("123");
    }
}
