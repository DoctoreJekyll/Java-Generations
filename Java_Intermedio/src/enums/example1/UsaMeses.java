package enums.example1;

public class UsaMeses {
    public static void main(String[] args) {
        Meses mes = Meses.FEBRERO;
        System.out.println(mes);


        for (Meses m : Meses.values()) {
            System.out.println(m);
        }

        Meses mes2 = Meses.FEBRERO;

        switch (mes2) {
            case ENERO:
                System.out.println("Enero");
                break;
            case FEBRERO:
                System.out.println("Febrero");
                break;
            case MARZO:
                System.out.println("Marzo");
                break;
        }

    }
}
