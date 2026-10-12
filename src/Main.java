import java.util.*;

public class Main {
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

        hm.put('\'', "w1");
        hm.put(';', "");
        hm.put('.', "");
        hm.put('/', "");
        hm.put('\\', "");

        Reader in = new Reader();
        StringBuilder sb = new StringBuilder();

        boolean flat = false;
        boolean flag = true;

        while (true){
            String s = in.nextString();

            if (s.equals("endLine")) break;

            boolean fastFlag = false;
            int bpm = 0;

            for (char c : s.toCharArray()){
                if (fastFlag){
                    if (c == ']'){
                        int standard = (int)((double)45 / bpm * 1000);
                        String four = "w" + standard;
                        String eight = "w" + (standard / 2);
                        String sixteen = "w" + (standard / 4);
                        String _6 = "w" + (standard / 6);
                        hm.put('.', four);
                        hm.put(';', eight);
                        hm.put('/', sixteen);
                        hm.put('\\', _6);
                        fastFlag = false;
                        continue;
                    } else {
                        bpm *= 10;
                        bpm += c - '0';
                        continue;
                    }
                }

                if (c == '['){
                    fastFlag = true;
                    bpm = 0;
                    continue;
                }

                char c2 = Character.toUpperCase(c);
                if (hm.containsKey(c2)){
                    if (flag) {
                        char ch = c;

                        if (c == 'U') ch = 'L';
                        else if (c == 'J') ch = '0';
                        else if (c == 'M') ch = '5';
                        else if (c == 'E') ch = 'O';
                        else if (c == 'D') ch = '7';
                        else if (c == 'C') ch = '2';
                        else if (c == 'Y') ch = 'K';
                        else if (c == 'H') ch = '9';
                        else if (c == 'N') ch = '4';
                        else ch = Character.toUpperCase(c);
//                        if (flat){
//                            if (c == 'U') ch = 'L';
//                            else if (c == 'J') ch = '0';
//                            else if (c == 'M') ch = '5';
//                            else ch = Character.toUpperCase(c);
//                        } else {
//                            if (c == 'R') ch = 'P';
//                            else if (c == 'F') ch = '8';
//                            else if (c == 'V') ch = '3';
//                            else if (c == 'Q') ch = 'I';
//                            else if (c == 'A') ch = '6';
//                            else if (c == 'Z') ch = '1';
//                            else if (c == 'T') ch = 'K';
//                            else if (c == 'G') ch = '9';
//                            else if (c == 'B') ch = '4';
//                            else if (c == 'W') ch = 'O';
//                            else if (c == 'S') ch = '7';
//                            else if (c == 'X') ch = '2';
//                            else if (c == 'Y') ch = 'L';
//                            else if (c == 'H') ch = '0';
//                            else if (c == 'N') ch = '5';
//                            else ch = Character.toUpperCase(c);
//                        }
                        // 파도솔레라
                        sb.append(hm.get(ch)).append('\n');
                    } else {
                        sb.append(hm.get(c)).append('\n');
                    }
                }
            }
        }

        System.out.print(sb);
    }
}

class Reader {
    final int SIZE = 1 << 13;
    byte[] buffer = new byte[SIZE];
    int index, size;

    String nextString() throws Exception {
        StringBuilder sb = new StringBuilder();
        byte c;
        while ((c = read()) < 32) { if (size < 0) return "endLine"; }
        do sb.appendCodePoint(c);
        while ((c = read()) >= 32); // SPACE 분리라면 >로, 줄당 분리라면 >=로
        return sb.toString();
    }

    char nextChar() throws Exception {
        byte c;
        while ((c = read()) < 32); // SPACE 분리라면 <=로, SPACE 무시라면 <로
        return (char)c;
    }

    int nextInt() throws Exception {
        int n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) { if (size < 0) return -1; }
        if (c == 45) { c = read(); isMinus = true; }
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    long nextLong() throws Exception {
        long n = 0;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32);
        if (c == 45) { c = read(); isMinus = true; }
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return isMinus ? ~n + 1 : n;
    }

    double nextDouble() throws Exception {
        double n = 0, div = 1;
        byte c;
        boolean isMinus = false;
        while ((c = read()) <= 32) { if (size < 0) return -12345; }
        if (c == 45) { c = read(); isMinus = true; }
        else if (c == 46) { c = read(); }
        do n = (n * 10) + (c & 15);
        while (isNumber(c = read()));
        if (c == 46) { while (isNumber(c = read())){ n += (c - 48) / (div *= 10); }}
        return isMinus ? -n : n;
    }

    boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    boolean isAlphabet(byte c){
        return (64 < c && c < 91) || (96 < c && c < 123);
    }

    byte read() throws Exception {
        if (index == size) {
            size = System.in.read(buffer, index = 0, SIZE);
            if (size < 0) buffer[0] = -1;
        }
        return buffer[index++];
    }
}