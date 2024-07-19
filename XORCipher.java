import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class XORCipher {

    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        Scanner scanner = new Scanner(System.in);

        try {
            // Buka berkas plain.txt untuk dibaca
            reader = new BufferedReader(new FileReader("C:\\Users\\LENOVO\\Documents\\plain.txt"));

            // Buat berkas chiper.txt untuk ditulis
            writer = new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\Documents\\chiper.txt"));

            // Minta pengguna untuk memasukkan kunci
            System.out.print("Kata Kunci: ");
            String key = scanner.nextLine();
            int keyLength = key.length();
            int i = 0;
            int character;

            // Baca teks dari berkas plain.txt, enkripsi, dan tulis ke berkas chiper.txt
            while ((character = reader.read()) != -1) {
                char P = (char) character;
                char C = (char) (P ^ key.charAt(i)); // Operasi XOR
                writer.write(C);
                i++;
                if (i >= keyLength) {
                    i = 0;
                }
            }

            System.out.println("Enkripsi selesai.");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
                scanner.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
