package com.practice.cassandra.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransferServiceTest {

    @Autowired
    TransferService transferService;

    @Test
    void transfer() {
        transferService.transfer();

    }
}