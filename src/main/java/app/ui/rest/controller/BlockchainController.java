package app.ui.rest.controller;
import app.application.domain.model.block.*;

import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import app.application.domain.model.block.Transaction;
import app.application.domain.model.block.TransactionOutput;
import app.application.domain.model.block.Wallet;
import app.ui.rest.util.BlockEnv;
public class BlockchainController {
//
    public static int difficulty = BlockEnv.difficulty;
    public static Wallet walletA;
    public static Wallet walletB;

    public BlockchainController(){
        System.out.println("Creating and Mining Genesis block... ");
        System.out.println("INICICIANDO");
//        BlockEnv.genesis.addTransaction(BlockEnv.genesisTransaction);
//        BlockEnv.addBlock(BlockEnv.genesis);
    }

    public static void main(String[] args) {
        //add our blocks to the blockchain ArrayList:
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider()); //Setup Bouncey castle as a Security Provider

        //Create wallets:
        walletA = new Wallet();
        walletB = new Wallet();

        //create genesis transaction, which sends 100 NoobCoin to walletA:
        BlockEnv.initTransaction(walletA);

        BlockEnv.initBlock();

        //testing

        sendFunds(walletA, walletB, 20);
        getBalanceWallet(walletA);
        sendFunds(walletA, walletB, 20);
        getBalanceWallet(walletA);

        BlockEnv.isChainValid();
    }


    public static void getBalanceWallet(Wallet wallet){

        System.out.println("\nWallet's balance is: " + wallet.getBalance());

    }

    public static void sendFunds(Wallet walletA, Wallet walletB, float value){
        Block block = new Block(BlockEnv.blockchain.get(BlockEnv.blockchain.size() -1).hash);
        System.out.println("\nWalletA is Attempting to send funds " +  value + " to WalletB...");
        block.addTransaction(walletA.sendFunds(walletB.publicKey, value));
        BlockEnv.addBlock(block);
    }

}
