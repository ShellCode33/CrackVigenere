package vigenere.crack.crypto;


/**
 * Created by shellcode on 2/3/17.
 */
public class Main {
    public static void main(String[] args) {

        String cipher = "Veyysuiz k uuwj qfmnd ml wqu wecspe vc drwsov lw apui do ziycovve wimw sov glo vedyuzzewinl jpekuo ! Mmhpfjwiyrnslu e'isd ge hyt ? Vr rozafaiv pe msdw bf mmgorejc fjx qeesa gngsscmbdc b tescir kg mr glo isl yvjwi vsnysf hye vi twvuv";

        //Si des arguments sont passés en paramètre du programme, on utilise les arguments comme texte à traiter
        if(args.length > 0) {
            cipher = args[0];
            for(int i = 1; i < args.length; i++)
                cipher += " " + args[i];
        }

        if(cipher.length() <= 0) {
            System.out.println("Please customize the source code or give arguments to the program.");
            return;
        }

        FrequentialAnalysis frequentialAnalysis = new FrequentialAnalysis(cipher);
        frequentialAnalysis.printFrequences();
        char bestCharFrequency = frequentialAnalysis.getNthLetterWithHighestFrequency(0);
        System.out.println("Highest frequency : '" + bestCharFrequency + "' which represents " + (int)(frequentialAnalysis.getFrequenceOf(bestCharFrequency)*100) + "% of all the letters");

        Vigenere vigenere = new Vigenere(frequentialAnalysis);
        vigenere.crack();
    }
}
