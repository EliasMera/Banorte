/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banorte;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author Taniaswag
 */
public class Banorte {
    static Menu menu = new Menu();
    RegistrarGerente introducir=new RegistrarGerente();
    private static BufferedReader stdIn=new BufferedReader (new InputStreamReader(System.in));
    private static PrintWriter stdOut=new PrintWriter(System.out,true);
    public static void main(String[] args) throws IOException {
        menu1();
    }
    
    public static void menu1() throws IOException { //Metodo que despliega el menu principal.
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);   
    }  
    
    public static void regGerente(String nombre, Integer idGer, String departamento) throws IOException {
       //Introduce los datos de un nuevo gerente.

       RandomAccessFile miArchivo=new RandomAccessFile("infoGerente.dat","rw");
        String id=idGer.toString();
        if(id.length()==9){
            try{
                if(miArchivo.length()!=0) //Si el tamano es diferente a cero se posiciona 
                                      //al final del ultimo registro para poder escribir nuevos datos.
                miArchivo.seek(miArchivo.length());
                miArchivo.writeInt(idGer);
                miArchivo.writeChars(nombre);
                miArchivo.writeChars(departamento);            
            }catch(Exception e){
                stdOut.println("Archivo no encontrado");
            }
            GerenteRegistrado g=new GerenteRegistrado();
            g.setLocationRelativeTo(null);
            g.setVisible(true);
            
        }
        else{
            ErrorGerente g=new ErrorGerente();
            g.setLocationRelativeTo(null);
            g.setVisible(true);
        }
        
        miArchivo.close();
    }
         
    public static void modProyecto(int modID) throws IOException{ //Permite cambiar ya sea datos especificos o todos los datos de un proyecto.
        menu.dispose();
        RandomAccessFile miArchivito=new RandomAccessFile("Proyectos.dat","rw");
        RandomAccessFile miArchivoFinalizados = new RandomAccessFile("ProyectoFinalizado.dat","rw");
        int IDproyecto, horasHombre,numIniciativa, tamRegistro=3217, idGer=0, opcion, term=0;
        String nombreP="",direcGral="",liderpro="", objetivo="", indicadores="", pruebaid="";
        String fecha="", status="", consultor="", cualitativas="", cuantitativas="";
        String kpiSeg="";
        boolean terminado=false;
        
        do{ 
            stdOut.println("Introduzca el numero de la opcion que desea modificar");
            stdOut.println("0)Status terminado/no terminado");
            stdOut.println("1)ID de Gerente");
            stdOut.println("2) Nombre del proyecto");
            stdOut.println("3)Direccion General Patrocinadora");
            stdOut.println("4) Lider del proyecto");
            stdOut.println("5) Objetivo");
            stdOut.println("6)Numero de Iniciativas");
            stdOut.println("7) Fecha del proyecto");
            stdOut.println("8) Estatus del proyecto");
            stdOut.println("9) Nombre del consultor");
            stdOut.println("10) Horas hombre");
            stdOut.println("11) Beneficios Cualitativos");
            stdOut.println("12) Beneficios Cuantitativos");
            stdOut.println("13) Indicadores KPI");
            stdOut.println("99) Volver a perfil");
            opcion=Integer.parseInt(stdIn.readLine());
            switch(opcion){
                case 0:
                    stdOut.println("1)Proyecto terminado.\n2)Proyecto no terminado.");
                    term=Integer.parseInt(stdIn.readLine());
                    if(term==1){
                        miArchivito.seek(modID*tamRegistro);
                        idGer=miArchivito.readInt();
                        terminado=miArchivito.readBoolean();
                        terminado=true;
                        IDproyecto=miArchivito.readInt();
                        for(int i=0; i<100; i++)
                            nombreP+=miArchivito.readChar();
                        for(int i=0; i<100; i++)
                            direcGral+=miArchivito.readChar();
                        for(int i=0; i<50; i++)
                            liderpro+=miArchivito.readChar();
                        for(int i=0; i<200; i++)
                            objetivo+=miArchivito.readChar();
                        numIniciativa=miArchivito.readInt();
                        for(int i=0; i<30; i++)
                            indicadores+=miArchivito.readChar();
                        for(int i=0; i<10; i++)
                            fecha+=miArchivito.readChar();
                        for(int i=0; i<30; i++)
                            status+=miArchivito.readChar();
                        for(int i=0; i<50; i++)
                            consultor+=miArchivito.readChar();
                        horasHombre=miArchivito.readInt();
                        for(int i=0; i<500; i++)
                            cualitativas+=miArchivito.readChar();
                        for(int i=0; i<500; i++)
                            cuantitativas+=miArchivito.readChar();
                        for(int i=0; i<30; i++)
                            kpiSeg+=miArchivito.readChar();
                        if(miArchivoFinalizados.length()!=0)
                            miArchivoFinalizados.seek(miArchivoFinalizados.length());
                        miArchivoFinalizados.writeInt(idGer);
                        miArchivoFinalizados.writeBoolean(terminado);
                        miArchivoFinalizados.writeInt(IDproyecto);
                        miArchivoFinalizados.writeChars(nombreP);
                        miArchivoFinalizados.writeChars(direcGral);
                        miArchivoFinalizados.writeChars(liderpro);
                        miArchivoFinalizados.writeChars(objetivo);
                        miArchivoFinalizados.writeInt(numIniciativa);
                        miArchivoFinalizados.writeChars(indicadores);
                        miArchivoFinalizados.writeChars(fecha);
                        miArchivoFinalizados.writeChars(status);
                        miArchivoFinalizados.writeChars(consultor);
                        miArchivoFinalizados.writeInt(horasHombre);
                        miArchivoFinalizados.writeChars(cualitativas);
                        miArchivoFinalizados.writeChars(cuantitativas);
                        miArchivoFinalizados.writeChars(kpiSeg);
                    }
                    else
                        terminado=false;
                    miArchivito.seek(modID*tamRegistro+4);
                    miArchivito.writeBoolean(terminado);
                    break;
                case 1:
                    stdOut.println("Introduzca el nuevo ID del gerente:");
                    idGer=Integer.parseInt(stdIn.readLine());
                    miArchivito.seek(modID*tamRegistro);
                    miArchivito.writeInt(idGer);
                    break;
                case 2:    
                    stdOut.println("Introduzca el nuevo nombre del proyecto.");
                    nombreP=stdIn.readLine();
                    if(nombreP.length()<100){////En caso de que el dato ingresado sea menor se llena la variable de espacios.
                        for(int i=nombreP.length(); i<100; i++)
                            nombreP=nombreP+" ";
                    }
                    else{
                        nombreP=nombreP.substring(0,100);
                    }
                    miArchivito.seek(modID*tamRegistro+9);
                    miArchivito.writeChars(nombreP);
                    break;
                case 3:
                    stdOut.println("Introduzca el nuevo departamento");
                    direcGral=stdIn.readLine();
                    if(direcGral.length()<100){
                        for(int i=direcGral.length(); i<100; i++)
                            direcGral=direcGral+" ";
                    }
                    else{
                        direcGral=direcGral.substring(0,100);
                    }   
                    miArchivito.seek(modID*tamRegistro+209);
                    miArchivito.writeChars(direcGral);
                    break;
                case 4:
                    stdOut.println("Introduzca el nuevo líder.");
                    liderpro=stdIn.readLine();
                    if(liderpro.length()<50){
                        for(int i=liderpro.length(); i<50; i++)
                            liderpro+=" ";
                    }
                    else{
                        liderpro=liderpro.substring(0,50);
                    }   
                    miArchivito.seek(modID*tamRegistro+409);
                    miArchivito.writeChars(liderpro);
                    break;
                case 5:
                    stdOut.println("Introduzca el nuevo objetivo.");
                    objetivo=stdIn.readLine();
                    if(objetivo.length()<200){
                        for(int i=objetivo.length(); i<200; i++)
                            objetivo+=" ";
                    }
                    else{
                        objetivo=objetivo.substring(0,200);
                    }   
                    miArchivito.seek(modID*tamRegistro+509);
                    miArchivito.writeChars(objetivo);
                    break;
                case 6:
                    stdOut.println("Diga el nuevo numero de iniciativas.");
                    numIniciativa=Integer.parseInt(stdIn.readLine());
                    miArchivito.seek(modID*tamRegistro+909);
                    miArchivito.writeInt(numIniciativa);
                    break;
                case 7:
                    stdOut.println("Introduzca la nueva fecha del proyecto (dd/mm/aaaa).");
                    fecha=stdIn.readLine();
                    if(fecha.length()<10){
                        for(int i=fecha.length(); i<10; i++)
                            fecha+=" ";
                    }
                    else{
                        fecha=fecha.substring(0,10);
                    }   
                    miArchivito.seek(modID*tamRegistro+973);
                    miArchivito.writeChars(fecha);
                    break;
                case 8:
                    stdOut.println("Introduzca el nuevo estatus del proyecto:");
                    status=stdIn.readLine();
                    if(status.length()<30){
                        for(int i=status.length(); i<30; i++)
                            status+=" ";
                    }
                    else{
                        status=status.substring(0,30);
                    }   
                    miArchivito.seek(modID*tamRegistro+993);
                    miArchivito.writeChars(status);
                    break;
                case 9:
                    stdOut.println("Introduzca el nuevo nombre del consultor:");
                    consultor=stdIn.readLine();
                    if(consultor.length()<50){
                        for(int i=consultor.length(); i<50; i++)
                            consultor+=" ";
                    }
                    else{
                        consultor=consultor.substring(0,50);
                    }   
                    miArchivito.seek(modID*tamRegistro+1053);
                    miArchivito.writeChars(consultor);
                    break;
                case 10:
                    stdOut.println("Introduzca las nuevas horas hombre:");
                    horasHombre=Integer.parseInt(stdIn.readLine()); 
                    miArchivito.seek(modID*tamRegistro+1153);
                    miArchivito.writeInt(horasHombre);
                    break;
                case 11:
                    stdOut.println("Introduzca los beneficios cualitativos:");
                    cualitativas=stdIn.readLine();
                    if(cualitativas.length()<500){
                        for(int i=cualitativas.length(); i<500; i++)
                            cualitativas+=" ";
                    }
                    else{
                        cualitativas=cualitativas.substring(0,500);
                    }   
                    miArchivito.seek(modID*tamRegistro+1157);
                    miArchivito.writeChars(cualitativas);
                    break;
                case 12:
                    stdOut.println("Introduzca los beneficios cuantitativos:");
                    cuantitativas=stdIn.readLine();
                    if(cuantitativas.length()<500){
                        for(int i=cuantitativas.length(); i<500; i++)
                            cuantitativas+=" ";
                    }
                    else{
                        cuantitativas=cuantitativas.substring(0,500);
                    }   
                    miArchivito.seek(modID*tamRegistro+2157);
                    miArchivito.writeChars(cuantitativas);
                    break;
                case 13:
                    stdOut.println("Introduzca los indicadores KPI:");
                    kpiSeg=stdIn.readLine();
                    if(kpiSeg.length()<30){
                        for(int i=kpiSeg.length(); i<30; i++)
                            kpiSeg+=" ";
                    }
                    else{
                        kpiSeg=kpiSeg.substring(0,30);
                    }   
                    miArchivito.seek(modID*tamRegistro+3157);
                    miArchivito.writeChars(kpiSeg);
                    break;
                case 99:
                    PerfilBanorte perfil=new PerfilBanorte();
                    perfil.setLocationRelativeTo(null);
                    perfil.setVisible(true);
                    break;
            }
        }while(opcion!=99);
    }
    }
