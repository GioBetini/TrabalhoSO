package controller;

import java.io.IOException;

public interface IArquivosTigerKing {

    public String leArquivoTigerKing() throws IOException;

    public String[] separaData(String wiki) throws IOException;

    public String[] separaView(String wiki) throws IOException;

}
