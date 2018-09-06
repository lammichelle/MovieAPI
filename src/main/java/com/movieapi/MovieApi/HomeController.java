package com.movieapi.MovieApi;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	@Autowired
	FavMovieRepository favRepo;
	
	
	@RequestMapping("/")
	public ModelAndView index() {
//		RestTemplate restTemplate = new RestTemplate();
//		Result result = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=64e3c05ea0f7c70ed4d7e5f187e45acd&query=Jack+Reacher", Result.class);
//		ArrayList<Movie> movie = result.getResults();
		return new ModelAndView("index");
		
	}
	
	
	@RequestMapping("/results")
	public ModelAndView results(@RequestParam("keyword")String keyword) {
		RestTemplate restTemplate = new RestTemplate();
		Result result = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=64e3c05ea0f7c70ed4d7e5f187e45acd&query=" + keyword , Result.class);
		ArrayList<Movie> movie = result.getResults();
		return new ModelAndView("results","mtest", movie);
		
	}
	
	@RequestMapping("/add/{id}/{title}/{video}/{overview}/{release_date}")
    public ModelAndView add(@PathVariable("id") Integer id, @PathVariable("title") String title,@PathVariable("video") Boolean video,
    		@PathVariable("overview") String overview,  @PathVariable("release_date")String releasedate) {
      
        FavMovie favMovie = new FavMovie(id, title,video, overview, releasedate);
        favRepo.save(favMovie);
        
        System.out.println(favMovie);
        return new ModelAndView("redirect:/");
        
        
    }
	 
	
	@RequestMapping("/add")
	public ModelAndView viewFave() {
		return new ModelAndView("add", "mtest1", favRepo.findAll());
	}
	
	@RequestMapping("{id}/delete")
	public ModelAndView delete(@PathVariable("id")Integer id) {
		favRepo.deleteById(id);
		return new ModelAndView("redirect:/add");
	}
	
	
	
}
