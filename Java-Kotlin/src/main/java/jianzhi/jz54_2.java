package jianzhi;

/**
 * 看到出现1次，第一想法肯定是使用基于Hash表的方法，如果不用库函数的话，那么就得使用数组，而使用一个数组的时候，就和Hash表一样，索引需要有独特的含义。
 * 其实也就是需要自己实现一个和Hash类似功能的数组。当然可以有其他的一些变种的写法，但大致思想相同。
 *
 * 解法1：
 *   只使用一个数组，数组中不仅可以判断是否出现了多次，并且在出现一次时，数组中存放字符在字符流中出现第一次的位置，而数组索引和字符的ASCII码对应起来，由于ASCII码有128个字符，因此数组大小为128即可。
 *   将数组初值赋值-1，某个字符第一次出现时，将-1更新成当前字符在字符流中的索引（位置）。第二次出现时，将之前赋值的索引擦除，并且不用进入后续的判断，这里选择赋值成-2（赋值情况不唯一）。也就是说，没出现过，数组记录-1，出现一次，数组记录位置，出现多次，数组记录成-2.
 *   而在FirstAppearingOnce方法中，我们要遍历数组找到正确的解，所以我们要做两件事，第1是找到所有出现1次的字符，由于要求我们返回第一次出现一次的字符，所以第2件事就是比较各个出现1次的字符在字符流中的位置，我们要找到最先出现的那个字符即位置最小的字符。因此还需要设置一个变量，
 * 该变量记录某个字符的位置，在找到下一个出现一次的字符时，比较这两个只出现1次的字符的位置，看谁更靠前，就要谁。（可以把这一过程理解成，在某个数组中找到最小的那个数，这个数就是第一个出现1次的字符的索引）
 *   最妙的是，这个方法只利用一个数组，就完成了记录某个字符是否出现了一次，以及出现一次时的在字符流的位置。
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 8
 * 9
 * 10
 * 11
 * 12
 * 13
 * 14
 * 15
 * 16
 * 17
 * 18
 * 19
 * 20
 * 21
 * 22
 * 23
 * 24
 * 25
 * 26
 * 27
 * 28
 * 29
 * public class Solution {
 *     private int index = 0;//index用于记录某个字符出现的位置
 *     private int[] arr = new int[128];
 *     public Solution(){  //构造函数初始化数组为-1，
 *         for(int i=0;i<128;i++)
 *             arr[i]=-1;
 *     }
 *
 *     public void Insert(char ch) {
 *         if(arr[ch]==-1) {//arr[ch]和arr[(int)ch]是一样的
 *             arr[ch]=index;   //第一次出现时，记录其在字符流中的位置
 *         }else if(arr[ch]>=0) {//大于0，说明某个字符出现过了
 *             arr[ch]=-2;     //多次出现时，重置
 *         }
 *         index++;
 *     }
 *
 *     public char FirstAppearingOnce() {
 *         int minIndex = Integer.MAX_VALUE;  //方便比较出最靠前的那个出现1次的字符
 *         char ch='#';
 *         for(int i=0;i<128;i++) {
 *             if(arr[i]>=0 && arr[i] < minIndex) {//字符赋值给ch，位置赋值给minIndex
 *                 ch = (char) i;
 *                 minIndex = arr[i];
 *             }
 *         }
 *         return ch;
 *     }
 * }
 * 解法2：
 *   之前是一个数组又可以记录索引信息，又可以记录是否出现了多次，用两个数组，将表达的信息分解，所以代码看起来没有解法1那么绕。并且还和解法1不同的是，
 * index记录的不再是第一次出现的位置，而是记录某个字符最后出现的位置，但其实没什么影响，因为我们也用count记录次数，出现1次的字符，记录的位置仍然正确（只出现1次的位置既是第一次出现也是最后一次出现）
 */
public class jz54_2 {


    private int[] freq = new int[128];

    private int[] index = new int[128];

    private int seq = 0;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        freq[ch]++;
        index[ch] = seq++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 128; i++) {
            if (freq[i] == 1) {
                if (index[i] < minIndex) {
                    result = (char) i;
                    minIndex = index[i];
                }
            }
        }
        return result;
    }
}
