import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DatesTest
{

    public void Play()
    {
        DateFormatterExample();
    }

    private void DateOne()
    {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

    private void DateExample()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la fecha del evento (dd/MM/yyyy)");
        String date = sc.nextLine();

        //Define el formateador
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Parsea la cadena a LocalDate
        LocalDate eventDate = LocalDate.parse(date, formatter);
        System.out.println("La fecha del evento es " + eventDate);

        //Calcular la fecha 30 dias antes del evento
        LocalDate dateRemember = eventDate.minusDays(30);
        System.out.println("Recordatorio (30 dias antes) " + dateRemember.format(formatter));


        //Comparar fecha evento con actual
        LocalDate dateNow = LocalDate.now();
        if (eventDate.isAfter(dateNow)){
            System.out.println("El evento no ha ocurrido");
        }
        else if (eventDate.isBefore(dateNow)){
            System.out.println("El evento ya ocurrio");
        }else{
            System.out.println("El evento es hoy");
        }

        sc.close();
    }

    private void DateFormatterExample()
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //Definimos un formateo para la fecha y hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        //Formateo
        String formattedDate = now.format(formatter);
        System.out.println(formattedDate);
    }

}
