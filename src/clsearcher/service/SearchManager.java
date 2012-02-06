package clsearcher.service;
import java.io.Serializable;
import java.util.List;

import clsearcher.domain.CommandSearchCriteria;

/**provides interface between clsercher.service and clsercher.web **/
public interface SearchManager extends Serializable{
	void buildUrls(CommandSearchCriteria criteria);
	List<Item> search();
	boolean isListEmpty();
	void emptyList();
}