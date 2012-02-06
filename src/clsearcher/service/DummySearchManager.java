package clsearcher.service;

import java.util.ArrayList;
import java.util.List;
import clsearcher.domain.CommandSearchCriteria;

public class DummySearchManager implements SearchManager{

	public void buildUrls(CommandSearchCriteria criteria){}
	
	@Override
	public List<Item> search() {
		 // in reality, pull raw matched item via WWWGetter, form it in Item
		List<Item> items = new ArrayList<Item>();
		items.add( new Item("www.dummy.com", "10 lb lego", "sno"));
		items.add( new Item("www.dummy.org", "20 lb lego", "see"));
		
		return items;
	}

	@Override
	public boolean isListEmpty() {
		return false;
	}

	@Override
	public void emptyList() {
		
	}
	
}
