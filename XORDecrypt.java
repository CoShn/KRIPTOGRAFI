import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class XORDecrypt {

    // Metode untuk mendekripsi berkas dengan algoritma XOR
    public static void xorDecrypt(String inputFile, String outputFile, String key) {
        try (FileInputStream fin = new FileInputStream(inputFile);
             FileOutputStream fout = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int keyLength = key.length();
            int keyIndex = 0;

            int bytesRead;
            while ((bytesRead = fin.read(buffer)) != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    buffer[i] ^= key.charAt(keyIndex); // operasi XOR
                    keyIndex = (keyIndex + 1) % keyLength;
                }
                fout.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metode utama untuk menjalankan aplikasi
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kata Kunci: ");
        String key = scanner.nextLine();
        scanner.close();

        // Panggil metode xorDecrypt dengan parameter yang sesuai
        xorDecrypt("C:/Users/LENOVO/Documents/cipher.txt", "C:/Users/LENOVO/Documents/plain2.txt", key);
    }
}
