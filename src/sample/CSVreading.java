package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class CSVreading {

    public static void main(String... args) throws Exception {
        //Lege Dateipfad der CSV-Datei fest
        String dateiPfad = "C:/Users/Maximilian/Desktop/FL_insurance_sample.csv";
        String line = "";
        //Erstelle eine ArrayList mit String-Arrays als Typ
        List<String[]> rowList = new ArrayList<String[]>();

        //Erstelle einen Buffered Reader und übergib ihm einen FileReader und übergib diesem den Dateipfad
        BufferedReader br = new BufferedReader(new FileReader(dateiPfad));

        //Trage jede Zeile als einen String in die ArrayList ein. Teile dazu die Zeilen bei Kommas
        /*while ((line = br.readLine()) != null) {
            String[] lineItems = line.split(",");
            rowList.add(lineItems);

        }*/

        // Andere testveriante bei der Eine ArrayList vom Typ insuranceLogEntry erstellt wird.
        // Diese Log-Objekte enthalten unterschiedliche Felder mit unterschiedlichen Datentypen für die Werte jeder Zeile;
        // Also existiert für jeden EIntrag ein Objekt mit den entsprechenden Werten als Felder

        List<insuranceLogEntry> logList = new ArrayList<>();

        while ((line = br.readLine()) != null){
            String[] lineItems = line.split(",");
           insuranceLogEntry newEntry = new insuranceLogEntry(Integer.parseInt(lineItems[0]),lineItems[1],lineItems[2],lineItems[3]);
           logList.add(newEntry);
        }
        br.close();

        long numberCasesWithPolicyId119736 = logList.stream()
                .filter(log -> log.getPolicyID() == 119736)
                .count();

        System.out.print(numberCasesWithPolicyId119736);


       //Eigentlich nicht nötig: Erstelle ein einfaches 2D-Array aus der rowList
       /* String[][] matrix = new String[rowList.size()][];
        for (int i = 0; i < rowList.size(); i++) {
            String[] row = rowList.get(i);
            matrix[i] = row;
        }*/


       //System.out.println(rowList.get(0)[0]);

        //printMatrix(matrix);
    }

    // Eigentlich nicht nötig. Gib die Matrix auf der Konsole aus
    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }
    }

    private static int CountNumberOfDistinctCounties() {
        int NumberOfDistinctCounties = 0;

        return NumberOfDistinctCounties;
    }

}
