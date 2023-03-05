package main.Java;

import javax.xml.crypto.Data;

public class Blockchain {

    private Block chain;
    boolean isGenesis;

    public Blockchain(Block genesisBlock) {

        if (isGenesis) {
            this.chain = genesisBlock;
        }
    }

    private void addBlock(Data data) {
        Block lastBlock = chain; //(chain.getLength() - 1);
        Block newBlock = new Block(lastBlock.getHash(), lastBlock.getData());
        newBlock.mine(2); // find a hash for new block
        newBlock = chain;
    }

    private boolean isValid() {
        for (int i = 1; i < this.chain.getLength(); i++) {
            Block currentBlock;
            currentBlock = this.chain(i);  // Needs deeper understanding.
            Block previousBlock;
            previousBlock = this.chain(i - 1);  // Needs deeper understanding.
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) return false;
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) return false;
        }
        return true;
    }
}