package com.taiji.manager.sevice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taiji.manager.dto.MenuDto;
import com.taiji.manager.entity.Menu;
import com.taiji.manager.repository.MenuRepository;

@Service
public class MenuService {
	@Autowired
	private MenuRepository menuRepository;
	
//	@Autowired
//	private Menu menu;
	
	public void save(MenuDto menuDto) {
		Menu menu = new Menu();
		BeanUtils.copyProperties(menuDto,menu);
		menuRepository.save(menu);
	}

	public void delete(String id) {
		menuRepository.delete(id);
	}

	public void updateMenu(String url, String id) {
		menuRepository.updateMenu(url, id);
	}


	
	
}
