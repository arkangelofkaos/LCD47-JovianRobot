import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Model {

    public final Block[][] stacks;

    public Model() {
        this(2);
    }

    public Model(int numberOfBlocks) {
        this.stacks = new Block[numberOfBlocks][1];
        for (int i = 0; i < numberOfBlocks; i++) {
            stacks[i][0] = new Block(i);
        }
    }

    public int getBlocks() {
        return 2;
    }

    public Integer getPosition(Block blockToLookFor) {
        for (Integer position = 0; position < stacks.length; position++) {
            Block[] stack = stacks[position];
            // if this stack contains our block, return position
            for (Block blockInStack : stack) {
                if (blockInStack.equals(blockToLookFor)) {
                    return position;
                }
            }
        }
        // handle unfound
        return -1;
    }

    public void moveOver(Block blockA, Block blockB) {
        pickUp(blockA);
        putBack(blockA, blockB);
    }

    private void pickUp(Block block) {
        int currentPosition = getPosition(block);
        final Block[] currentStack = stacks[currentPosition];
        stacks[currentPosition] = withBlockRemoved(block, currentStack);
    }

    private void putBack(Block blockA, Block blockB) {
        int targetPosition = getPosition(blockB);
        final Block[] targetStack = stacks[targetPosition];
        stacks[targetPosition] = withBlockAdded(blockA, targetStack);
    }

    private Block[] withBlockRemoved(Block block, Block[] targetStack) {
        return operateBlock(block, targetStack, (stack, targetBlock) -> stack.remove(targetBlock));
    }

    private Block[] withBlockAdded(Block block, Block[] targetStack) {
        return operateBlock(block, targetStack, (stack, targetBlock) -> stack.add(targetBlock));
    }

    private Block[] operateBlock(Block block, Block[] stack, BiConsumer<List<Block>, Block> operate) {
        List<Block> stackAsList = new ArrayList<>(Arrays.asList(stack));
        operate.accept(stackAsList, block);
        return stackAsList.toArray(new Block[]{});
    }
}
