/**
 * Copyright (c) 2016-2022 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.transaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.mockito.Mockito;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.TestUtilities;
import com.zsmartsystems.zigbee.ZigBeeStatus;

/**
 *
 * @author Chris Jackson
 *
 */
public class ZigBeeTransactionFutureTest {
    private static int TIMEOUT = 5000;

    @Test
    public void testIsDone() throws InterruptedException, ExecutionException, TimeoutException {
        ZigBeeTransactionFuture future = new ZigBeeTransactionFuture(Mockito.mock(ZigBeeTransaction.class));
        assertFalse(future.isDone());

        CommandResult result = new CommandResult(ZigBeeStatus.FAILURE, null);
        future.set(result);
        assertTrue(future.isDone());

        assertEquals(result, future.get());
        assertEquals(result, future.get(0, TimeUnit.MICROSECONDS));
    }

    @Test
    public void testDefaultTimeout() throws Exception {
        ZigBeeTransactionFuture future = new ZigBeeTransactionFuture(
                Mockito.mock(ZigBeeTransaction.class));
        assertFalse(future.isDone());

        TestUtilities.setField(ZigBeeTransactionFuture.class, future, "TIMEOUT_MINUTES", (long) 0);

        CommandResult result = future.get();
        assertNull(result.getResponse());
    }

    @Test
    public void testTimeout() throws InterruptedException, ExecutionException, TimeoutException {
        ZigBeeTransactionFuture future = new ZigBeeTransactionFuture(Mockito.mock(ZigBeeTransaction.class));
        assertFalse(future.isDone());

        assertNotNull(future.get(0, TimeUnit.MICROSECONDS));
        assertTrue(future.isDone());

        CommandResult result = future.get();
        assertNull(result.getResponse());

        assertFalse(future.cancel(true));
    }

    @Test
    public void testCancel() {
        ZigBeeTransaction transaction = Mockito.mock(ZigBeeTransaction.class);
        ZigBeeTransactionFuture future = new ZigBeeTransactionFuture(transaction);
        assertFalse(future.isCancelled());
        assertTrue(future.cancel(true));
        Mockito.verify(transaction, Mockito.timeout(TIMEOUT).times(1)).cancel();
        assertFalse(future.cancel(true));
        Mockito.verify(transaction, Mockito.timeout(TIMEOUT).times(1)).cancel();
        assertTrue(future.isCancelled());
    }

    @Test
    public void testMultipleThreadIsDone() throws InterruptedException, ExecutionException, TimeoutException {
        // Tests that multiple threads waiting on the same future will be notified when it completes
        ZigBeeTransactionFuture future = new ZigBeeTransactionFuture(
                Mockito.mock(ZigBeeTransaction.class));
        assertFalse(future.isDone());

        CountDownLatch startLatch = new CountDownLatch(2);
        CountDownLatch finishLatch = new CountDownLatch(2);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                startLatch.countDown();
                try {
                    future.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                finishLatch.countDown();
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                startLatch.countDown();
                try {
                    future.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                finishLatch.countDown();
            }
        };

        thread1.start();
        thread2.start();
        assertTrue(startLatch.await(TIMEOUT, TimeUnit.MILLISECONDS));

        CommandResult result = new CommandResult(ZigBeeStatus.FAILURE, null);
        future.set(result);
        assertTrue(future.isDone());

        assertEquals(result, future.get());
        assertEquals(result, future.get(0, TimeUnit.MICROSECONDS));

        assertTrue(finishLatch.await(TIMEOUT, TimeUnit.MILLISECONDS));
    }

}
