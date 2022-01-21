package com.example.demo.controller;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Asset;
import com.example.demo.service.CassandraAssetService;

@Controller
@RequestMapping("/api")

public class CassandraAssetController {
	
	@Autowired
	private CassandraAssetService assetService;
	
	@GetMapping("/ShowFormForAdd")
	public String ShowFormForAdd(Model model)
	{
		Asset asset = new Asset();
		model.addAttribute("saveAsset",asset);
		return "Asset-form";
	}
	
	
	//Entering values into asset table
	@PostMapping("/asset")
    private String creat(@ModelAttribute("saveAsset") Asset asset ){
		assetService.save(asset);
		return "redirect:/api/assetList" ;
		 
	}
	
	
	//Getting all the data from Asset
	@GetMapping("/assetList")
	private String allData(Model model){
		List<Asset> data = (List<Asset>) assetService.findAll();
		model.addAttribute("asset", data);
		return "Asset-list";
	}
	//Updating asset data
	@PutMapping("/asset")
	private Asset update(@RequestBody Asset asset,Model model) {
		assetService.update(asset);
		return asset;
	}
	//Total number of data present
	@GetMapping("asset/count")
	private long count() {
		return assetService.count();
	}

	
	//Delete by id
	@GetMapping("delete")
	private String deleteById( @RequestParam("id") String id) {
		assetService.deleteById(id);
		return "redirect:/api/assetList";
	}
	

	//Deleting all the data
	@DeleteMapping("/asset")
	private String delete(Model model) {
		assetService.deleteAll();
		return "All the data deleted";
	}
	//Finding by id
	@GetMapping("asset/{id}")
	private Optional<Asset> byId(@PathVariable String id){
		Optional<Asset> byId = assetService.findById(id);
		return byId;
	}
	@GetMapping("/asset1/{name}")
	private List<Asset> byName(@PathVariable String name){
		List<Asset> byName = assetService.findByName(name);
		return byName;
	}
}

