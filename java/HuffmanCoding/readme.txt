1. 出現している文字を列挙する
2. 出現回数をカウントする
3. 出現回数の少ないものから結合して二分木を生成する
4. 二分木に沿って、文字を符号化する
5. 先頭のdictを生成する
6. 与えられた文字列を符号化していく

gradle build && java -cp build/classes/main Main -c test.txt test.compressed
hogehoge
e=10,g=01,h=00,o=11;0011011000110110

gradle build && java -cp build/classes/main Main -d test.compressed test.decompressed
e=10,g=01,h=00,o=11;0011011000110110
hogehoge

/Users/atsushi/github/ProgramContest/java/HuffmanCoding% gradle run -Pargs="-c test.txt test.compress" && gradle run -Pargs="-d test.compress test.decompress"
hogehogeeeeehhhhhoooooooooooooggggggggggggggggggggggggggggggggggggggggggggggegggggggggeggggeggggggggegggggggggoggggg
e=011,g=1,h=010,o=00;0100010110100010110110110110110100100100100100000000000000000000000000011111111111111111111111111111111111111111111110111111111110111111011111111110111111111110011111
e=011,g=1,h=010,o=00;0100010110100010110110110110110100100100100100000000000000000000000000011111111111111111111111111111111111111111111110111111111110111111011111111110111111111110011111
hogehogeeeeehhhhhoooooooooooooggggggggggggggggggggggggggggggggggggggggggggggegggggggggeggggeggggggggegggggggggoggggg