import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import javax.sound.sampled.*;

public class TextChanger {
    public static void main (String[]args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Scanner scanner = new Scanner(System.in);
        
        
        File soundFile = new File("retro-city-14099.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        
        
        //start of the file changing
        String temporaryHoldofTXT = "";
        System.out.println("Hi, this is what the following file says: \n");
        
        try {
            FileReader reader = new FileReader("Words.txt");
            int data = reader.read();
            while (data != -1) {
                System.out.print ((char)data);
                temporaryHoldofTXT += (char)data;
                data = reader.read();
            }
            reader.close();       }
        
        catch (IOException e) {
            e.printStackTrace();
        } 
        
        
        System.out.println("\nNow lets put some new stuff into the file, please type whatever it is you wish to add, if you wish to end the program, type no: ");
        
       String newInput = "";
        while(!newInput.equals("no")){
        
        	newInput = scanner.nextLine();
        	
        	if(newInput.equals("no")) {
        		break;
        	}
        	try {
        		FileWriter writer = new FileWriter ("Words.txt");
	        	
	        	temporaryHoldofTXT += newInput;
	        	writer.write(temporaryHoldofTXT);
	        	writer.close();
	        }
	        catch(IOException e) {
	        	e.printStackTrace();
	        }
	        System.out.println("\nNew text:\n" + temporaryHoldofTXT);
	        System.out.println("Type more to add it as well");
        
        }
        scanner.close();
        clip.close();
        
        
        
     
        
        
        
        
        
    }
}