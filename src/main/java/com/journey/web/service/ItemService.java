package com.journey.web.service;

import com.journey.web.domain.item.Item;
import com.journey.web.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }

    // 전체 상품 목록 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 특정 상품 조회
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}