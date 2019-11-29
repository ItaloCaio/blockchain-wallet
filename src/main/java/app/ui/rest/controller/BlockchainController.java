package app.ui.rest.controller;
import app.application.domain.model.block.*;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import app.application.domain.model.block.Transaction;
import app.application.domain.model.block.TransactionOutput;
import app.application.domain.model.block.Wallet;
import app.ui.rest.util.BlockEnv;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("block")
public class BlockchainController {
//
    public static int difficulty = BlockEnv.difficulty;
    public Wallet walletA;
    public static Wallet walletB;

    public BlockchainController(){
        System.out.println("Creating and Mining Genesis block... ");
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); //Setup Bouncey castle as a Security Provider
        walletA = new Wallet();
        walletB = new Wallet();
        BlockEnv.initTransaction(walletA);
        BlockEnv.initBlock();
    }

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); //Setup Bouncey castle as a Security Provider

        //Create wallets:

        walletB = new Wallet();
//        walletA = new Wallet();
        //create genesis transaction, which sends 100 NoobCoin to walletA:
//        BlockEnv.initTransaction(walletA);
//        BlockEnv.initBlock();

        //testing

//        sendFunds(walletA, walletB, 20);
//        getBalanceWallet(walletA);
//        sendFunds(walletA, walletB, 20);
//        getBalanceWallet(walletA);

        BlockEnv.isChainValid();
    }


    public static float getBalanceWallet(Wallet wallet){

        System.out.println("\nWallet's balance is: " + wallet.getBalance());
        return wallet.getBalance();
    }
    @GetMapping(path = "/walletB")
    public static float getBalanceWalletB(){

        System.out.println("\nWallet's balance is: " + walletB.getBalance());
        return walletB.getBalance();
    }
    @GetMapping(path = "/walletA")
    public float getBalanceWalletA(){

        System.out.println("\nWallet's balance is: " + walletA.getBalance());
        return walletA.getBalance();
    }

    @PostMapping
    public void sendFunds(@RequestBody float value){
        Block block = new Block(BlockEnv.blockchain.get(BlockEnv.blockchain.size() -1).hash);
        System.out.println("\nWalletA is Attempting to send funds " +  value + " to WalletB...");
        block.addTransaction(walletA.sendFunds(walletB.publicKey, value));
        BlockEnv.addBlock(block);
    }

    public static void sendFunds(Wallet walletA, Wallet walletB, float value){
        Block block = new Block(BlockEnv.blockchain.get(BlockEnv.blockchain.size() -1).hash);
        System.out.println("\nWalletA is Attempting to send funds " +  value + " to WalletB...");
        block.addTransaction(walletA.sendFunds(walletB.publicKey, value));
        BlockEnv.addBlock(block);
    }



}