package spring.models;

import javax.persistence.Embeddable;

@Embeddable
public class Permission {
	private boolean canMakeOrders;
	private boolean canViewRestaurantOrders;
	private boolean canManageRestaurant;
	
	public Permission() {
		super();
	}

	public Permission(boolean canMakeOrders, boolean canViewRestaurantOrders, boolean canManageRestaurant) {
		super();
		this.canMakeOrders = canMakeOrders;
		this.canViewRestaurantOrders = canViewRestaurantOrders;
		this.canManageRestaurant = canManageRestaurant;
	}

	public boolean canMakeOrders() {
		return canMakeOrders;
	}
	
	public boolean canViewRestaurantOrders() {
		return canViewRestaurantOrders;
	}
	
	public boolean canManageRestaurant() {
		return canManageRestaurant;
	}
}
