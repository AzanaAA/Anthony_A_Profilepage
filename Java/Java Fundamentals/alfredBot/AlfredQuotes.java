import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String flirt) {
        // YOUR CODE HERE
        return String.format("Hello, %s. %s", name,flirt);
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "Date is" + date;
    }

    public String yellAtAlexis(){
        return "BATMAN HATES YOU ALEXIS!";
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if(conversation.indexOf("Alexis")> -1){
            return "She's really of no help. What can I get for you?";
        }
        if (conversation.indexOf("Alfred") > -1){
            return "At your service.";
        }
        return "Right. And with that I shall retire";
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}

