package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TigerKingController implements IArquivosTigerKing {

    public TigerKingController() {
        super();
    }

    @Override
    public String leArquivoTigerKing() throws IOException {
        String newDir = "C:\\TEMP";
        File diretorio = new File(newDir);
        String newArquivo = "wiki.json";
        File arq = new File(diretorio, newArquivo);
        if (!arq.exists()) {
            throw new IOException();
        }

        StringBuffer stringBuffer = new StringBuffer();
        FileInputStream fileInputStream = new FileInputStream(arq);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuffer.append(line + "\n");
            line = bufferedReader.readLine();
        }
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
        // System.out.println(stringBuffer.toString());
        String wiki = stringBuffer.toString();
        return wiki;
    }

    @Override
    public String[] separaData(String wiki) throws IOException {
        String[] data = new String[10000];
        String[] timestamp = new String[30];
        int j = 0;
            String[] vet = wiki.split(",");
            for ( String a : vet) {
                data = a.split(":");
                for (int i = 0; i <= data.length - 1; i++){
                    if (data[i].contains("202109")){
                        timestamp[j] = data[i];
                        String ano = timestamp[j].substring(1,5 );
                        String mes = timestamp[j].substring(5, 7);
                        String dia = timestamp[j].substring(7, 9);
                        timestamp[j] = dia + "/" + mes + "/" + ano;
                        j += 1;
                    }
                }
            } 
                
            return timestamp;
            }
    
    
    

    @Override
    public String[] separaView(String wiki) throws IOException {
        IArquivosTigerKing tkCont = new TigerKingController();
        String [] data = new String [10000];
        String[] view = new String[30];
        int j = 0;
        wiki = tkCont.leArquivoTigerKing();
        String[] vet = wiki.split(",");
        for (String a : vet) {
        data = a.split(":");
        for (int i = 0; i <= data.length - 1; i++) {
                if (data[i].contains("}")) {
                    view[j] = data[i].substring(0,data[i].length()-1);
                    System.out.println(view[j]);
                    j += 1;
                }
            }
        }
        
        return view;
    }
}

