import javax.swing.JOptionPane;

public class ChoosingOption {

    public static void main(String[] args) {
        // int option = JOptionPane.showConfirmDialog(null, "Do you want to change to first class ticket?");
        //JOptionPane.showMessageDialog(null,"You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        //System.exit(0);
    
        Object[] options= {"Yes", "No"};
        JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?: ", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        System.exit(0);
    }
}


//Questions: 

//What happens if users choose “Cancel”? 
//==> It will appear the box: "You've chosen: No"

//How to customize the options to users, e.g. only two options: “Yes” and “No”, OR “I do” and “I don’t” (Suggestion: Use Javadocs or using Eclipse/Netbean IDE help).  
//==> use showOptionDialog tool