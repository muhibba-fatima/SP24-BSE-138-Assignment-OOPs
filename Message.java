import java.time.LocalDateTime;

public class Message {
    private String senderNumber;
    private String receiverNumber;
    private String messageContent;
    private String mesageID;
    private Boolean status;
    LocalDateTime timestamp;

    public Message(String senderNumber, String receiverNumber, String messageContent, String mesageID, Boolean status) {
        this.senderNumber = senderNumber;
        this.receiverNumber = receiverNumber;
        this.messageContent = messageContent;
        this.mesageID = mesageID;
        this.status = status;
        timestamp = LocalDateTime.now();
    }
    public void setSenderNumber(){
       if(senderNumber.length() == 11){
        this.senderNumber = senderNumber;
 } else{
       System.out.println("Sender number must be of 11 digits");
 }
   }
  public void setReceiverNumber(){
       if(receiverNumber.length() == 11){
        this.receiverNumber = receiverNumber;
 } else{
       System.out.println("Receiver number must be of 11 digits");
 }
   }

    public String getSenderNumber() {
        return senderNumber;
    }

       public String getReceiverNumber() {
        return receiverNumber;
    }

       public String getMessageContent() {
        return messageContent;
    }

   

    public String getMesageID() {
        return mesageID;
    }

   public void setStatus(boolean status){
        this.status = status;
   }

    public Boolean getStatus() {
        return status;
    }

      public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override 
 public String toString(){
     return String.format("From : %s\nTo : %s\nMessage : %s\nID : %s\nStatus : %s\nReceived at : %s", senderNumber, receiverNumber, messageContent, mesageID, status ? "Seen" : "Unseen", timestamp);  
 }
}