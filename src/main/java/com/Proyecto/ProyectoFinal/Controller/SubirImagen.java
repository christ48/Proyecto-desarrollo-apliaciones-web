/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lossa
 */
public class SubirImagen {
   
    public static void saveFile(String uploadDir,String fileName,MultipartFile multipartFile)throws IOException{
        Path uploadPath=Paths.get(uploadDir);
        
        if(!Files.exists(uploadPath)){
               Files.createDirectories(uploadPath);
        }
        try(InputStream impuStream=multipartFile.getInputStream()){
            Path filePath=uploadPath.resolve(fileName);
            Files.copy(impuStream,filePath,StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            throw new IOException("no se puedo subir la imagen"+fileName,e);
        }
    
    }

    private SubirImagen() {
    }
    
}
