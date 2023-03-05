package main.Java;

import javax.xml.crypto.Data;
import java.util.Date;

import static java.util.Objects.hash;

public class Block<previousHash, data, difficulty> {

    private int length;

    private Date timeStamp;
    private int proofOfWork;
    private Data data;
    private String hash;
    private String previousHash;
    private int difficulty;

    public Block(String previousHash, Data data) {
        this.hash = this.calculateHash();
        this.timeStamp = new Date();
        this.proofOfWork = 0;
    }

    public Block(int length) {
        this.previousHash = previousHash;
        this.data = data;
        this.hash = this.calculateHash();
        this.timeStamp = new Date();
        this.proofOfWork = 0;
    }

    protected String calculateHash() {
        return this.previousHash +
                this.data +
                this.timeStamp +
                this.proofOfWork;
    }

    protected void mine(int difficulty) {
        while (!this.hash.startsWith("0".repeat(difficulty))) {
            this.proofOfWork++;
            this.hash = this.calculateHash();
        }
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        length = calculateHash().length();
        return length;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public Data getData() {
        return data;
    }
}
