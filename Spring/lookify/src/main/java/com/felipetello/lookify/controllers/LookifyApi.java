package com.felipetello.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipetello.lookify.models.Lookify;
import com.felipetello.lookify.services.LookifyService;

@RestController
public class LookifyApi {
	private final LookifyService lookifyService;
	public LookifyApi(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("/api/lookifies")
	public List<Lookify> index(){
		return lookifyService.allLookifies();
	}
	@RequestMapping(value = "/api/lookifies", method=RequestMethod.POST)
	public Lookify create(@RequestParam(value="title")String title,
			@RequestParam(value = "artist")String artist,
			@RequestParam(value = "rating") Integer rating) {
		Lookify lookify = new Lookify(title, artist, rating);
		return lookifyService.createLookify(lookify);
	}
	@RequestMapping("/api/lookifies/{id}")
	public Lookify show(@PathVariable("id") Long id) {
		Lookify lookify = lookifyService.findLookify(id);
		return lookify;
	}
	@RequestMapping(value = "/api/lookifies/{id}", method=RequestMethod.PUT)
	public Lookify update(@PathVariable("id") Long id,
			@RequestParam(value = "title")String title,
			@RequestParam(value = "artist")String artist,
			@RequestParam(value = "rating") Integer rating) {
		Lookify lookify = lookifyService.findLookify(id);
		lookify.setTitle(title);
		lookify.setArtist(artist);
		lookify.setRating(rating);
		return lookifyService.updateLookify(lookify);
	}
	@RequestMapping(value = "/api/lookifies/{id}", method = RequestMethod.DELETE)
	private void destroy(@PathVariable("id")Long id) {
		lookifyService.deleteLookify(id);
	}
}
