package CSVReader;

import pdu.AuditLogPduType;

public class AuditLogEntry {

    private AuditLogPduType type;
    private String clientThreadId;
    private String serverWorkerThreadId;
    private String username;
    private long auditLogTime;
    private String chatMessage;

    public AuditLogEntry(AuditLogPduType type, String clientThreadId, String serverWorkerThreadId, String username, long auditLogTime, String chatMessage) {
        this.type = type;
        this.clientThreadId = clientThreadId;
        this.serverWorkerThreadId = serverWorkerThreadId;
        this.username = username;
        this.auditLogTime = auditLogTime;
        this.chatMessage = chatMessage;
    }

    public AuditLogPduType getType() {
        return type;
    }

    public void setType(AuditLogPduType type) {
        this.type = type;
    }

    public String getClientThreadId() {
        return clientThreadId;
    }

    public void setClientThreadId(String clientThreadId) {
        this.clientThreadId = clientThreadId;
    }

    public String getServerWorkerThreadId() {
        return serverWorkerThreadId;
    }

    public void setServerWorkerThreadId(String serverWorkerThreadId) {
        this.serverWorkerThreadId = serverWorkerThreadId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getAuditLogTime() {
        return auditLogTime;
    }

    public void setAuditLogTime(long auditLogTime) {
        this.auditLogTime = auditLogTime;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }
}
