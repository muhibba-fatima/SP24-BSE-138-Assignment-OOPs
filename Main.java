import java.util.Scanner;

public class Main{

    public static void main(String args[]){
         MessagingApp app = new MessagingApp();
         String[] contacts = app.addContacts();
         
 
         app.addMessage(contacts, "Hello", true, 0);
         app.addMessage(contacts, "How are you?", false, 1);
         app.addMessage(contacts, "I am fine", true, 2);
         app.addMessage(contacts, "Good morning", true, 3);
         app.addMessage(contacts, "Good night", false, 4);
         app.addMessage(contacts, "Good afternoon", true, 5);
         app.addMessage(contacts, "Where are you?", false, 6);
         app.addMessage(contacts, "I am from Lahore", true, 7);
         app.addMessage(contacts, "I went to Islamabad", true, 8);
         app.addMessage(contacts, "I am tired", false, 9);
         app.addMessage(contacts, "I need some rest", false, 10);
         app.addMessage(contacts, "I am not feeling well", true, 11);
         app.addMessage(contacts, "I love cakes", false, 12);
         app.addMessage(contacts, "I like apples", true, 13);
         app.addMessage(contacts, "What about you?", true, 14);
         app.addMessage(contacts, "I am sick", false, 15);
         app.addMessage(contacts, "Where is john?", true, 16);
         app.addMessage(contacts, "Why is it so hot today?", false, 17);
         app.addMessage(contacts, "What is temperature right now?", true, 18);
         app.addMessage(contacts, "Hi guys!", true, 19);

         Scanner sc = new Scanner(System.in);        
        
       while (true){
         System.out.println("Enter 1 to display all messages, 2 to send message to a particular receiver, 3 to search a message, 4 to delete a message, 5 to display seen messages, 6 to display unseen messages, 7 to shuffle messages, 8 to display message between sender and any receiver number, 9 to exit : ");

         int choice = sc.nextInt();
         sc.nextLine();
         
        switch (choice){
        
         case 1:
         app.displayAllMessages();
         break;
         case 2:
         app.sendMessages(contacts);
         break;
         case 3:
         app.searchMessage();
         break;
         case 4:
         app.deleteMessage();
         break;
         case 5:
         app.displaySeenMessages();
         break;
         case 6:
         app.displayUnseenMessages();
         break;
         case 7:
         app.shuffleMessages();
         break;
         case 8:
         System.out.println("Enter receiver number : ");
         String receiverNumber = sc.nextLine();
         app.displayMessageBetweenSenderAndReceiver(receiverNumber);
         break;
         case 9:
         System.out.println("Exiting...");
         sc.close();
         return;
         default:
         System.out.println("Invalid choice. Please try again");
        } 
         System.out.println();
     }
       
  }
}