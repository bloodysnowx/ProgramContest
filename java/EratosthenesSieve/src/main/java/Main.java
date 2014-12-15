import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: Atsushi
 * Date: 2013/10/09
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args)
    {
        calcEratosthenesSieve(977);
        countEratosthenesSieve(2);
        countEratosthenesSieve(5);
        countEratosthenesSieve(10);
        countEratosthenesSieve(19);
        countEratosthenesSieve(54);
        countEratosthenesSieve(224);
        countEratosthenesSieve(312);
        countEratosthenesSieve(616);
        countEratosthenesSieve(888);
        countEratosthenesSieve(977);

        int number = 10000000;
        calcEratosthenesSieve(number);
        // printEratosthenesSieve(number);
        countEratosthenesSieve(number);

        long start = 22;
        long end = 37;
        calcEratosthenesSieveInRange(start, end);
        printEratosthenesSieveInRange(start, end);
        countEratosthenesSieveInRange(start, end);

        start = 22801763489L;
        end = 22801787297L;
        calcEratosthenesSieveInRange(start, end);
        // printEratosthenesSieveInRange(start, end);
        countEratosthenesSieveInRange(start, end);
    }

    static BitSet bitSet = new BitSet(32);

    public static void calcEratosthenesSieve(int number)
    {
        bitSet.clear();
        bitSet.set(1);

        for(int i = 2; i <= number; ++i) {
            if(bitSet.get(i) == false) {
                for(int j = i * 2; j <= number; j += i)
                    bitSet.set(j);
            }
        }
    }

    static void printBitSet(BitSet bitSet, long start, long end, int i)
    {
        for(; i < end - start; ++ i)
        {
            if(bitSet.get(i) == false)
                System.out.println(i + start);
        }
    }

    static void countBitSet(BitSet bitSet, int max, int i)
    {
        int count = 0;
        for(; i < max; ++i)
        {
            if(bitSet.get(i) == false) ++count;
        }
        System.out.println("total = " + count);
    }

    static void printEratosthenesSieve(int number)
    {
        printBitSet(bitSet, 0, number + 1, 2);
    }

    static void countEratosthenesSieve(int number)
    {
        countBitSet(bitSet, number + 1, 2);
    }

    static BitSet bitSetForRange = new BitSet(32);

    static void calcEratosthenesSieveInRange(long start, long end)
    {
        int max = (int)Math.sqrt(end);
        calcEratosthenesSieve(max);

        bitSetForRange.clear();

        for(int i = 2; i <= max; ++i)
        {
            if(bitSet.get(i) == false)
            {
                for(long j = start; j <= end; ++j)
                {
                    if(j % i == 0)
                    {
                        for(long k = j; k <= end; k += i)
                        {
                            bitSetForRange.set((int)(k - start));
                        }

                        break;
                    }
                }
            }
        }
    }

    static void printEratosthenesSieveInRange(long start, long end)
    {
        printBitSet(bitSetForRange, start, end, 0);
    }

    static void countEratosthenesSieveInRange(long start, long end)
    {
        countBitSet(bitSetForRange, (int)(end - start), 0);
    }
}
