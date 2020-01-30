import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ModelTest {

    @Test
    void are_there_two_blocks_on_our_table() {
        var model = new Model();
        assertThat(model.getBlocks(), equalTo(2));
    }

    @Test
    void get_positions_for_blocks_are_zero_and_one() {
        var model = new Model();
        assertThat(model.getPosition(new Block(0)), is(0));
        assertThat(model.getPosition(new Block(1)), is(1));
    }

    @Test
    void move_block_zero_over_block_one_positions_both_blocks_at_one() {
        var model = new Model();

        var blockZero = new Block(0);
        var blockOne = new Block(1);
        model.moveOver(blockZero, blockOne);

        assertThat("Expecting block 0 to be at position 1", model.getPosition(blockZero), is(1));
        assertThat(model.getPosition(blockOne), is(1));
    }

    // in progress @Test
    void assert_blocks_which_were_on_top_are_in_its_original_position() {
        var model = new Model();

        var blockZero = new Block(0);
        var blockOne = new Block(1);
        var blockTwo = new Block(2);
        var blockThree = new Block(3);

        assertThat(model.getPosition(blockZero), is(0));
        assertThat(model.getPosition(blockOne), is(1));
        assertThat(model.getPosition(blockTwo), is(2));
        assertThat(model.getPosition(blockThree), is(3));

        model.moveOver(blockTwo, blockOne);
        assertThat(model.getPosition(blockZero), is(0));
        assertThat(model.getPosition(blockOne), is(1));
        assertThat(model.getPosition(blockTwo), is(1));
        assertThat(model.getPosition(blockThree), is(3));

        model.moveOver(blockOne, blockZero);
        assertThat(model.getPosition(blockZero), is(0));
        assertThat(model.getPosition(blockOne), is(0));
        assertThat(model.getPosition(blockTwo), is(2));
        assertThat(model.getPosition(blockThree), is(3));
    }
}
