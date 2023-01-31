package com.web.aluminio.controller;

import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.web.aluminio.dto.Imagen;
import com.web.aluminio.model.Trabajo;
import com.web.aluminio.services.CloudinaryServices;
import com.web.aluminio.services.TrabajoServices;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
@RequestMapping("/trabajo")
public class TrabajoController {

	@Autowired
	private TrabajoServices trabRepo;

	@Autowired
	CloudinaryServices cloudinaryService;

	@GetMapping
	public @ResponseBody Iterable<Trabajo> getAllTrabajos() {
		return trabRepo.findAllTrabajos();
	}

	public Imagen uploadImage(MultipartFile multipartFile) throws IOException {

		BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
		if (bi == null) {
			return null;
		}

		Map result = cloudinaryService.upload(multipartFile);
		Imagen imagen = new Imagen((String) result.get("url"), (String) result.get("public_id"));
		return imagen;
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseBody
	public Trabajo createTrabajo(@RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile,
			@RequestPart("trabajo") Trabajo trabajo) throws IOException {
		System.out.print(trabajo);
		if (trabajo.getId() == 0)
			trabajo.setId(null);
		Imagen auximagen;
		if (multipartFile != null) {
			// elimino la imagen almacenada en el servidor de imagenes
			if (trabajo.getImagenId()!= null) cloudinaryService.delete(trabajo.getImagenId());
			// subo la nueva imagen al servidor y asigno las propiedades al objeto trabajo
			auximagen = this.uploadImage(multipartFile);
			trabajo.setImagenUrl(auximagen.getImagenUrl());
			trabajo.setImagenId(auximagen.getImagenId());
		}
		return trabRepo.save(trabajo);
	}

	@DeleteMapping("/admin/delete/{id}")
	public boolean borrarTrabajo(@PathVariable(value = "id") Long id) throws IOException {
		Trabajo trab = trabRepo.getByIdTrabajo(id);
		if (trab.getImagenId()!= null) cloudinaryService.delete(trab.getImagenId());
		return trabRepo.bajaFisica(id);
	}

	@GetMapping("/{id}")
	public Trabajo getCategoriaById(@PathVariable(value = "id") Long catId) {
		Trabajo categ = trabRepo.getByIdTrabajo(catId);
		return categ;
	}

}
