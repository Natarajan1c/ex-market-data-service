/*
 * Copyright (c) 2019, Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
 * SPDX-License-Identifier: Apache-2.0
 */
package jsonapi;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import org.junit.Ignore;
import org.junit.Test;

public class JsonLedgerClientTest {

  @Ignore
  @Test
  public void getActiveContracts() throws InterruptedException, ExecutionException {
    var ledger = new JsonLedgerClient();
    var result = ledger.getActiveContracts().get();
    assertThat(result.statusCode(), is(200));
    assertThat(result.body(), not(containsString("\"result\":[]")));
  }

  @Ignore
  @Test
  public void webSocket() throws InterruptedException {
    var ledger = new JsonLedgerClient();
    var latch = new CountDownLatch(1);
    ledger.getActiveContractsViaWebSockets(latch);
    latch.await();
  }
}
