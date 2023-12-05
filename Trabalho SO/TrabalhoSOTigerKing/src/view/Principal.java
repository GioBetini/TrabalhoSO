package view;

import java.io.IOException;

import controller.IArquivosTigerKing;
import controller.TigerKingController;

public class Principal {
    public static void main(String[] args) throws Exception {
        IArquivosTigerKing tkCont = new TigerKingController();
        try {
            String wiki = tkCont.leArquivoTigerKing();
            String[] view = tkCont.separaView(wiki);
            String[] data = tkCont.separaData(wiki);
            System.out.println("Segue as relações de visualizações da página do documentário Tiger King a cada dia do mês de Setembro de 2021:");
                    for (int i = 0; i < data.length; i++) {
                        if (view[i].contains("}]}")) {
                            System.out.println("No dia "+data[i]+" houveram "+view[i].substring(0,view[i].length()-3)+" visualizações");
                        } else {
                            System.out.println("No dia "+data[i]+" houveram "+view[i]+" visualizações");
                        }
                    }
        }catch(IOException e){
        e.printStackTrace();}
    }

}
