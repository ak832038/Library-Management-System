package org.gfg.Library_Management_Minor.controller;

import org.gfg.Library_Management_Minor.dto.TxnRequest;
import org.gfg.Library_Management_Minor.exception.TxnException;
import org.gfg.Library_Management_Minor.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/txn")
public class TxnController {

    @Autowired
    private TxnService txnService;

    @PostMapping("/create")
    public String createTxn(@RequestBody TxnRequest txnRequest) throws TxnException {
        return txnService.create(txnRequest);
    }

    @PutMapping("/return")
    public int returnBook(@RequestBody TxnRequest txnRequest) throws TxnException {
        return txnService.returnBook(txnRequest);
    }
}
