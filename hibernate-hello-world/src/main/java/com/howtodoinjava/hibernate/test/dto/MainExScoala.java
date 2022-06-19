package com.howtodoinjava.hibernate.test.dto;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExScoala {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Scanner scanner = new Scanner(System.in);
        int option = 0;


        do{
            System.out.println("optiunea 1 adauga Elev\n" +
                    "optiunea 2 adauga profesor\n" +
                    "optiunea 3 adauga Clasa\n" +
                    "Optiuena 4 modifica elev dupa nume si prenume\n" +
                    "Optiuena 5 modifica profesor dupa nume  si prenume\n" +
                    "Optiunea 6 afisare toti elevii din clasa\n" +
                    "Optiunea 7 afisare tuturor profesorilor\n" +
                    "Optiunea 8 afisare  toti elevi care au media > x\n" +
                    "optiunea 9 afisare toate clasele\n" +
                    "optiunea 10 stergere elev\n" +
                    "optiunea 11 asignare profesor la o clasa\n" +
                    "optiunea 12 asignare elev la o clasa\n" +
                    "optiunea 13 adauga concurs la elev\n" +
                    "optiunea 14 adauga concurs\n" +
                    "optiunea 15 afisare concursuri\n" +
                    "optiunea 0 exit");

            option = scanner.nextInt();
            switch (option){
                case 1:
                    Elev elev = new Elev();
                    System.out.println("Introdu nume elev:");
                    scanner.nextLine();
                    String numeElev = scanner.nextLine();

                    System.out.println("Introdu prenume elev:" );
                    String prenumeElev = scanner.nextLine();

                    System.out.println("Introdu medie elev:");
                    double medie = scanner.nextDouble();
                    elev.setNume(numeElev);
                    elev.setPrenume(prenumeElev);
                    elev.setMedie(medie);
                    ElevDAO elevDAO = new ElevDAO();
                    elevDAO.insertorupdateElevi(elev,session);
                    break;

                case 2:
                    Profesor profesor = new Profesor();
                    System.out.println("Introdu nume profesor:");
                    scanner.nextLine();
                    String numeProfesor = scanner.nextLine();
                    System.out.println("Introdu prenume profesor:");
                    String prenumeProfesor = scanner.nextLine();
                    System.out.println("Introdu materie profesor:");
                    String materie = scanner.nextLine();
                    profesor.setNume(numeProfesor);
                    profesor.setPrenume(prenumeProfesor);
                    profesor.setMaterie(materie);
                    ProfesorDAO profesorDAO = new ProfesorDAO();
                    profesorDAO.insertOrUpdateProfesori(profesor,session);
                    System.out.println("Profesorul " + numeProfesor + prenumeProfesor + " a fost adaugat in lista");
                    break;

                case 3:
                    Clasa clasa = new Clasa();
                    System.out.println("Introdu nume clasa:");
                    scanner.nextLine();
                    String numeClasa = scanner.nextLine();
                    clasa.setNumeClasa(numeClasa);
                    ClasaDAO clasaDAO = new ClasaDAO();
                    clasaDAO.insertORUpdateClasa(clasa,session);
                    break;

                case 4:
                   ElevDAO elevDAO1 = new ElevDAO();
                    System.out.println("Introdu nume elev:");
                    scanner.nextLine();
                   String numeE = scanner.nextLine();
                    System.out.println("Introdu prenume elev:");
                   String prenumeE = scanner.nextLine();
                   Elev elevE = elevDAO1.findbynameandsurname(numeE,prenumeE,session);
                   if(elevE != null){
                       System.out.println("Introdu medie noua:");
                       double mediaNoua = scanner.nextDouble();
                       elevE.setMedie(mediaNoua);
                       elevDAO1.insertorupdateElevi(elevE,session);
                   }
                   break;

                   case 5:
                       ProfesorDAO profesorDAO1 = new ProfesorDAO();
                       System.out.println("Introdu nume profesor:");
                       scanner.nextLine();
                       String numePro = scanner.nextLine();
                       System.out.println("Introdu prenume profesor");
                       String prenumePro = scanner.nextLine();
                       Profesor profesor1 = profesorDAO1.findByNameAndSurname(numePro,prenumePro,session);
                       if(profesor1 != null){
                           System.out.println("Introdu materie noua:");
                           String materieNoua = scanner.nextLine();
                           profesor1.setMaterie(materieNoua);
                           profesorDAO1.insertOrUpdateProfesori(profesor1,session);
                       }
                       break;

                    case  6:
                        ElevDAO elevAfisare = new ElevDAO();
                        System.out.println(elevAfisare.showElevi(session));
                        break;


                case 7:
                    ProfesorDAO afisareProfesori = new ProfesorDAO();
                    System.out.println(afisareProfesori.printProfesori(session));
                    break;


                case 8:
                    ElevDAO medieElevPeste = new ElevDAO();
                    System.out.println("Introdu media:");
                    scanner.nextLine();

                    double alegereMedie = scanner.nextDouble();
                    System.out.println(medieElevPeste.overAverage(alegereMedie,session));
                    break;


                case 9:
                    ClasaDAO afisareClase = new ClasaDAO();
                    System.out.println( afisareClase.printClasa(session));
                    break;

                case 10:
                    ElevDAO stergereElev = new ElevDAO();
                    System.out.println("Indrodu nume elev:");
                    scanner.nextLine();
                    String numeDeSters = scanner.nextLine();
                    System.out.println("Introdu prenume elev:");
                    String prenumeDeSters = scanner.nextLine();
                    Elev elevSters = stergereElev.findbynameandsurname(numeDeSters,prenumeDeSters,session);
                    if( elevSters!= null){
                        stergereElev.deleteElevi(elevSters,session);
                        System.out.println("Elevul a fost sters.");
                    }
                    break;

                case 11:
                    ClasaDAO clasaDAO1 = new ClasaDAO();
                    ProfesorDAO profesorDAO2 = new ProfesorDAO();
                    System.out.println("Introdu nume clasa:");
                    scanner.nextLine();
                    String numeClasaCautata = scanner.nextLine();

                    System.out.println("Introdu nume profesor:");
                    String numeProfesorCautat = scanner.nextLine();
                    System.out.println("introdu prenume profesor:");
                    String prenumeProfesorCautat = scanner.nextLine();

                    Clasa clasaCautata = clasaDAO1.findByName(numeClasaCautata,session);
                    Profesor profesorCautat  = profesorDAO2.findByNameAndSurname(numeProfesorCautat,prenumeProfesorCautat,session);

                    if(clasaCautata!= null && profesorCautat!= null){
                      clasaCautata.setProfesor(profesorCautat);
                        System.out.println("Profesorul a fost asignat clasei " + numeClasaCautata );
                    }else{
                        System.out.println("Date introduse gresit!");
                    }
                    break;

                case 12:
                    ClasaDAO asignareElev = new ClasaDAO();
                    ElevDAO elevAsignat = new ElevDAO();
                    System.out.println("Introdu nume clasa:");
                    scanner.nextLine();
                    String numeClasaAsignata = scanner.nextLine();
                    System.out.println("Introdu nume elev:");
                    String numeElevAsignat = scanner.nextLine();
                    System.out.println("Introdu prenume elev:");
                    String prenumeElevAsignat = scanner.nextLine();

                    Clasa clasa1 = asignareElev.findByName(numeClasaAsignata,session);
                    Elev elev1 = elevAsignat.findbynameandsurname(numeElevAsignat,prenumeElevAsignat,session);
//                    List<Elev> listaElevAsignat = new ArrayList<Elev>();
//                    listaElevAsignat.add(elev1);
                    if(clasa1 != null && elev1 != null){
                        clasa1.getElev().add(elev1);
                        asignareElev.insertORUpdateClasa(clasa1,session);
                        System.out.println("Elevul a fost asignat clasei " + numeClasaAsignata);
                    }else {
                        System.out.println("Date introduse gresit.");
                    }
                    break;

                case 13:
                    ElevDAO elevDAO2 = new ElevDAO();
                    ConcursuriDAO concursuriDAO = new ConcursuriDAO();
                    System.out.println("Introdu nume elev:");
                    scanner.nextLine();
                    String numeElev1 = scanner.nextLine();

                    System.out.println("Introdu prenume elev:");
                    String prenumeElev1 = scanner.nextLine();
                    System.out.println("Introdu nume concurs:");
                    String numeConcurs = scanner.nextLine();
                    System.out.println("Introdu premiul obtinut:");
                    int premiulObtinut = scanner.nextInt();

                    Elev elev2 = elevDAO2.findbynameandsurname(numeElev1,prenumeElev1,session);
                    Concursuri concurs = concursuriDAO.findByName(numeConcurs,session);
                    if(elev2 != null && concurs != null){
                        List<Concursuri> concursuriList = new ArrayList<Concursuri>();
                        concursuriList.add(concurs);
                        elev2.setConcursuri(concursuriList);
                        System.out.println("Concursul a fost adaugat la elevul " + numeElev1 + prenumeElev1);
                    }else{
                        System.out.println("Datele au fost introduse gresit");
                    }
                    break;

                case 14:
                    ConcursuriDAO concursuriDAO1 = new ConcursuriDAO();
                    Concursuri concursuri = new Concursuri();
                    System.out.println("Introdu nume concurs:");
                    scanner.nextLine();
                    String concurs1 = scanner.nextLine();

                    System.out.println("Introdu premiu:");
                    int premiu = scanner.nextInt();
                    concursuri.setNume(concurs1);
                    concursuri.setPremiu(premiu);
                    concursuriDAO1.insertOrUpdateConcursuri(concursuri,session);
                    System.out.println("Concursul " + concurs1 + " a fost adaugat");
                    break;

                case 15:
                    ConcursuriDAO concursuriDAO2 = new ConcursuriDAO();
                    System.out.println(concursuriDAO2.afisareConcursuri(session));
                    break;
            }
        }while(option != 0);

        HibernateUtil.shutdown();
    }
}

//lectia 5 = 2 si 4 din zip-ul lui George
// lectia 6 - ex 4 si 5
// lectia 7 - ex 4 si 3
//lectia 8 - ex 4
//lectia 10 - ex 3