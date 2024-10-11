import java.util.Scanner;
import java.util.Random;

public class MessagingApp{
      private static final String SENDER_NUMBER = "03125632187"; 
      private Message[][] messages;
      private int[] messageCount;
      private int totalReceivers = 20;
      private static int globalMessageId = 1;
      private String[] contacts;
            
  public MessagingApp() {
      messages = new Message[totalReceivers][100];
      messageCount = new int[totalReceivers];
   }

 public String[] addContacts(){
         String contacts[] = new String[20];
        for(int i=0;i<contacts.length;i++){
           contacts[i] = "0300" + (5430000+i);
   }
      return contacts;
  }


 public void addMessage(String[] contacts, String messageContent, boolean status, int receiverIndex) {
        if (receiverIndex >= contacts.length || receiverIndex < 0) {
            System.out.println("Invalid receiver index");
            return;
       }
           String receiverNumber = contacts[receiverIndex];
          if(messageCount[receiverIndex] < messages[receiverIndex].length){
            String messageID = String.valueOf(globalMessageId++);
            Message newMessage = new Message(SENDER_NUMBER, receiverNumber, messageContent, messageID, status);
            messages[receiverIndex][messageCount[receiverIndex]++] = newMessage;
        } else {
            System.out.println("Message array is full");
        }
    }

 public void sendMessages(String[] contacts) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message content : ");
        String messageContent = sc.nextLine();
        System.out.println("Enter the receiver index (0 to " +(totalReceivers - 1) + "):");
        int receiverIndex = sc.nextInt();
        sc.nextLine();
        if(receiverIndex < 0 || receiverIndex >= totalReceivers){
          System.out.println("Invalid receiver index. Please provide a valid index.");
          return;
   }
       if(contacts != null && receiverIndex < contacts.length){
       addMessage(contacts, messageContent, false, receiverIndex);
       System.out.println("Message sent to receiver " + (receiverIndex + 1) + ": " + messageContent); 
          } else {
            System.out.println("Contact array is null or invalid index.");
       }
    }

 public void displayAllMessages(){
    System.out.println("Displaying all messages : ");
   
   for(int i=0;i<totalReceivers;i++){
           System.out.println("Message for receiver" +(i+1)+ " :");
       
           for(int j=0;j<messageCount[i];j++){
             System.out.println(messages[i][j].toString());
             System.out.println("-----------------------");
     }
   }
 }
    public void displayMessageBetweenSenderAndReceiver(String receiverNumber){ 
        boolean found = false;
     System.out.println("Message between" +SENDER_NUMBER+ " and " +receiverNumber+ ":");
    
    for(int i=0;i<totalReceivers;i++){
      for(int j=0;j<messageCount[i];j++){
    if (messages[i][j].getReceiverNumber().equals(receiverNumber) && messages[i][j].getSenderNumber().equals(SENDER_NUMBER)) {
                System.out.println(messages[i][j].getMessageContent());
                found = true;
            }   
      }
}
    if (!found){
       System.out.println("No messages found between these numbers");
   }
}

public void searchMessage(){
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter message id to search message : ");
     String messageID = sc.nextLine();
     boolean found = false;

  for(int i=0;i<totalReceivers;i++){
      for(int j=0;j<messageCount[i];j++){
      if(messages[i][j].getMesageID().equals(messageID)){
         System.out.println("Message found : \n" + messages[i][j].toString());
         found = true;
           break;
    }
  }
    if(found) break;
}
   if (!found){
      System.out.println("Message not found");
  }
 }

 public void deleteMessage(){
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter message id to delete message : ");
      String messageID = sc.nextLine();
      boolean found = false;

   for(int i=0;i<totalReceivers;i++){
      for(int j=0;j<messageCount[i];j++){
       if(messages[i][j].getMesageID().equals(messageID)){
            found = true;

    for(int k=j;k<messageCount[i]-1;k++){
       messages[i][k] = messages[i][k+1];
  }
      messages[i][--messageCount[i]] = null;
      System.out.println("Message deleted successfully.");
      break;
   }
 }
   if(found) break;
}
      if(!found) {
            System.out.println("Message not found.");
    }
  }

 public void displayUnseenMessages(){
       System.out.println("Unseen messages : ");
       boolean hasUnseen = false;
          for(int i=0;i<totalReceivers;i++){
       for(int j=0;j<messageCount[i];j++){
       if(!messages[i][j].getStatus()) {
           System.out.println(messages[i][j].toString());
           System.out.println("-----------------------");
            messages[i][j].setStatus(true);
            hasUnseen = true;
            }
          }
  }
     if(!hasUnseen) {
        System.out.println("No unseen messages");
    }
 }

 public void displaySeenMessages(){
      System.out.println("Seen messages : ");
      boolean hasSeen = false;

    for(int i=0;i<totalReceivers;i++){
         for(int j=0;j<messageCount[i];j++){
      if(messages[i][j].getStatus()){
            System.out.println(messages[i][j].toString());
            System.out.println("-----------------------");
            hasSeen = true;
          }
       }
   }
     if(!hasSeen) {
        System.out.println("No seen messages");
    }
  }

 public void shuffleMessages(){
    int totalMessages = 0;
   for(int i=0;i<totalReceivers;i++){
   totalMessages += messageCount[i];
  }
    Message[] allMessages = new Message[totalMessages];
      int index = 0;
   for(int i=0;i<totalReceivers;i++){
     for(int j=0;j<messageCount[i];j++){
       allMessages[index++] = messages[i][j];
   }
  }
    Random rand = new Random();
   for(int i=0;i<totalMessages;i++){
     int randomIndex = rand.nextInt(totalMessages);
     Message temp = allMessages[i];
     allMessages[i] = allMessages[randomIndex];
     allMessages[randomIndex] = temp;
  }
    System.out.println("Messages in random order : ");
    for (Message message : allMessages){
       System.out.println(message.toString());
       System.out.println("-----------------------");
  }
 }
}
