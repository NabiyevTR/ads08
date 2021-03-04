package ru.geekbrains.ntr_ads08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int SYMBOL_COUNT = 20;
    private static final int STRING_COUNT = 20;
    private static final int SIZE = 20;


    public static void main(String[] args) {

        List<String> keys = generateRandomStrings(STRING_COUNT, SYMBOL_COUNT);
        List<String> values = generateRandomStrings(STRING_COUNT, SYMBOL_COUNT);

        HashTable<String, String> hashTable  = new HashTableImpl<>(SIZE);

        for (int i = 0; i < STRING_COUNT ; i++) {
            hashTable.put(keys.get(i) ,values.get(i));
        }
        hashTable.display();
        /*
        ----------
        0 = Item{key=tuphwxswklnvubgfpouk, value=ifqddllsdjifinkmijrq}, Item{key=zehhenrtwtwzudzdqrzz, value=nposorforiqkiaonjyav}
        1 = null
        2 = null
        3 = Item{key=saxkubatfeyypoqgvklm, value=efxjuxizkocpfphcaazw}
        4 = null
        5 = null
        6 = Item{key=qpmmcttogdevdznnilui, value=xdsvnilkrdkiupbvkwut}, Item{key=tdqhfewzsdnepzfgbdyi, value=icphbhorruioglpsmabg}
        7 = null
        8 = null
        9 = null
        10 = Item{key=newmwlnkynwkqveamxnx, value=ojvfpilntnkevresikts}, Item{key=kpmekzghdbpamwsqrgkh, value=onhhudkbhqupvyxpoisx}
        11 = null
        12 = Item{key=gylnzyaliwqrtwkygrit, value=hpqiatvzpgyswmcgdbxa}, Item{key=amsglcwizzvqorcnxrrr, value=kepiblqtylixgmehearw}, Item{key=ldnjtgdjgjpceyxmhbtb, value=vmlhqjfmgqmwcwdyarfy}
        13 = Item{key=whdgjpljpjiuwnteocwr, value=fuzzutyjhmsqcqjddjgo}
        14 = null
        15 = null
        16 = null
        17 = null
        18 = Item{key=rsreiluuzkefdyvuewmh, value=tsvzmjyvhiupbpreicxe}
        19 = null
        20 = null
        21 = null
        22 = Item{key=tqhindvrgrqlxgixksio, value=gamiamvnqtkwwzsfelof}
        23 = Item{key=itdaauflyvqyhvbfyhmt, value=zbuhmvoivbjadfxkakpf}
        24 = Item{key=rlxmmcfvajgipshmhvpr, value=fwotggljcdirjtpkttgl}
        25 = null
        26 = null
        27 = Item{key=zxyeyzczomvxzuphmgvb, value=bhzapnhefsyqxxzlwxxa}
        28 = null
        29 = null
        30 = null
        31 = Item{key=fppsbtdtdrxklvlerxsc, value=cirlacqcgogjeesanocl}, Item{key=vmmnstclvornruvpoify, value=ovprxickfjurtyjbsffj}
        32 = null
        33 = null
        34 = null
        35 = null
        36 = Item{key=hqejdsqpkazasklywaqe, value=gcroqddsaacavtmpmdxb}
        37 = null
        38 = null
        39 = Item{key=lzctiscxsrokdxihdxzy, value=xkitnkdjpomohbdgimsb}
----------
         */


        System.out.println(hashTable.get(keys.get(STRING_COUNT/3)).equals(values.get(STRING_COUNT/3)));
        /*
        true
         */
        System.out.println(hashTable.size());
        System.out.println(hashTable.remove("MyKey"));
        System.out.println(hashTable.size());
        System.out.println(hashTable.put(keys.get(0), values.get(0)));
        System.out.println(hashTable.size());
        /*
        20
        null
        20
        true
        20
         */

        for (int i = STRING_COUNT/2; i < STRING_COUNT; i++) {
            hashTable.remove(keys.get(i));
        }
        System.out.println(hashTable.size());
        hashTable.display();

        /*
        10
        ----------
        0 = Item{key=tuphwxswklnvubgfpouk, value=ifqddllsdjifinkmijrq}Item{key=zehhenrtwtwzudzdqrzz, value=nposorforiqkiaonjyav}
        1 = null
        2 = null
        3 = Item{key=saxkubatfeyypoqgvklm, value=efxjuxizkocpfphcaazw}
        4 = null
        5 = null
        6 = Item{key=qpmmcttogdevdznnilui, value=xdsvnilkrdkiupbvkwut}
        7 = null
        8 = null
        9 = null
        10 = Item{key=newmwlnkynwkqveamxnx, value=ojvfpilntnkevresikts}, Item{key=kpmekzghdbpamwsqrgkh, value=onhhudkbhqupvyxpoisx}
        11 = null
        12 = Item{key=gylnzyaliwqrtwkygrit, value=hpqiatvzpgyswmcgdbxa}
        13 = null
        14 = null
        15 = null
        16 = null
        17 = null
        18 = null
        19 = null
        20 = null
        21 = null
        22 = Item{key=tqhindvrgrqlxgixksio, value=gamiamvnqtkwwzsfelof}
        23 = null
        24 = null
        25 = null
        26 = null
        27 = Item{key=zxyeyzczomvxzuphmgvb, value=bhzapnhefsyqxxzlwxxa}
        28 = null
        29 = null
        30 = null
        31 = Item{key=fppsbtdtdrxklvlerxsc, value=cirlacqcgogjeesanocl}
        32 = null
        33 = null
        34 = null
        35 = null
        36 = null
        37 = null
        38 = null
        39 = null
        ----------
         */

        for (int i = 0; i < STRING_COUNT; i++) {
            hashTable.remove(keys.get(i));
        }
        System.out.println(hashTable.size());
        hashTable.display();

        /*
        0
        ----------
        0 = null
        1 = null
        2 = null
        3 = null
        4 = null
        5 = null
        6 = null
        7 = null
        8 = null
        9 = null
        10 = null
        11 = null
        12 = null
        13 = null
        14 = null
        15 = null
        16 = null
        17 = null
        18 = null
        19 = null
        20 = null
        21 = null
        22 = null
        23 = null
        24 = null
        25 = null
        26 = null
        27 = null
        28 = null
        29 = null
        30 = null
        31 = null
        32 = null
        33 = null
        34 = null
        35 = null
        36 = null
        37 = null
        38 = null
        39 = null
        ----------
         */

        System.out.println(hashTable.isEmpty());
        /*
        true
         */

    }

    private static List<String> generateRandomStrings(int stringCount, int symbolsCount) {

        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < stringCount; i++) {
            stringList.add(generateRandomString(symbolsCount));
        }
        return stringList;
    }

    private static String generateRandomString(int symbolsCount) {
        char[] symbols = new char[symbolsCount];
        for (int i = 0; i < symbolsCount; i++) {
            symbols[i] = (char) getRandomValueInRange(97, 122);
        }
        return new String(symbols);
    }

    private static int getRandomValueInRange(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }
}
