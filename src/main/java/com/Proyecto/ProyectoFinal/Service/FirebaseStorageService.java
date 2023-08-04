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
   
   final String BucketName="tallerproyecto-b1936.appspot.com";
   
   final String rutaSuperiorStorage="taller_proyecto";
   
   final String rutaJsonFile="firebase";
   
   final String archivoJsonFile="tallerproyecto-b1936-firebase-adminsdk-fblv1-467af74319";
}
