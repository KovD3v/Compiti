import java.util.HashMap;
import java.util.Random;

public class Studente {
    private HashMap<String, Integer> voti;

    public Studente() {
        this.voti = new HashMap<String, Integer>();
        this.voti.put("italiano", this.generaVoto());
        this.voti.put("matematica", this.generaVoto());
        this.voti.put("inglese", this.generaVoto());
        this.voti.put("informatica", this.generaVoto());
        this.voti.put("storia", this.generaVoto());
        this.voti.put("geografia", this.generaVoto());
        this.voti.put("arte", this.generaVoto());
        this.voti.put("musica", this.generaVoto());
        this.voti.put("scienze", this.generaVoto());
        this.voti.put("educazione fisica", this.generaVoto());
    }

    public HashMap<String, Integer> getVoti() {
        return this.voti;
    }

    public String verificaPromozione() {
        int insufficienze = 0;
        for (Integer voto : this.voti.values()) {
            if (voto < 6) {
                insufficienze++;
                if (insufficienze > 3){
                    return "Bocciato";
                }
            }
        }
        if (insufficienze >= 1) {
            return "Rimandato";
        } else {
            return "Promosso";
        }
    }

    private int generaVoto() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    public static void printStudente(Studente studente) {
        System.out.println("Voti di " + studente + ":");
        for (String materia : studente.getVoti().keySet()) {
            System.out.println(materia + ": " + studente.getVoti().get(materia));
        }
        System.out.println("Promozione: " + studente.verificaPromozione());
    }
}