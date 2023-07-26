/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.ProyectoFinal.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lossa
 */
@Service
public interface FirebaseStorageService {
   public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
   
   final String BucketName="proyecto-desarrollo-web-7d3f7.appspot.com";
   
   final String rutaSuperiorStorage="Proyecto-Desarrollo-Web";
   
   final String rutaJsonFile="firebase";
   
   final String archivoJsonFile="proyecto-desarrollo-web-7d3f7-firebase-adminsdk-wivod-cce208cb6f";
}
