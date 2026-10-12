import java.util.HashMap;

public class Main2 {
    public static void main(String[] args) throws Exception {
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('Q', "hC-1");
        hm.put('W', "hD-1");
        hm.put('E', "hE-1");
        hm.put('R', "hF-1");
        hm.put('T', "hG-1");
        hm.put('Y', "hA-1");
        hm.put('U', "hB-1");

        hm.put('I', "hC#-1");
        hm.put('O', "hEb-1");
        hm.put('P', "hF#-1");
        hm.put('K', "hG#-1");
        hm.put('L', "hBb-1");

        hm.put('A', "hC");
        hm.put('S', "hD");
        hm.put('D', "hE");
        hm.put('F', "hF");
        hm.put('G', "hG");
        hm.put('H', "hA");
        hm.put('J', "hB");

        hm.put('6', "hC#");
        hm.put('7', "hEb");
        hm.put('8', "hF#");
        hm.put('9', "hG#");
        hm.put('0', "hBb");

        hm.put('Z', "hC+1");
        hm.put('X', "hD+1");
        hm.put('C', "hE+1");
        hm.put('V', "hF+1");
        hm.put('B', "hG+1");
        hm.put('N', "hA+1");
        hm.put('M', "hB+1");

        hm.put('1', "hC#+1");
        hm.put('2', "hEb+1");
        hm.put('3', "hF#+1");
        hm.put('4', "hG#+1");
        hm.put('5', "hBb+1");

        hm.put(',', "hC+2");

        int min = 17;

        String minWait = "w" + min;

        hm.put('\'', minWait);
        hm.put(';', "");
        hm.put('.', "");
        hm.put('/', "");
        hm.put('?', "");
        hm.put(':', "");
        hm.put('>', "");
        hm.put('<', "");
        hm.put('\\', "");

        HashMap<Character, Character> hm2 = new HashMap<>();

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        while (true){
            String s = in.nextString();

            if (s.equals("endLine")) break;

            boolean fastFlag = false;
            boolean sharpFlatFlag = false;
            int bpm = 0;

            int release = 0;

            String tmpString = "";

            for (char c : s.toCharArray()){
                if (fastFlag){
                    if (c == ']'){
                        double standard = (double)60 / bpm * 1000;
                        String four = "w" + (int)standard;
                        String eight = "w" + (int)(standard / 2);
                        String sixteen = "w" + (int)(standard / 4);
                        String thirtyTwo = "w" + (int)(standard / 8);
                        String sixtyFour = "w"  + (int)(standard / 16);
                        String _128 = "w" + (int)(standard / 32);
                        String _256 = "w" + (int)(standard / 64);
                        String _6 = "w" + (int)(standard / 6);
                        String _5 = "w" + (int)(standard / 5);
                        String _3 = "w" + (int)(standard / 3);
                        hm.put('.', four);
                        hm.put(';', eight);
                        hm.put('/', sixteen);
                        hm.put('?', thirtyTwo);
                        hm.put(':', sixtyFour);
                        hm.put('>', _128);
                        hm.put('<', _256);
                        hm.put('\\', _6);
                        hm.put('|', _5);
                        hm.put('=', _3);
                        fastFlag = false;
                        continue;
                    } else {
                        bpm *= 10;
                        bpm += c - '0';
                        continue;
                    }
                }

                if (sharpFlatFlag){
                    if (c == '}'){
                        sharpFlatFlag = false;
                        continue;
                    } else {
                        if (c == 'Q') hm2.put('Q', 'I');
                        if (c == 'W') hm2.put('W', 'O');
                        if (c == 'E') hm2.put('E', 'R');
                        if (c == 'R') hm2.put('R', 'P');
                        if (c == 'T') hm2.put('T', 'K');
                        if (c == 'Y') hm2.put('Y', 'L');
                        if (c == 'U') hm2.put('U', 'A');
                        if (c == 'A') hm2.put('A', '6');
                        if (c == 'S') hm2.put('S', '7');
                        if (c == 'D') hm2.put('D', 'F');
                        if (c == 'F') hm2.put('F', '8');
                        if (c == 'G') hm2.put('G', '9');
                        if (c == 'H') hm2.put('H', '0');
                        if (c == 'J') hm2.put('J', 'Z');
                        if (c == 'Z') hm2.put('Z', '1');
                        if (c == 'X') hm2.put('X', '2');
                        if (c == 'C') hm2.put('C', 'V');
                        if (c == 'V') hm2.put('V', '3');
                        if (c == 'B') hm2.put('B', '4');
                        if (c == 'N') hm2.put('N', '5');
                        if (c == 'M') hm2.put('M', ',');

                        if (c == 'w') hm2.put('W', 'I');
                        if (c == 'e') hm2.put('E', 'O');
                        if (c == 'r') hm2.put('R', 'E');
                        if (c == 't') hm2.put('T', 'P');
                        if (c == 'y') hm2.put('Y', 'K');
                        if (c == 'u') hm2.put('U', 'L');
                        if (c == 'a') hm2.put('A', 'U');
                        if (c == 's') hm2.put('S', '6');
                        if (c == 'd') hm2.put('D', '7');
                        if (c == 'f') hm2.put('F', 'D');
                        if (c == 'g') hm2.put('G', '8');
                        if (c == 'h') hm2.put('H', '9');
                        if (c == 'j') hm2.put('J', '0');
                        if (c == 'z') hm2.put('Z', 'J');
                        if (c == 'x') hm2.put('X', '1');
                        if (c == 'c') hm2.put('C', '2');
                        if (c == 'v') hm2.put('V', 'C');
                        if (c == 'b') hm2.put('B', '3');
                        if (c == 'n') hm2.put('N', '4');
                        if (c == 'm') hm2.put('M', '5');
                        if (c == ',') hm2.put(',', 'M');

                        continue;
                    }
                }

                if (c == '['){
                    fastFlag = true;
                    bpm = 0;
                    continue;
                }

                if (c == '{'){
                    sharpFlatFlag = true;
                    hm2 =  new HashMap<>();
                    continue;
                }

                char c2 = Character.toUpperCase(c);
                if (hm.containsKey(c2)){
                    char ch = c;

                    if (hm2.containsKey(ch)){
                        ch = hm2.get(ch);
                    } else ch = Character.toUpperCase(ch);

                    if (ch == '\''){
                        release += min;

                        //sb.delete(sb.length() - tmpString.length(), sb.length());
                    } else {
                        String tmp = hm.get(ch);

                        if (tmp.charAt(0) == 'w'){
                            int num = Integer.parseInt(tmp.substring(1));
                            num -= release;
                            release = 0;
                            sb.append("w" + num).append('\n');
                            //tmpString = "w" + num;

                            continue;
                        }
                    }

                    sb.append(hm.get(ch)).append('\n');
                    //tmpString = hm.get(ch);
                }
            }
        }

        System.out.print(sb);
    }
}

