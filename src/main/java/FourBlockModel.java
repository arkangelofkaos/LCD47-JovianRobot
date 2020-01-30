public class FourBlockModel {


    public static final Block[][] four_block_model_initial_positions = new Block[][]{
            {new Block(0)}, // position 0
            {new Block(1)}, // position 1
            {new Block(2)}, // position 2
            {new Block(3)}, // position 3
            {}
    };

    public static final Block[][] four_block_model_before_start = new Block[][]{
            {new Block(0)}, // position 0
            {new Block(1), new Block(2)}, // position 1
            {},                         // position 0
            {new Block(3)}                                                      // position 0
    };


    public static final Block[][] four_block_model_after_move_one_over_zero = new Block[][]{
            {new Block(0), new Block(1)}, // position 0
            {},                       // position 1
            {new Block(2)},                     // position 2
            {new Block(3)}                                                      // position 3
    };

}
