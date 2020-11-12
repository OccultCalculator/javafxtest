package pdu;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Date;


/**
 * <p/>
 * Nachrichtenaufbau fuer das AuditLog-Protokoll
 *
 * @author Mandl
 */
public class AuditLogPDU implements Serializable {

    private static final long serialVersionUID = -6172619032079227589L;
  //  private static Logger log = LogManager.getLogger(AuditLogPDU.class);

    // Kommandos bzw. PDU-Typen
    private AuditLogPduType pduType;

    // Login-Name des Clients
    private String userName;

    // Name des Chat-Client-Threads, der den Request absendet
    private String clientThreadName;

    // Name des Worker-Threads, der den Request im Chat-Server verarbeitet
    private String serverThreadName;

    // Zeitstempel zum Zeitpunkt des Audit-Logs im Chat-Server
    private long auditTime;

    // Nutzdaten (eigentliche Chat-Nachricht in Textform)
    private String message;

    public AuditLogPDU() {

        this.pduType = AuditLogPduType.UNDEFINED;
        this.clientThreadName = null;
        this.serverThreadName = null;
        this.userName = null;
        this.auditTime = 0;
    }

    public static void printPdu(AuditLogPDU pdu) {
        // System.out.println(pdu);
      //  log.debug(pdu);
    }

    public static AuditLogPDU convertChatPDUtoAuditLogPDU(ChatPDU chatPDUtoConvert) {
        AuditLogPDU resultAuditLogPDU = new AuditLogPDU();
        resultAuditLogPDU.pduType = convertChatPDUTypeToAuditLogPDUType(chatPDUtoConvert.getPduType());
        resultAuditLogPDU.userName = chatPDUtoConvert.getUserName();
        resultAuditLogPDU.clientThreadName = chatPDUtoConvert.getClientThreadName();
        resultAuditLogPDU.serverThreadName = chatPDUtoConvert.getServerThreadName();
        resultAuditLogPDU.auditTime = chatPDUtoConvert.getServerTime();
        resultAuditLogPDU.message = chatPDUtoConvert.getMessage();
        return resultAuditLogPDU;
    }

    private static AuditLogPduType convertChatPDUTypeToAuditLogPDUType(PduType pduType) {
        for (AuditLogPduType auditLogPDUTypeItem : AuditLogPduType.values()) {
            if (auditLogPDUTypeItem.getDescription().equals(pduType.getDescription())) {
                return auditLogPDUTypeItem;
            } else {
                return null;
            }
        }
        return null;
    }

    public String toString() {

        Date dateAndTime = new Date(this.auditTime);

        return "\n"
                + "AuditLogPdu ****************************************************************************************************"
                + "\n" + "AuditLogType: " + pduType + "\n" + "userName: " + this.userName + ", "
                + "\n" + "clientThreadName: " + this.clientThreadName + "\n"
                + "serverThreadName: " + this.serverThreadName + "\n" + "auditTime: "
                + dateAndTime.toString() + "\n" + "message: " + this.message + "\n"
                + "**************************************************************************************************** SimplePdu"
                + "\n";
    }

    public AuditLogPduType getPduType() {
        return pduType;
    }

    public void setPduType(AuditLogPduType pduType) {
        this.pduType = pduType;
    }

    public String getUserName() {
        return (this.userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientThreadName() {
        return (this.clientThreadName);
    }

    public void setClientThreadName(String threadName) {
        this.clientThreadName = threadName;
    }

    public String getServerThreadName() {
        return (this.serverThreadName);
    }

    public void setServerThreadName(String threadName) {
        this.serverThreadName = threadName;
    }

    public long getAuditTime() {
        return (auditTime);
    }

    public void setAuditTime(long auditTime) {
        this.auditTime = auditTime;
    }

    public String getMessage() {
        return (message);
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}