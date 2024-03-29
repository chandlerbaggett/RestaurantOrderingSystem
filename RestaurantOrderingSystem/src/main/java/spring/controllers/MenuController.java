package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import spring.formModels.AddMenuItem;
import spring.formModels.EditMenuItem;
import spring.formModels.RemoveMenuItem;
import spring.models.Menu;
import spring.models.MenuItem;
import utils.DBManager;

@Controller
public class MenuController {

	private Menu menu = new Menu();

	public void createMenu(){
		this.menu = new Menu();	
		DBManager.saveModel(menu);
	}
	
	@GetMapping("/viewMenu")
	public String loadPage(Model model) {
		Menu menu = DBManager.getRestaurant().getMenu();

		model.addAttribute("lists", menu.getMenuItems());

		return "viewMenu";
	}	

	public Menu viewMenu(){		
		return menu;
	}
	
	@PostMapping("/viewMenu/add")
	public ModelAndView AddMenuItem(AddMenuItem menuItem, Model model){
		addItem(menuItem);
		return new ModelAndView(new RedirectView("/RestaurantOrderingSystem/viewMenu/"));
	}

	@PostMapping("/viewMenu/remove")
	public ModelAndView RemoveMenuItem(RemoveMenuItem menuItem, Model model){
		removeItem(menuItem);
		return new ModelAndView(new RedirectView("/RestaurantOrderingSystem/viewMenu/"));
	} 

	@PostMapping("/viewMenu/edit")
	public ModelAndView EditMenuItem(EditMenuItem menuItem, Model model){
		editItem(menuItem);
		return new ModelAndView(new RedirectView("/RestaurantOrderingSystem/viewMenu/"));
	}

	public void addItem(AddMenuItem item){
		Menu menu = DBManager.getRestaurant().getMenu();
		MenuItem menuItem = new MenuItem();
		menuItem.setName(item.getName());
		menuItem.setDescroption(item.getDescription());
		menuItem.setPrice(item.getPrice());	
		menu.addMenuItem(menuItem);
		DBManager.saveModel(menuItem);
		DBManager.saveModel(menu);
	}
	
	
	public void removeItem(RemoveMenuItem item){
		Menu menu = DBManager.getRestaurant().getMenu();
		MenuItem itemToRemove = null;
		for (MenuItem loopedItem : menu.getMenuItems()){
			if (loopedItem.getId() == item.getId()) {
				itemToRemove = loopedItem;
			}
		}
		if (itemToRemove != null){
			menu.removeMenuItem(itemToRemove);
		}
		DBManager.saveModel(menu);
	}
	
	public void editItem(EditMenuItem item){

		Menu menu = DBManager.getRestaurant().getMenu();

		for (MenuItem loopedItem : menu.getMenuItems()){
			if (loopedItem.getId() == item.getId()){
				loopedItem.setName(item.getName());
				loopedItem.setDescroption(item.getDescription());
				loopedItem.setPrice(item.getPrice());
			}
		}
		DBManager.saveModel(menu);
	}	
	
	
}
