
    /**
 * Write a description of class Coin here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 public enum Coin
       {
        P10 (10),
        P20 (20),
        P100 (100),
        P200 (200);

        private final int value;

        private Coin(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
     }
