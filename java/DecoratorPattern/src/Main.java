public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, world.");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);
        b1.show();
        b2.show();
        b3.show();
        Display b4 = 
                    new SideBorder(
                        new FullBorder(
                            new FullBorder(
                                new SideBorder(
                                    new FullBorder(
                                        new StringDisplay("こんにちは。")
                                    ),
                                    '*'
                                )
                            )
                        ),
                        '/'
                    );
        b4.show();
        
        Display b5 = new UpDownBorder(b1, '-');
        b5.show();
        
        MultiStringDisplay b6 = new MultiStringDisplay();
        b6.add("test");
        b6.add("hogehoge");
        b6.add("Hello, world");
        b6.show();
        Display b7 = new FullBorder(b6);
        b7.show();
    }
}
