/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.InvalidMapException;
import java.io.File;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author fernandopucci
 */
public class IconGenerator {


    public IconGenerator(Map<Integer, ImageIcon> mapaArquivosIcones) throws InvalidMapException {

        if (mapaArquivosIcones == null) {
            throw new InvalidMapException("Mapa de Arquivos nulo!");
        }

        this.mapaArquivosIcones = mapaArquivosIcones;

    }

    private Map<Integer, ImageIcon> mapaArquivosIcones;
    private Map<Integer, File> mapaArquivos;

    public Map<Integer, File> getMapaArquivos() {

        return mapaArquivos;

    }

    public Map<Integer, ImageIcon> getMapaArquivosIcones() throws InvalidMapException {

        return mapaArquivosIcones;

    }

}
