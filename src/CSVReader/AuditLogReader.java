package CSVReader;

import pdu.AuditLogPduType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuditLogReader {

    public static void main(String... args) throws Exception {

        String dateiPfad = "/home/mp/Desktop/auditlogfile.csv";

        String line = "";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(dateiPfad));

        List<AuditLogEntry> logList = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {

            String[] lineItems = line.split(",");

            AuditLogEntry newEntry = new AuditLogEntry(AuditLogPduType.valueOf(lineItems[0]),
                    lineItems[1], lineItems[2], lineItems[3], Long.parseLong(lineItems[4]), lineItems[5]);

            logList.add(newEntry);

        }

        bufferedReader.close();

        System.out.println("Number of login requests: " + getNumberOfRequests(logList, AuditLogPduType.LOGIN_REQUEST));
        System.out.println("Number of unique clients: " + getNumberOfClients(logList));
        System.out.println("Average message length(including spaces and empty messages): " + getAverageMessageLength(logList));
        System.out.println("Average message length advanced(without spaces): " + getAverageMessageLengthAdvanced(logList));
        System.out.println("Total Number of messages: " + getTotalNumberOfMessages(logList));
        System.out.println("Number of messages for each user: " + getNumberOfMessagesPerClient(logList));
        System.out.println(getListOfAllTimeStamps(logList).toString());

    }

    private static long getNumberOfClients(List<AuditLogEntry> logList) {

        long numberOfClients = 0;

        numberOfClients = logList
                .stream()
                .map(AuditLogEntry::getClientThreadId)
                .distinct()
                .count();


        return numberOfClients;
    }

    private static int getTotalNumberOfMessages(List<AuditLogEntry> logList) {
        return logList.size();
    }

    private static String getNumberOfMessagesPerClient(List<AuditLogEntry> logList) {
        String output = "";

        Map<String, List<AuditLogEntry>> groupedMap = logList
                .stream()
                .collect(Collectors.groupingBy(x -> x.getUsername()));

        output = groupedMap.toString();

        /*
        groupedMap.forEach((name,people1) -> {
            System.out.println(name);
            System.out.println(people1.size());
        });

         */

        ArrayList<String> collectIt = new ArrayList<>();

        groupedMap.forEach((name, people1) -> {
            collectIt.add(name + " " + String.valueOf(people1.size()));
            //collectIt.add(String.valueOf(people1.size()));
        });

        output = collectIt.toString();

        return output;
    }


    private static long getNumberOfRequests(List<AuditLogEntry> logList, AuditLogPduType type) {
        long numberOfLoginRequests = 0;

        numberOfLoginRequests = logList.stream()
                .filter(log -> log.getType().equals(type))
                .count();


        return numberOfLoginRequests;
    }

    private static double getAverageMessageLength(List<AuditLogEntry> logList) {
        double averageMessageLength = 0;

        averageMessageLength = logList
                .stream()
                // .filter(x -> !(x.getChatMessage().equals("")))
                .map(AuditLogEntry::getChatMessage)
                .mapToDouble(x -> x.length())
                .average()
                .getAsDouble();


        return averageMessageLength;
    }

    private static double getAverageMessageLengthAdvanced(List<AuditLogEntry> logList) {
        double averageMessageLength = 0;

        averageMessageLength = logList
                .stream()
                .map(AuditLogEntry::getChatMessage)
                .map(x -> x.replace(" ", ""))
                .mapToDouble(x -> x.length())
                .average()
                .getAsDouble();


        return averageMessageLength;
    }

    private static ArrayList<Long> getListOfAllTimeStamps(List<AuditLogEntry> logList) {

        ArrayList<Long> returnArray = new ArrayList<Long>();

        logList
                .stream()
                .map(x -> x.getAuditLogTime())
                .forEach((x) -> {
                    returnArray.add(x);
                });


        return returnArray;

    }


}
